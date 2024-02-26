// Will create an object that allows you to find the integral, deriv
// of two points, or solve for x. Each time you apply deriv or anti
// it updates the eq
public class Calculator {
    private String integralEq;
    private String derivEq;
    private Equation eq;
    private Bounds b1tob2;

    //Accepts eq
    public Calculator(Equation eq) {
        this.eq = eq;
    }
    
    //Solves for x in given eq
    public double solveForX(int x) { //same idea can be applied for integral and derivative
        double firstValue = eq.getConstants().get(0) * (Math.pow(x, eq.getExponents().get(0))); //maybe make get methods into variables so simpler
        double sum = firstValue;
        for (int i = 0; i < eq.getSymbols().size(); i++) {
            if(eq.getSymbols().get(i) == '+') {
                sum = sum + eq.getConstants().get(i + 1) * (Math.pow(x, eq.getExponents().get(i + 1)));
            }else {
                sum = sum - eq.getConstants().get(i + 1) * (Math.pow(x, eq.getExponents().get(i + 1)));
            }
        }
        return sum;
    }
    public String currentEq() {
        return eq.toString();
    }
    public String integralOfEq() {

        for(int i = 0; i < eq.getConstants().size(); i++) {
            double newValue = eq.getConstants().get(i) / (eq.getExponents().get(i) + 1);
            eq.getConstants().set(i, newValue);
            int newExponent = eq.getExponents().get(i) + 1;
            eq.getExponents().set(i, newExponent);
        }
        integralEq = eq.getConstants().get(0) + "x^" + eq.getExponents().get(0);
        for(int i = 0; i < eq.getSymbols().size(); i++) {
            integralEq = integralEq +  " " + eq.getSymbols().get(i) + " " + eq.getConstants().get(i + 1) + "x^" + eq.getExponents().get(i + 1);
        }
        return integralEq;
    }

    // Solves for integral of eq w bounds
    public double integralWBounds(Bounds b1tob2) {
        integralOfEq();
        
        double lowerBound = solveForX(b1tob2.getx1());
        double upperBound = solveForX(b1tob2.getx2());

        return upperBound - lowerBound;
    }

    //deriv of eq
    public String derivOfEq() {

        for(int i = 0; i < eq.getConstants().size(); i++) {
            double newValue = eq.getConstants().get(i) * eq.getExponents().get(i);
            eq.getConstants().set(i, newValue);
            int newExponent = eq.getExponents().get(i) - 2;
            eq.getExponents().set(i, newExponent);
        }
        String derivEq = eq.getConstants().get(0) + "x^" + eq.getExponents().get(0);
        for(int i = 0; i < eq.getSymbols().size(); i++) {
            String exponentCheck = "" + eq.getExponents().get(i + 1);
            if (!exponentCheck.contains("-")) {
                derivEq = derivEq +  " " + eq.getSymbols().get(i) + " " + eq.getConstants().get(i + 1)
                + "x^" + eq.getExponents().get(i + 1);
            }
        }
        return derivEq;
    }

    // Allows user to change eq to calculate different values
    public void newEq(String equation) {
        this.eq = new Equation(equation);
    }
}