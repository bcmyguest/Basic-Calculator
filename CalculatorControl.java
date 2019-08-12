import CalculatorModel;
import CalculatorView;

public class CalculatorControl {
    public CalculatorControl() {

    }

    public void launch() {
        CalculatorModel calcModel = new CalculatorModel();

        System.out.println("Welcome to the calculator model");
        System.out.println("Max Value (maxValue): " + calcModel.getMaxValue());
    
        System.out.println("Testing Addition function");
        double value1 = Double.valueOf(1);
        double value2 = Double.valueOf(-1);
        System.out.println("1 + (-1) = " + calcModel.addValues(value1, value2));
        value1 = Double.valueOf(1);
        value2 = Double.valueOf(1);
        System.out.println("1 + 1 = " + calcModel.addValues(value1, value2));
        // not currently catching errors (this will be done in the control)
        // value1 = Double.valueOf(calcModel.maxValue);
        // value2 = Double.valueOf(calcModel.maxValue);
        // System.out.println("maxValue + maxValue = " + calcModel.addValues(value1, value2));
    
        System.out.println("Testing Subtraction function");
        value1 = Double.valueOf(1);
        value2 = Double.valueOf(-1);
        System.out.println("1 - (-1) = " + calcModel.subtractValues(value1, value2));
        value1 = Double.valueOf(1);
        value2 = Double.valueOf(1);
        System.out.println("1 - 1 = " + calcModel.subtractValues(value1, value2));
        value1 = Double.valueOf(calcModel.getMaxValue());
        value2 = Double.valueOf(calcModel.getMaxValue());
        System.out.println("maxValue - maxValue = " + calcModel.subtractValues(value1, value2));
        // not currently catching errors (this will be done in the control)
        // value1 = Double.valueOf(calcModel.maxValue);
        // value2 = Double.valueOf(-calcModel.maxValue);
        // System.out.println("maxValue - (-maxValue) = " + calcModel.subtractValues(value1, value2));
    
        System.out.println("Testing Multiplication function");
        value1 = Double.valueOf(1);
        value2 = Double.valueOf(-2);
        System.out.println("1 * (-2) = " + calcModel.multiplyValues(value1, value2));
        value1 = Double.valueOf(2);
        value2 = Double.valueOf(2);
        System.out.println("2 * 2 = " + calcModel.multiplyValues(value1, value2));
        value1 = Double.valueOf(2);
        value2 = Double.valueOf(0);
        System.out.println("2 * 0 = " + calcModel.multiplyValues(value1, value2));
    
        System.out.println("Testing Division function");
        value1 = Double.valueOf(1);
        value2 = Double.valueOf(-2);
        System.out.println("1 / (-2) = " + calcModel.divideValues(value1, value2));
        value1 = Double.valueOf(2);
        value2 = Double.valueOf(2);
        System.out.println("2 / 2 = " + calcModel.divideValues(value1, value2));
            // not currently catching errors (this will be done in the control)
            // value1 = Double.valueOf(2);
            // value2 = Double.valueOf(0);
            // System.out.println("2 / 0 = " + calcModel.divideValues(value1, value2));
    
        System.out.println("Testing Exponent function");
        value1 = Double.valueOf(1);
        value2 = Double.valueOf(-2);
        System.out.println("1 ** (-2) = " + calcModel.exponentValues(value1, value2));
        value1 = Double.valueOf(2);
        value2 = Double.valueOf(2);
        System.out.println("2 ** 2 = " + calcModel.exponentValues(value1, value2));
        value1 = Double.valueOf(2);
        value2 = Double.valueOf(0);
        System.out.println("2 ** 0 = " + calcModel.exponentValues(value1, value2));

        System.out.println("Testing Memory Component");
        calcModel.printMemory();
        System.out.println("Adding Values to Mem (1.2, 69, 68)");
        calcModel.addToMemory(Double.valueOf(1.2));
        calcModel.addToMemory(Double.valueOf(69));
        calcModel.addToMemory(Double.valueOf(68));
        calcModel.printMemory();
        System.out.println("Removing last added value");
        calcModel.removeLastMemory();
        calcModel.printMemory();

        value1 = Double.valueOf(0);
        value2 = Double.valueOf(0);
        String expression = "";
        String display = "";
        int action = -1;
        CalculatorView calcView = new CalculatorView();
        System.out.println("Calc View is open");
        System.out.println(calcView.getAction());
        System.out.println(calcView.closed);
        while(calcView.closed == false) {
            // System.out.println(action);
            action = calcView.getAction();
            if(action != -1) {
                System.out.println(action);
                // an action has occured
                if(checkIfActionValid(action)) {
                    // get the current value
                    System.out.println("value1: " + value1);
                    System.out.println("value2: " + value2);
                    System.out.println("expression: " + expression);
                    if(expression.equals("") && !calcView.getTextField().equals("Welcome to the Calculator App")) {
                        value1 = Double.valueOf(calcView.getTextField());
                    } else { 
                        if(!calcView.getTextField().equals("Welcome to the Calculator App") && calcView.getPostExpression()) {
                            value2 = Double.valueOf(action);
                        }  else if (!calcView.getTextField().equals("Welcome to the Calculator App") && !calcView.getPostExpression()) {
                            value2 = Double.valueOf(calcView.getTextField());
                        }    
                    }
                    if(action >= 0 && action <= 9) {
                        
                        if(expression.equals("")) {
                            // System.out.println(Double.toString(value1) + Integer.toString(action));
                            if(Double.toString(value1).equals("0.0")){
                                value1 = Double.valueOf(Integer.toString(action));
                            } else {
                                if(value1 % 1 == 0) {
                                    value1 = Double.valueOf(((int)value1) + Integer.toString(action));
                                } else {
                                    value1 = Double.valueOf(Double.toString(value1) + Integer.toString(action));
                                }
                                
                            }
                            
                            display = Double.toString(value1);
                            calcView.setTextField(display);
                        } else {
                            if(Double.toString(value2).equals("0.0")){
                                value2 = Double.valueOf(Integer.toString(action));
                            } else {
                                if(value2 % 1 == 0) {
                                    // value2 = Double.valueOf(((int)value2) + Integer.toString(action));
                                } else {
                                    value2 = Double.valueOf(Double.toString(value2) + Integer.toString(action));
                                }
                                
                            }
                            display = Double.toString(value2);
                            calcView.setTextField(display);
                        }
                    } else if (action >= 15 && action <= 18) {
                        if (action == 15) {
                            expression = "+";
                        } else if (action == 16) {
                            expression = "-";
                        } else if (action == 17) {
                            expression = "*";
                        } else {
                            expression = "/";
                        }
                    } else if (action == 19) {
                        if (expression.equals("")) {
                            // just show the value1
                            display = Double.toString(value1);
                            calcView.setTextField(display);
                        } else {
                            // now we have to do an operation
                            double result = 0;
                            // each of these will need error checking
                            if (expression.equals("+")) {
                                result = calcModel.addValues(value1, value2);
                            } else if (expression.equals("-")) {
                                result = calcModel.subtractValues(value1, value2);
                            } else if (expression.equals("*")) {
                                result = calcModel.multiplyValues(value1, value2);
                            } else if (expression.equals("/")) {
                                result = calcModel.divideValues(value1, value2);
                            }

                            value1 = result;
                            value2 = Double.valueOf(0);
                            display = Double.toString(result);
                            calcView.setTextField(display);
                            expression = "";
                            display = "";
                        }
                    } else if (action >= 12 && action <= 14) {
                        if(action == 12) {
                            if(expression.equals("")) {
                                calcModel.addToMemory(value1);
                            } else {
                                calcModel.addToMemory(value2);
                            }
                        } else if (action == 13) {
                            calcModel.removeLastMemory();
                        } else {
                            // currently won't show memory on the screen
                            calcModel.printMemory();
                        }
                    } else if (action == 11) {
                        // this might not be done correctly
                        if(expression.equals("")) {
                            if(value1 % 1 == 0) {
                                display = value1 + ".";
                                calcView.setTextField(display);
                            } else {
                                calcView.setTextField(Double.toString(value1));
                            }
                        } else {
                            if(value2 % 1 == 0) {
                                display = value2 + ".";
                                calcView.setTextField(display);
                            } else {
                                calcView.setTextField(Double.toString(value2));
                            }
                        }
                    } else if (action == 20) {
                        expression = "";
                        calcView.setAction(-1);
                        calcView.setTextField("0.0");
                        value1 = Double.valueOf(0);
                        value2 = Double.valueOf(0);
                    }
                    calcView.setAction(-1);
                } 
                
            } 
            try{

                Thread.sleep(500);
              }catch(InterruptedException ex){
                //do stuff
              }
            // check if there was an action, if not, do nothing
            // if there was an action
                // check what the action was
                // if the action is valid
                // complete the action using the model
                // update the screen
                // ensure that the values in the control are correct
        }
    }

    private boolean checkIfActionValid(int action) {
        return true;
    }


    public static void main(String arg[]) {
        CalculatorControl calcControl = new CalculatorControl();
        calcControl.launch();
    }

}