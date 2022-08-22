import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {

  static void print(Object printedLine) {
    System.out.println(printedLine);
  }

  public static void main(String[] args) {

    List<String> wordbank = Collections.emptyList(); // takes 854 words from .txt file of hangman words and puts it into
                                                     // a list called wordbank
    try {
      wordbank = Files.readAllLines(Paths.get("wordbank.txt"), StandardCharsets.UTF_8);
    } catch (IOException ex) {
      System.out.format("I/O error: %s%n", ex);
    }

    Scanner input = new Scanner(System.in);
    Collections.shuffle(wordbank); // shuffle wordbank everytime game is run
    String chosen = wordbank.get(0);
    int length = chosen.length();
    print(chosen);
    print(length);

    //creates dash list of propper length
    ArrayList<String> dashes = new ArrayList<String>();
    for (int i = 0; i < length; i++) {
      dashes.add("_");
    }    
    String guessDashes = String.join(" ", dashes);
    print(guessDashes);
    
    // Check Correct
    boolean correct = false;
    String guess;
    char guessChar;

    while (correct == false) {
      //gets new user input for each guess
      guess = input.nextLine();
      guessChar = guess.charAt(0);
      
      for (int i1 = 0; i1 < length; i1++) {
        if (chosen.charAt(i1) == guessChar) {
          //sets the dash of correctly guessed letter to the letter
          dashes.set(i1, Character.toString(guessChar));
        }
      }
    
      if (chosen.contentEquals(guess)) {
        print("Congratulations!!! You win!");
        correct = true;
        break;
      }
      //printes dashes results after guess
      print(String.join(" ", dashes));
      print(" ");
    }

  }
  }
