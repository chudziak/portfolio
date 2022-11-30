/*
  * BettingRoom.java
  * @description A room where that allows the user to wager in game currency
  * @ConnorHudziak and @FaizalPatel
  * @version 1, 2021-10-29
*/


import java.awt.*;
import javax.swing.*;
import java.awt.Insets;
import java.awt.event.*;
import java.util.Random;

public class BettingRoom{

    // attributes
    private Color purple, royalBlue, gold, silver;
    private Font royalFont, royalFont1, textFont;
    private JFrame frame;
    private JPanel background, subpanel1, subpanel2, subpanel3, buttonPanel1;
    private Insets inset;
    private JLabel label, label1, label2, slot;
    private ImageIcon casino;
    private JButton red, black, buttonEnter;
    private JTextField text;
    private Integer coins;
    private Listener ear;


  //methods
  //------------------------------------------
  // main method
  //------------------------------------------
public static void main(String[] args){
    new BettingRoom();
}

  //------------------------------------------
  // constructor
  //------------------------------------------
    public BettingRoom(){
    setColorsAndFont();

    // background
    setBackground();

    //sub panels
    setSubpanel();

    //textfield
    setTextfield(); // you have two JTextfields!

    // buttons
    setButtons();

    //enter button
    enterButton();

    coins = 100; // initialize coins once in the constructor


    frame = new JFrame("Betting Room");
    frame.setSize(1000, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(background);


    // label
    label = new JLabel("Let’s Play Roulette!");
    label.setForeground(gold);
    label.setFont(royalFont);
    subpanel1.add(label);

    //label
    label1 = new JLabel("Enter the number of coins you would like to bet:");
    label1.setForeground(gold);
    label1.setFont(royalFont1);
    subpanel2.add(label1);


    //label
    label2 = new JLabel("Roulette time! choose red or black:");
    label2.setForeground(gold);
    label2.setFont(royalFont1);
    subpanel3.add(label2);

    //label
    casino = new ImageIcon("CasinoBackground.jpg");
    slot = new JLabel(casino);
    slot.setBounds(inset.left + 0, inset.top + 0, 1000, 600);
    background.add(slot);

    // text field -- > this was a duplicate
    // text = new JTextField(100);
    // text.setFont(textFont);
    // background.add(text);
    // text.setBounds(inset.left + 550, inset.top + 130, 250, 45);
    // text.setForeground(Color.black);
    // text.setBackground(gold);
    // text.setText(coins.toString());
    // text.setEditable(true);

    ear = new Listener();
    buttonEnter.addActionListener(ear);
    red.addActionListener(ear);
    black.addActionListener(ear);


    //make frame visible
    frame.setVisible(true);


  }// end of Constructor

  //------------------------------------------
  // sets the color values
  //------------------------------------------
    public void setColorsAndFont(){
    // custom colors
    purple = new Color(148,0,211);
    royalBlue = new Color(6, 5, 223);
    gold = new Color(207, 181, 59);
    Color silver = new Color(128, 128, 128);

    //custom font

    royalFont = new Font("Times New Roman", Font.BOLD, 62);
    royalFont1 = new Font("Times New Roman", Font.PLAIN, 24);
    textFont = new Font("TimesRoman", Font.PLAIN, 50);
  }

  //------------------------------------------
  // sets up the background panel
  //------------------------------------------
    public void setBackground(){
    background = new JPanel();
    background.setBackground(purple);
    background.setLayout(null);
    inset = background.getInsets();

  }

  //------------------------------------------
  // sets up the subpanel with text
  //------------------------------------------
    public void setSubpanel(){
    subpanel1 = new JPanel();
    subpanel1.setBackground(royalBlue);
    subpanel1.setBounds(inset.left + 215, inset.top + 5, 600, 90);
    background.add(subpanel1);


    subpanel2= new JPanel();
    subpanel2.setBackground(royalBlue);
    subpanel2.setBounds(inset.left + 30, inset.top + 130, 500, 45);
    background.add(subpanel2);

    subpanel3 = new JPanel();
    subpanel3.setBackground(royalBlue);
    subpanel3.setBounds(inset.left + 30, inset.top + 200, 350, 45);
    background.add(subpanel3);


    }

  //------------------------------------------
  // sets up the textfield
  //------------------------------------------
    public void setTextfield(){
    text = new JTextField(100);
    text.setFont(textFont);
    background.add(text);
    text.setBounds(inset.left + 550, inset.top + 130, 250, 45);
    text.setForeground(Color.black);
    text.setBackground(gold);
    }

    //------------------------------------------
    // sets up the buttons
    //------------------------------------------

    public void setButtons(){
      JPanel buttonPanel1 = new JPanel(new GridLayout(1, 2));
      buttonPanel1.setBounds(inset.left + 550, inset.top + 200, 200, 45);
      red = new JButton("RED");// RESPONSIVE!!
      buttonPanel1.add(red);
      black = new JButton("BLACK");
      buttonPanel1.add(black);
      background.add(buttonPanel1);
    }


    public void enterButton(){
    JPanel buttonPanel2 = new JPanel(new GridLayout(1, 1));
    buttonPanel2.setBounds(inset.left + 825, inset.top + 130, 125, 45);
    buttonEnter = new JButton("Enter");
    buttonPanel2.add(buttonEnter);
    background.add(buttonPanel2);
    }



    private class Listener implements ActionListener{

      //Attributes
      private Integer userChoice, computerChoice, bet;
      private Random rand = new Random();


      //-------------------------------------------------
      // manages betting mechanics
      //-------------------------------------------------
      public void actionPerformed(ActionEvent event){

        if (event.getSource() == buttonEnter){
          // What is supposed to happen here?
          // I don't think I understand this field.

          // lock in bet?
          text.setEditable(false);
          bet = Integer.parseInt(text.getText());

        }else if (event.getSource() == red){

            userChoice = 0; // this is an encoding of red?
            computerChoice = rand.nextInt(2);

            // cases of whether bet was correct
            if (userChoice == computerChoice){
              coins += bet;
              text.setText(coins.toString());
            }
            else{
              coins -= bet;
              text.setText(coins.toString());
            }

            // for new bet?
            text.setEditable(true);

        }else if (event.getSource() == black){
            userChoice = 1; // this is an encoding of black?
            computerChoice = rand.nextInt(2);

            //cases of whether bet was correct
            if (userChoice == computerChoice){
              coins += bet;
              text.setText(coins.toString());
            }
            else{
              coins -= bet;
              text.setText(coins.toString());
            }

            // for new bet?
            text.setEditable(true);
        }
      // win conditions?

    }// this is the end curly bracket for action performed


  } // end curly bracket for Listener class


}// end of class
