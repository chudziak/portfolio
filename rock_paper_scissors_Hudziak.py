from random import randint# allows us to generate a number at random
import sys 
# Rock-Paper-Scissors

# 0 = rock
# 1 = paper
# 2 = scissors

wins = 0

losses = 0

ties = 0

total_wins = 0

total_losses = 0

total_ties = 0
print("-------------Let's play 'Rock Paper Scissors!!!!!!--------------")
print("-This is a continous game that will record your record against the computer")
print("-You can play as long as you want or choose to quit by typing 'Q'")
def display_directions():
    
    print("Type 'rock', 'paper', or 'scissors' below or type 'Q' to quit")
def user_input():
    """
    user_input() -> int

    prompts the user to type 'rock' 'paper' or 'scissors' and
    returns either 0 1 or 2 based on their answer.
    """
    display_directions()

    value = input()
    
    if (value == str("Q")):
        print("You quit the game. Your record was:")
        print("Wins:")
        print(total_wins)
        print("Losses:")
        print(total_losses)
        print("Ties")
        print(total_ties)
        sys.exit() #Ref:
                   # https://www.hashbangcode.com/article/stopping-
                   #code-execution-python#:~:text=To%20stop%20code%
                   #20execution%20in,way%20of%20stopping%20code%
                   #20execution.
                   
                   #sys.exit() ends my game because I imported system and exit
                   #will close it out.
                   
                   # I was having trouble with the while loop and breaking it properly,
                   # I used my resources and came up with this solution.
    else:
        while(value != str('Q')):

            if (value == str("Q")):
                print("You quit")
                break
        
            good_answer = False

       
        
            while(not good_answer):
            
                if (value == "rock"):
                    good_answer = True
                    play = 0
                elif (value == "paper"):
                    good_answer = True
                    play = 1
                elif (value == "scissors"):
                    good_answer = True
                    play = 2
                else:
                    print("Invalid input.")
                return play
        

        
        

        
        

   
    
    #print(record())
    
        
    

def computer_input():
    """
    computer_input() -> int

    randomly returns 0 1 or 2
    """

    # a way to randomly return 0, 1, or 2

    play = randint(0, 2)

    if (play == 0):
        print("The computer played rock")
    elif (play == 1):
        print("The computer played paper")
    else:
        print("The computer played scissors")

    return play



def winner(user, computer):
    """
    winner (int, int) -> ()

    winner prints who wins in rock paper scissors
    """
    global total_ties

    global total_losses

    global total_wins
    
    wins = 0

    losses = 0

    ties = 0


    if(user == computer):
        ties = + 1
        
        total_ties = total_ties + ties
        print("You tied with the computer")
        
        
    elif((user == 0 and computer == 1) or (user == 1 and computer == 2) or  (user == 2 and computer == 0) ):
        losses = + 1
        
        total_losses = total_losses + losses
        print("The computer won")
        
    else:
        wins = + 1
        
        total_wins = total_wins + wins
        print("You won!")

   
        

    # How do we determine the winner when it isn't tied??
    # 0 = rock, 1 = paper, 2 = scissors

    #    user    |  computer  |    winner
    #--------------------------------------
    #     0      |     1      |     comp
    #     0      |     2      |     user
    #     1      |     0      |     user
    #     1      |     2      |     comp
    #     2      |     0      |     comp
    #     2      |     1      |     user




    
        
    
    
    
    




    

def game():
    """
    game() -> ()

    runs the game rock paper scissors
    """

    user = user_input()

    computer = computer_input()

    winner(user, computer)

    print("Wins:")
    print(total_wins)
    print("Losses:")
    print(total_losses)
    print("Ties")
    print(total_ties)
    

    game()
    
    

    
   


game()
