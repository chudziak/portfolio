from random import randint

# function that randomly generates letters

def random_letters(num_of_letters):
    """
    random_letters(int) -> list of strings

    Given num_of_letters, we return a list of random letters
    """

    vowels = "AEIOU"
            # 01234 
    consonants = "BCDFGHJKLMNPQRSTVWXYZ"
    letters = []

    # decide how many vowels
    num_of_vowels = randint(1, int(num_of_letters*0.8))
    # num_of_vowels = randint(2, num_of_letters)

    # randomly pick vowels
    for i in range(0, num_of_vowels, 1):
        index = randint(0, len(vowels)-1)
        vowel = vowels[index]
        letters.append(vowel)

    #randomly pick consonants
    for i in range(0, num_of_letters - num_of_vowels, 1):
        index = randint(0, len(consonants)-1)
        consonant = consonants[index]
        letters.append(consonant)

    return letters

#---------------- TESTS --------------------------
#mylist = random_letters(10)
#print(mylist)
#-------------------------------------------------

# function that takes input from the user

# function that validates words
def reference(check_string):
    """
    reference(string) -> boolean (True/False)

    reference() determines if check_string is an
    english word. If it is, it returns True. Otherwise,
    it returns False.
    """
    # turns it into an upper case string
    check_string = check_string.upper()

    # user all_words.txt
    file = open("all_words.txt", "r")

    # we are checking if
    # " " + word + "\n" is actually an entire line in the file
    if " " + check_string + "\n" in file.readlines():
        return True
    else:
        return False


#---------------- TESTS --------------------------
#print(reference("ABJURE")) # True
#print(reference("ABlaut")) # True
#print(mylist)
#-------------------------------------------------

# function that scores words: 50pts for each letter after 2 letters
def score_word(string_score):
    """
    score_word(string) -> int

    Given a word, we will score the word based on
    Alex's scoring paradigm
    """

    # 50 points for first 3 letters and
    # 50 points for each additional letter
    if len(string_score) < 3:
        return 0

    # 3 letters -> 50 points
    # 4 letters -> 100 points
    # 5 letters -> 150 points
    score = 50 * (len(string_score)-3) + 50

    return score

#---------------- TESTS --------------------------
#print(score_word("ABJURE"))
#print(score_word("ACADEMIA"))
#print(score_word("CARRYALL"))
#print(mylist)
#-------------------------------------------------

def check_word_letters(word, letters):
    """
    check_word_letter(string, list of characters) -> boolean

    check_word_letter() checks if the string provided arose from letters
    stored in our list. If it does, it returns True. Otherwise, it returns
    False.
    """

    # for loop to go through the letters of the word
    for index in range(0, len(word), 1):

        letter = word[index] #word[3] = k
        if letter in letters:
            # remove the letter in letters list
            letters.remove(letter)
        else:
            # we didn't find the letter in the list,
            # so we should return False
            return False

    return True

def display_directions():
    """
    display_directions() -> ()

    Prints directions for words with classmates 
    """

    # prompt the player -- gives them directions on what to do
    print("------------------------------------------------------------------")
    print(" \t \t Welcome to Words with Classmates!")
    print("------------------------------------------------------------------")
    print("Below is a list letters. Enter all the English words you can think ")
    print("of that use some subset of those letters. Three letter words earn ")
    print("50 points, and each additional letter is worth 50 more points. So ")
    print("a 5 letter word is worth 150 points total. Good luck!")
    print("------------------------------------------------------------------")


def display_letters(letters):

    display_letters = ""

    for letter in letters:
        display_letters = display_letters + letter + " "

    # print of the letters the user must work with 
    print("\n \nYour letters are: \n")
    print(display_letters)
    print("\n")

def write_to_leaderboard(name, score):
    """ write_to_leaderboard(name, score) -> ()

    Adds the score and name to a text file called leaderboard. Sorts that
    file so it is in order. Then prints the contents.
    """

    leaderboard = open("leaderboard.txt", "a")
    leaderboard.write(name + ": " + str(score) + "\n")
    leaderboard.close()

    leaderboard = open("leaderboard.txt", "r")
    
    #storing the lines in a list
    leaderboard_list = leaderboard.readlines()

    
    for i in range(len(leaderboard_list)):
        #remove the new line character 
        leaderboard_list[i] = leaderboard_list[i].strip("\n")
    
        # splitting the lines into lists with names and scores 
        leaderboard_list[i] = leaderboard_list[i].split(": ")

        # converting the score into an integer
        leaderboard_list[i][1] = int(leaderboard_list[i][1])

    # sort in descending order 
    leaderboard_list.sort(key = lambda x: x[1], reverse = True)
    
    leaderboard.close()

    # write the scores back to file and print
    leaderboard = open("leaderboard.txt", "w")
    # [['CS112', 850], ['CS112', 500], ['Alex', 450], ['BadLetters', 200]]
    for entry in leaderboard_list:
        leaderboard.write(entry[0] + ": " + str(entry[1]) + "\n")
        print(entry[0] + ": " + str(entry[1]) + "\n")
    

    

# creating the game using these functions
def words_with_classmates():
    """
    words_with_classmates() -> ()

    Runs the game called Words with Classmates. The player is given
    a list of letters and they are asked to produce as many words as
    possible. They will then receive a score.
    """

    display_directions()
    
    word = ""
    total_score = 0
    
    while(word != "1"): # each letter set 
        # provide the player with num_of_letters
        letters = random_letters(8)

        display_letters(letters)

        word = ""
        memory_valid = []
        memory_invalid = []


        
        #first input 
        print("Enter a word below or \ntype '0' to lose 50 points and" + \
                " get new letters or \ntype '1' to exit the game:")
        word = input().upper()

        if (word == "1"):
            print("You have elected to end the game. Your final score is " + str(total_score))
            break
        
        while(word != "0" and word !="1"): #each word submission
            
            # repeat what the user entered and indicate whether or not it is valid
            print("You entered: " + word)

            copy_of_letters = letters.copy() #makes it a separate copy of the list 
            

            if word in memory_valid: #repeat of valid word
                print("This is a repeat!")
            elif word in memory_invalid: #repeat of invalid word
                print("This is a repeat of an invalid word!")
            else: #not a repeat 
                if reference(word) and check_word_letters(word, copy_of_letters):
                    print("This is a valid word! Your score for the word is...")
                    score = score_word(word)
                    print(score)
                    total_score = total_score + score
                    print("Your total score is " + str(total_score))
                    memory_valid.append(word) # track repeats
                else:
                    print("This is not a valid word! Your score is " + str(total_score))
                    memory_invalid.append(word) #track repeats



            # 2nd, 3rd, 4th inputs here 
            print("Enter a word below or \ntype '0' to lose 50 points and" + \
                " get new letters or \ntype '1' to exit the game:")
            word = input().upper() # Helena 
        
        if (word == "1"):
            print("You have elected to end the game. Your final score is " + str(total_score))
            break
        
        total_score = total_score - 50
        print("You typed 0; your current score is " + str(total_score))

        if(total_score < 0):
            print("You have negative points; you lost the game!")
            break #<-- forces us out of the while loop 
            

    if total_score > 0:
        # they should have their score saved
        print("Enter your name to save your score")
        username = input()
        if username != "":
            print("------------------------------------------------------------------")
            print(" \t \t LEADERBOARD!")
            print("------------------------------------------------------------------")
            # write to leaderboard 
            write_to_leaderboard(username, total_score)
            
    print("Goodbye!")
    


    # LEADER BOARD:
        # How will we display the board?
        # How will we store? (file)
        # Take in player names (stored in file)
        # For now: we're going to save the scores, then we'll sort
        

    # FIXES:

        #2. (Alex) compress code a little using lambda functions?
        #??3. (Dr. JZ) Can we play again after we quit a particular round?
        #5. (Alex) Can we make a Leaderboard?
        #6. (Yasar) Deduct points if you submit an invalid or repeated word.

