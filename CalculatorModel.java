import java.util.Math;
import CustomLinkedList;

public class CalculatorModel {
// right now we can use the default constructor
    private double maxValue;
    private CustomLinkedList memory;

    public CalculatorModel() {
        maxValue = Double.MAX_VALUE;
        memory = new CustomLinkedList();
    }

    public String viewNextNode() {
        return memory.viewNextNode();
    }

    public double getMaxValue() {
        return maxValue;
    }
    
    public void printMemory() {
        memory.printNodes();
    }

    public void addToMemory(double value) {
        memory.addNode(value);
    }

    public void removeLastMemory() {
        memory.deleteFront();
    }

    // public static void main(String arg[]) {
    //     CalculatorModel calcModel = new CalculatorModel();
        
    //     System.out.println("Welcome to the calculator model");
    //     System.out.println("Max Value (maxValue): " + calcModel.maxValue);

    //     System.out.println("Testing Addition function");
    //     double value1 = Double.valueOf(1);
    //     double value2 = Double.valueOf(-1);
    //     System.out.println("1 + (-1) = " + calcModel.addValues(value1, value2));
    //     value1 = Double.valueOf(1);
    //     value2 = Double.valueOf(1);
    //     System.out.println("1 + 1 = " + calcModel.addValues(value1, value2));
    //     // not currently catching errors (this will be done in the control)
    //     // value1 = Double.valueOf(calcModel.maxValue);
    //     // value2 = Double.valueOf(calcModel.maxValue);
    //     // System.out.println("maxValue + maxValue = " + calcModel.addValues(value1, value2));

    //     System.out.println("Testing Subtraction function");
    //     value1 = Double.valueOf(1);
    //     value2 = Double.valueOf(-1);
    //     System.out.println("1 - (-1) = " + calcModel.subtractValues(value1, value2));
    //     value1 = Double.valueOf(1);
    //     value2 = Double.valueOf(1);
    //     System.out.println("1 - 1 = " + calcModel.subtractValues(value1, value2));
    //     value1 = Double.valueOf(calcModel.maxValue);
    //     value2 = Double.valueOf(calcModel.maxValue);
    //     System.out.println("maxValue - maxValue = " + calcModel.subtractValues(value1, value2));
    //     // not currently catching errors (this will be done in the control)
    //     // value1 = Double.valueOf(calcModel.maxValue);
    //     // value2 = Double.valueOf(-calcModel.maxValue);
    //     // System.out.println("maxValue - (-maxValue) = " + calcModel.subtractValues(value1, value2));

    //     System.out.println("Testing Multiplication function");
    //     value1 = Double.valueOf(1);
    //     value2 = Double.valueOf(-2);
    //     System.out.println("1 * (-2) = " + calcModel.multiplyValues(value1, value2));
    //     value1 = Double.valueOf(2);
    //     value2 = Double.valueOf(2);
    //     System.out.println("2 * 2 = " + calcModel.multiplyValues(value1, value2));
    //     value1 = Double.valueOf(2);
    //     value2 = Double.valueOf(0);
    //     System.out.println("2 * 0 = " + calcModel.multiplyValues(value1, value2));

    //     System.out.println("Testing Division function");
    //     value1 = Double.valueOf(1);
    //     value2 = Double.valueOf(-2);
    //     System.out.println("1 / (-2) = " + calcModel.divideValues(value1, value2));
    //     value1 = Double.valueOf(2);
    //     value2 = Double.valueOf(2);
    //     System.out.println("2 / 2 = " + calcModel.divideValues(value1, value2));
    //     // not currently catching errors (this will be done in the control)
    //     // value1 = Double.valueOf(2);
    //     // value2 = Double.valueOf(0);
    //     // System.out.println("2 / 0 = " + calcModel.divideValues(value1, value2));

    //     System.out.println("Testing Exponent function");
    //     value1 = Double.valueOf(1);
    //     value2 = Double.valueOf(-2);
    //     System.out.println("1 ** (-2) = " + calcModel.exponentValues(value1, value2));
    //     value1 = Double.valueOf(2);
    //     value2 = Double.valueOf(2);
    //     System.out.println("2 ** 2 = " + calcModel.exponentValues(value1, value2));
    //     value1 = Double.valueOf(2);
    //     value2 = Double.valueOf(0);
    //     System.out.println("2 ** 0 = " + calcModel.exponentValues(value1, value2));
    // }

    public double addValues(double value1, double value2) {

        if(Double.isInfinite((value1 + value2))) {
            throw new ArithmeticException("double under/overflow");
        } else {
            return value1 + value2;
        }
        
    }

    public double subtractValues(double value1, double value2) {

        return addValues(value1,-value2);
        
    }

    public double multiplyValues(double value1, double value2) {
        if(Double.isInfinite((value1*value2))) {
            throw new ArithmeticException("double under/overflow");
        } else {
            return value1 * value2;
        }
    }

    public double divideValues(double value1, double value2) {
        if(value2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        } else if(Double.isInfinite((value1/value2))) {
            throw new ArithmeticException("double under/overflow");
        } else {
            return value1 / value2;
        }
    }

    public double exponentValues(double value1, double value2) {
        if(Double.isInfinite((Math.pow(value1, value2)))) {
            throw new ArithmeticException("double under/overflow");
        } else {
            return Math.pow(value1, value2);
        }
    }
}