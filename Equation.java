// eq of user choice, must be whole numbers no / or * operators
import java.util.*;
public class Equation {
    private List<Double> constantList;
    private List<Integer> exponentList;
    private List<Character> symbolList;
    private String equation;
    
    // Excepts String and breaks it down into lists of constants, exponents, and symbols 
    // of the given function
    public Equation(String equation) {
        this.equation = equation;
        this.constantList = new ArrayList<>();
        this.exponentList = new ArrayList<>();
        this.symbolList = new ArrayList<>();

        String value = "";
        String exponent = "";
        boolean firstNumNeg = true;
        for (int i = 0; i < equation.length(); i++) {
            
            if ((equation.charAt(i) != '+' && equation.charAt(i) != '-' && equation.charAt(i) != 'x') || (equation.charAt(0) == '-' && firstNumNeg)) { //done
                value += "" + equation.charAt(i);
                if (equation.charAt(0) == '-') {
                    firstNumNeg = false;
                }
                if(i + 1 == equation.length()) {
                    double valueParse = Integer.parseInt(value.trim());
                    constantList.add(valueParse);

                }
                if (exponentList.size() != constantList.size() && i + 1 == equation.length()) {
                    exponentList.add(0);
                }

            }else if (equation.charAt(i) == 'x'){
                if (i + 1 < equation.length()) {
                    if(equation.charAt(i + 1) == '+' || equation.charAt(i + 1) == '-' 
                    || equation.charAt(i + 1) == ' ' || equation.length() == i + 1) {
                        exponentList.add(1);

                    }else if (i + 1 < equation.length() && equation.charAt(i + 1) == '^') {
                        i += 2;
                        exponent = "" + equation.charAt(i);
                        int exponentParse = Integer.parseInt(exponent.trim());
                        exponentList.add(exponentParse);

                        if (i + 1 == equation.length()) {
                            double valueParse = Integer.parseInt(value.trim());
                            constantList.add(valueParse); //reaches + or -
                        }
                    }
                }else {
                    exponentList.add(1);
                    if (equation.length() == i + 1) {
                        double valueParse = Integer.parseInt("" + equation.charAt(equation.length() - 2));
                        constantList.add(valueParse);
                    }
                }
            }else {
                double valueParse = Integer.parseInt(value.trim());
                constantList.add(valueParse); //reaches + or -
                value = "";
                symbolList.add(equation.charAt(i));
                if (exponentList.size() != constantList.size()) {
                    exponentList.add(0);
                }
            }
        }
    }
    // Access to Lists 
    public List<Double> getConstants() {
        return constantList;
    }
    public List<Integer> getExponents() {
        return exponentList;
    }
    public List<Character> getSymbols() {
        return symbolList;
    }
    
    public String toString() {
        return equation;
    }
}