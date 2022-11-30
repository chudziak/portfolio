/*
  * CalculatorHudziak.java
  * @description GUI Calculator that is now functional
  * @version 1.1, 2021-11-23
  * @author Connor Hudziak
  * Got assistance from Faizal Patel on Action Listener
*/

import java.awt.*;
import javax.swing.*;
import java.awt.Insets;
import java.awt.event.*;

public class CalculatorHudziak extends JPanel{

  //Attributes
  private Color red, blue;
  private Font traditionalFont;
  private JPanel background, buttonPanel;
  private Consequences response;
  private CalcMechsSolution memory;
  private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonEqual, buttonDiv, buttonDot, buttonMulti, buttonMinus,buttonC, buttonO;
  private JTextField text;
  private String afterEquals;



  public static void main(String[] args) {
    JFrame frame = new JFrame("Calculator");
    frame.setSize(400, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // ref: https://www.tek-tips.com/viewthread.cfm?qid=1153679
    // locks the frame at a specific size
    frame.setResizable(false);
    frame.add(new CalculatorHudziak());
    frame.setVisible(true);

  }

  public CalculatorHudziak(){

    // creates object
    memory = new CalcMechsSolution();
    response = new Consequences();

    // custom colors
    blue = new Color(0,191,255);
    red = new Color(220,20,60);

    // custom Font
    traditionalFont = new Font("Andale Mono", Font.PLAIN, 50);

    // background
    setBackground(blue);
    //add(background);
    setLayout(null);
    Insets inset = getInsets();

    // label (Math gif)
    ImageIcon HangoverMath = new ImageIcon("math.gif");
    JLabel math = new JLabel(HangoverMath);
    math.setBounds(inset.left + 0, inset.top + 0, 400, 200);
    add(math);

    // Main Panel
    buttonPanel = new JPanel(new GridLayout(6, 3));
    buttonPanel.setBackground(red);




    buttonO = new JButton(" ");
    buttonPanel.add(buttonO);
    buttonO.addActionListener(response);
    buttonDot = new JButton(".");
    buttonPanel.add(buttonDot);
    buttonDot.addActionListener(response);
    buttonC = new JButton("C");
    buttonPanel.add(buttonC);
    buttonC.addActionListener(response);
    button1 = new JButton("1");
    buttonPanel.add(button1);
    button1.addActionListener(response);
    button2 = new JButton("2");
    buttonPanel.add(button2);
    button2.addActionListener(response);
    buttonPlus = new JButton("+");
    buttonPanel.add(buttonPlus);
    buttonPlus.addActionListener(response);
    button3 = new JButton("3");
    buttonPanel.add(button3);
    button3.addActionListener(response);
    button4 = new JButton("4");
    buttonPanel.add(button4);
    button4.addActionListener(response);
    buttonMinus = new JButton("\u2212");
    buttonPanel.add(buttonMinus);
    buttonMinus.addActionListener(response);
    button5 = new JButton("5");
    buttonPanel.add(button5);
    button5.addActionListener(response);
    button6 = new JButton("6");
    buttonPanel.add(button6);
    button6.addActionListener(response);
    buttonMulti = new JButton("\u00D7");
    buttonPanel.add(buttonMulti);
    buttonMulti.addActionListener(response);
    button7 = new JButton("7");
    buttonPanel.add(button7);
    button7.addActionListener(response);
    button8 = new JButton("8");
    buttonPanel.add(button8);
    button8.addActionListener(response);
    buttonDiv = new JButton("\u00F7");
    buttonPanel.add(buttonDiv);
    buttonDiv.addActionListener(response);
    button9 = new JButton("9");
    buttonPanel.add(button9);
    button9.addActionListener(response);
    button0 = new JButton("0");
    buttonPanel.add(button0);
    button0.addActionListener(response);
    buttonEqual = new JButton("=");
    buttonPanel.add(buttonEqual);
    buttonEqual.addActionListener(response);

    buttonPanel.setBounds(inset.left + 0, inset.top + 275, 400, 300);
    add(buttonPanel);








    // text field
    text = new JTextField(25);
    text.setFont(traditionalFont);
    text.setSize(50,600);
    text.setForeground(Color.black);
    text.setBackground(blue);
    text.setBounds(inset.left + 0, inset.top + 195, 405, 100);
    add(text);

  }


  private class Consequences implements ActionListener{
    //attributes
    private boolean done = false;

    public void actionPerformed(ActionEvent event){

      // Got help from Faizal Patel on this section

      if (event.getSource() == button0){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button0.getText());
      }else if (event.getSource() == button1){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button1.getText());
      }else if (event.getSource() == button2){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button2.getText());
      }else if (event.getSource() == button3){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button3.getText());
      }else if (event.getSource() == button4){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button4.getText());
      }else if (event.getSource() == button5){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button5.getText());
      }else if (event.getSource() == button6){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button6.getText());
      }else if (event.getSource() == button7){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button7.getText());
      }else if (event.getSource() == button8){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button8.getText());
      }else if (event.getSource() == button9){
        if (done == true) {
          text.setText("");
          done = false;
        }
        text.setText(text.getText() + button9.getText());
      }else if (event.getSource() == buttonC){
        if(text.getText().equals("")){
          memory.clear();
        }
        text.setText("");
      }else if(event.getSource() == buttonPlus){
        String result = memory.computation(text.getText(), buttonPlus.getText());
        text.setText(result);
        done = true;
      }else if(event.getSource() == buttonMinus){
        String result = memory.computation(text.getText(), buttonMinus.getText());
        text.setText(result);
        done = true;
      }else if(event.getSource() == buttonMulti){
        String result = memory.computation(text.getText(), buttonMulti.getText());
        text.setText(result);
        done = true;
      }else if(event.getSource() == buttonDiv){
        String result = memory.computation(text.getText(), buttonDiv.getText());
        text.setText(result);
        done = true;
      }else if(event.getSource() == buttonEqual){
        String result = memory.equalResult(text.getText());
        text.setText(result);
        done = true;
    }





  }
}


}// end of class
