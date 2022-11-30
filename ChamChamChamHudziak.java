/*
  * ChamChamChamHudziak.java
  * @description Game that has the user compete against 3 computers in a direction guessing game
  * @version 1.0, 2021-10-2
  * @author Connor Hudziak
*/

import java.util.Scanner;
import java.util.Random;

public class ChamChamChamHudziak{

  //attributes
  private int userScore, comp1Score, comp2Score, comp3Score, userPlay, playAgain, comp1Play, comp2Play, comp3Play, challenger;
  private Scanner scan;
  private Random rand;

  // methods
  public static void main(String[] args) {
    ChamChamChamHudziak testCase = new ChamChamChamHudziak();
  }

//----------------------------------
// Constructor
//----------------------------------

  public ChamChamChamHudziak(){
    scan = new Scanner(System.in);
    rand = new Random();

    challenger = 0;

    userScore = 0;
    comp1Score = 0;
    comp2Score = 0;
    comp3Score = 0;

    userPlay = 0;
    comp1Play = 0;
    comp2Play = 0;
    comp3Play = 0;

    playAgain = 0;




    welcomeMessage();
    setChallenger();
    setUserPlay();
    setCompPlays();
    displayPlays();
    score();
    displayScores();
    playAgain();


    //oneRound();
  }// end of constructor

  //----------------------------------
  // Continous play with one round
  //----------------------------------

  public void oneRound(){
    setChallenger();
    setUserPlay();
    setCompPlays();
    displayPlays();
    score();
    displayScores();
    playAgain();

  }



  //----------------------------------
  // Welcome messages
  //----------------------------------

  public void welcomeMessage(){
    System.out.println("Welcome to ChamChamCham!");
    System.out.println("You will be playing againts 3 computer opponents");
    System.out.println("The game will start with you being the challenger");
    System.out.println("In each round, there is  one challenger and 3 opponents");
    System.out.println("You will select a direction using an integer between 0 and 3.");
    System.out.println("Every time the challenger matches a position, the challenger gets 1 point.");
    System.out.println("Every time an opponent has a different position from the challenger, the opponent gets a point.");

  }

  //----------------------------------
  // Sets the computer plays
  //----------------------------------

  public void setCompPlays(){
    comp1Play = rand.nextInt(4);
    comp2Play = rand.nextInt(4);
    comp3Play = rand.nextInt(4);


}

    //System.out.println("The Opponents chose " + comp1Play + comp2Play + comp3Play);// check


  //----------------------------------
  // Takes in the user play
  //----------------------------------

  public void setUserPlay(){
    System.out.println("Please choose your direction. Type 0 for up, 1 for down, 2 for left, or 3 for right.");
    userPlay = scan.nextInt();
    //System.out.println("You chose " + userPlay);

  }

  //----------------------------------
  // Asking the user if they want to play again
  //----------------------------------

  public void playAgain(){
    System.out.println("Do you want to play again? Type 1 to continue playing or 2 to quit.");
    playAgain = scan.nextInt();

    if (playAgain == 1){
      oneRound();
    }else{
      System.out.println(" You have quit the game. Your finished with " + userScore + " points.");
      System.out.println("Computer 1 finsihed with " + comp1Score + " points.");
      System.out.println("Computer 2 finished with " + comp2Score + " points.");
      System.out.println("Computer 3 finished with " + comp3Score + " points.");
    }
  }

  //----------------------------------
  // Displays the plays
  //----------------------------------

  public void displayPlays(){
    if (userPlay == 0){
    System.out.println("You played Up.");
  } else if(userPlay == 1){
    System.out.println("You played Down.");
  }else if (userPlay == 2){
    System.out.println("You played Left.");
  }else if (userPlay == 3){
    System.out.println("You played Right");
  }
    if (comp1Play == 0){
  	System.out.println("Computer 1 played Up.");
  } else if(comp1Play == 1){
  	System.out.println("Computer 1 played Down.");
  }else if (comp1Play == 2){
  	System.out.println("Computer 1 played Left.");
  }else if (comp1Play == 3){
    System.out.println("Computer 1 played Right");
  }
    if (comp2Play == 0){
  	System.out.println("Computer 2 played Up.");
  } else if(comp2Play == 1){
  	System.out.println("Computer 2 played Down.");
  }else if (comp2Play == 2){
  	System.out.println("Computer 2 played Left.");
  }else if (comp2Play == 3){
    System.out.println("Computer 2 played Right");
  }
    if (comp3Play == 0){
  	System.out.println("Computer 3 played Up.");
  } else if(comp3Play == 1){
  	System.out.println("Computer 3 played Down.");
  }else if (comp3Play == 2){
  	System.out.println("Computer 3 played Left.");
  }else if (comp3Play == 3){
    System.out.println("Computer 3 played Right");
    }
  }

  //----------------------------------
  // Calculates the score
  //----------------------------------

  public void score(){
    if (challenger == 0){
      userPlay = userPlay == comp1Play ? userScore++ : comp1Score++ ;
      userPlay = userPlay == comp2Play ? userScore++ : comp2Score++ ;
      userPlay = userPlay == comp3Play ? userScore++ : comp3Score++ ;
      challenger += 1;
    }else if
      (challenger == 1){
        comp1Play = comp1Play == userPlay ? comp1Score++ : userScore++ ;
        comp1Play = comp1Play == comp2Play ? comp1Score++ : comp2Score++ ;
        comp1Play = comp1Play == comp3Play ? comp1Score++ : comp3Score++ ;
        challenger += 1;
    }else if
      (challenger == 2){
        comp2Play = comp2Play == userPlay ? comp2Score++ : userScore++ ;
        comp2Play = comp2Play == comp1Play ? comp2Score++ : comp2Score++ ;
        comp2Play = comp2Play == comp3Play ? comp2Score++ : comp3Score++ ;
        challenger += 1;
    }else if
      (challenger == 3){
        comp3Play = comp3Play == userPlay ? comp3Score++ : userScore++ ;
        comp3Play = comp3Play == comp1Play ? comp3Score++ : comp1Score++ ;
        comp3Play = comp3Play == comp2Play ? comp3Score++ : comp2Score++ ;
        challenger = 0;
        }
      }

    //----------------------------------
    // Displays the scores
    //----------------------------------
    public void displayScores(){
      System.out.println("You have " + userScore + " points.");
      System.out.println("Computer 1 has " + comp1Score + " points.");
      System.out.println("Computer 2 has " + comp2Score + " points.");
      System.out.println("Computer 3 has " + comp3Score + " points.");
    }



    //----------------------------------
    // Sets the challenger
    //----------------------------------

    public void setChallenger(){
      if (challenger == 0){
        System.out.println("You are the challenger");
      }else if
      (challenger == 1){
        System.out.println("Computer 1 is the challenger");
      }else if
      (challenger == 2){
        System.out.println("Computer 2 is the challenger");
      }else{
      System.out.println("Computer 3 is the challenger");
      }

    }









} // end of class
