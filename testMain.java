import java.util.Scanner;//imports Scanner class 
import java.util.ArrayList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.util.*;

//eventually ask which topic and then do it + graphics
class tesdMain {

  public static void playGame() {

    // words text file from Xethron on Github
    List<String> wordbank = Collections.emptyList(); // takes 854 words from .txt file of hangman words and puts it into
                                                     // a list called wordbank
    try {
      wordbank = Files.readAllLines(Paths.get("wordbank.txt"), StandardCharsets.UTF_8);
    } catch (IOException ex) {
      System.out.format("I/O error: %s%n", ex);
    }
    Collections.shuffle(wordbank); // shuffle wordbank everytime game is run

    String chosenWord = wordbank.get(0); // after

    System.out.println("---------------------------");
    System.out.println(chosenWord);
    System.out.println("");

    int length = chosenWord.length();
    int i = 0;

    System.out.println("WHEN YOU KNOW THE ANSWER, TYPE THE FULL WORD ON YOUR GUESS!!!!!");
    while (i < length) {// prints underscore the length of the chosen word
      System.out.print("_ ");
      i++;
      if (i == length) {
        System.out.println("");
        System.out.println("");
      }
    }
    Scanner input = new Scanner(System.in);
    // String guess1 = input.nextLine();
    int wrongGuess = 0;
    int guessCounter = 0;
    // if the letter is in the word, find the index of the letter in the word and
    // print it above the underscores + create tally so

    // type certain thing during guess if you know what it is

    boolean correct2 = false;

    while (correct2 == false) {
      String guess1 = input.nextLine();

      if (chosenWord.contentEquals(guess1)) {
        System.out.println("Congratulations!!! You win!");
        correct2 = true;
      } else if (chosenWord.contains(guess1)) { //letter correct
        System.out.println("Nice job!");

        ArrayList<String> dashes = new ArrayList<String>();
        for (int i1 = 0; i1 < length; i1++) {
          dashes.add("_ ");
        }
          //Joins dashes to print console
          String guessDashes = String.join(" ", dashes);
          System.out.println(guessDashes);
         
          
        guessCounter = guessCounter + 1;

      } else {
        System.out.println("Sorry, that letter isn't right");
        wrongGuess = wrongGuess + 1;
        guessCounter = guessCounter + 1;
        if (wrongGuess == 10) {
          System.out.println("Aww sorry you lose :(");
          System.exit(0);
        }
      }

    }

    // left to do:
    // end it when wrongGuess reaches 10
    // lines up in the right spot
    // adds person and hook thing
    // makes sure it allows double letters
    // enter full thing at the end to check

  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // Create a Scanner object
    System.out.println("---------------------------");
    System.out.println("Welcome to my Hangman game!");

    boolean correct = false;

    System.out.println("Would you like to play? (Enter Yes or No)");
    while (correct == false) { // will repeat until yes or no is enterred
      String userAns1 = input.nextLine(); // takes user input

      if (userAns1.equalsIgnoreCase("yes")) {
        System.out.println("");
        System.out.println("Do you want to see the rules? (Enter Yes/No)");

        // Scanner rulesInput = new Scanner(System.in);
        String userAns2 = input.nextLine();
        if (userAns2.equalsIgnoreCase("yes")) {
          System.out.println("");
          System.out.println(
              "This game will randomly generate a word for you to guess. It will tell you how many letters are in the word. Non letter characters are not allowed. Once you have guessed incorrectly 10 times, you lose and the game ends.");
        }

        correct = true;
        playGame();
      } else if (userAns1.equalsIgnoreCase("no")) {
        System.out.println("Okay, have a good day! Bye!");
        System.exit(0);
      } else {
        System.out.println("Sorry I didn't get that.");
      }
    }
  }

}