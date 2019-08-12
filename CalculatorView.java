import java.awt.*;
import java.awt.event.*;

public class CalculatorView extends Frame implements WindowListener, ActionListener {
    private TextField calcDisplay;
    private static final long serialVersionUID = 1L;
    private Button btnOne; 
    private Button btnTwo; 
    private Button btnThree; 
    private Button btnFour; 
    private Button btnFive; 
    private Button btnSix; 
    private Button btnSeven; 
    private Button btnEight; 
    private Button btnNine; 
    private Button btnZero; 
    private Button btnDecimal; 
    private Button btnMemPlus; 
    private Button btnMemMinus; 
    private Button btnMemShow;
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEquals;
    private Button btnClear; 
    private int action;
    public boolean closed;
    public boolean postExpression;

    public void setTextField(String val) {
        calcDisplay.setText(val);
    }

    public String getTextField() {
        return calcDisplay.getText();
    }

    public boolean getPostExpression() {
        return postExpression;
    }

    public CalculatorView() {
        closed = false;
        postExpression = false;
        action = -1;
        // https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
        setLayout(new FlowLayout());
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.
        calcDisplay = new TextField("Welcome to the Calculator App");
        calcDisplay.setEditable(false);
        add(calcDisplay); // "super" Frame container adds TextField component
        
        btnOne = new Button("1");
        btnTwo = new Button("2");
        btnThree = new Button("3");
        btnFour = new Button("4");
        btnFive = new Button("5");
        btnSix = new Button("6");
        btnSeven = new Button("7");
        btnEight = new Button("8");
        btnNine = new Button("9");
        btnZero = new Button("0");
        btnDecimal = new Button(".");
        btnMemPlus = new Button("M+");
        btnMemMinus = new Button("M-");
        btnMemShow = new Button("M");
        btnAdd = new Button("+");
        btnSubtract = new Button("-");
        btnMultiply = new Button("*");
        btnDivide = new Button("/");
        btnEquals = new Button("=");
        btnClear = new Button("C");
        // button.setBounds(1,2,3,4);
        
        btnOne.addActionListener(this);
        btnTwo.addActionListener(this);
        btnThree.addActionListener(this);
        btnFour.addActionListener(this);
        btnFive.addActionListener(this);
        btnSix.addActionListener(this);
        btnSeven.addActionListener(this);
        btnEight.addActionListener(this);
        btnNine.addActionListener(this);
        btnZero.addActionListener(this);
        btnDecimal.addActionListener(this);
        btnDecimal.addActionListener(this);
        btnMemPlus.addActionListener(this);
        btnMemMinus.addActionListener(this);
        btnMemShow.addActionListener(this);
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnEquals.addActionListener(this);
        btnClear.addActionListener(this);

        add(btnOne);
        add(btnTwo);
        add(btnThree);
        add(btnFour);
        add(btnFive);
        add(btnSix);
        add(btnSeven);
        add(btnEight);
        add(btnNine);
        add(btnZero);
        add(btnDecimal);
        add(btnMemPlus);
        add(btnMemMinus);
        add(btnMemShow);
        add(btnAdd);
        add(btnSubtract);
        add(btnMultiply);
        add(btnDivide);
        add(btnEquals);
        add(btnClear);

        

        setTitle("Calculator");
        setSize(250, 250);

        setVisible(true);
    
    }

    public int getAction() {
        return action;
    }

    public void setAction(int actionValue) {
        action = actionValue;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnOne) {
            action = 1;
        } else if (e.getSource() == btnTwo) {
            action = 2;
        } else if (e.getSource() == btnThree) {
            action = 3;
        } else if (e.getSource() == btnFour) {
            action = 4;
        } else if (e.getSource() == btnFive) {
            action = 5;
        } else if (e.getSource() == btnSix) {
            action = 6;
        } else if (e.getSource() == btnSeven) {
            action = 7;
        }else if (e.getSource() == btnEight) {
            action = 8;
        } else if (e.getSource() == btnNine) {
            action = 9;
        } else if (e.getSource() == btnZero) {
            action = 0;
        } else if (e.getSource() == btnDecimal) {
            action = 11;
        } else if (e.getSource() == btnMemPlus) {
            action = 12;
        } else if (e.getSource() == btnMemMinus) {
            action = 13;
        }else if (e.getSource() == btnMemShow) {
            action = 14;
        } else if (e.getSource() == btnAdd) {
            action = 15;
            postExpression = true;
        } else if (e.getSource() == btnSubtract) {
            action = 16;
            postExpression = true;
        } else if (e.getSource() == btnMultiply) {
            action = 17;
            postExpression = true;
        } else if (e.getSource() == btnDivide) {
            action = 18;
            postExpression = true;
        } else if (e.getSource() == btnEquals) {
            action = 19;
            postExpression = false;
        } else if (e.getSource() == btnClear) {
            action = 20;
            postExpression = false;
        }
    }

    public void windowClosing(WindowEvent e) {
        dispose();
        closed = true;
        System.exit(0);
    }

    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}

    // public static void main(String[] args) {
    //     CalculatorView view = new CalculatorView();
    // }




}