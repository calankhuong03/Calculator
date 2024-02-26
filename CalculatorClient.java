// Tester
// Format must be in #x^3 format
// This program is flexible and allows spacing, all functions are valid
// except non whole numbers and only "+" or "-" operator are allowed.
// This program requires you to add a constant before each variable and
// limit the numbers to single digits 
public class CalculatorClient {
    public static void main(String[] args) { 
        Equation eq = new Equation("-4x-5x^3+4x+5 +5");
        System.out.println(eq.getConstants());
        System.out.println(eq.getExponents());
        System.out.println(eq.getSymbols());

        Calculator calc = new Calculator(eq);

        System.out.println(calc.solveForX(2));
        System.out.println(calc.currentEq());
        calc.newEq("4x+4");
        System.out.println(calc.currentEq());
        System.out.println(calc.solveForX(3));
        System.out.println(calc.integralOfEq());

        // Equation eq = new Equation("4x^4-5+4-4x^2");
        // System.out.println(eq.getConstants());
        // System.out.println(eq.getExponents());
        // System.out.println(eq.getSymbols());

        // Equation eq = new Equation("4x^4 - 5x^3 + 4x - 4x"); 
        // System.out.println(eq.getConstants());
        // System.out.println(eq.getExponents());
        // System.out.println(eq.getSymbols());


    }
}