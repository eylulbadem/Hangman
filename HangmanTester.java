import java.util.Scanner;

/**
 * Hangman Game Tester
 * @author Eylul Badem
 * @version 2.0, 14.02.2021
*/ 
public class HangmanTester
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Variables
        
        String guessedLetter;
        
        // Program Code
        
        Hangman hangman1 = new Hangman();
        
        System.out.println( "Welcome to the hangman game!");    
        System.out.println();    
        System.out.println( "The letters that can be used for the secret word of hangman: ");
        System.out.println( hangman1.getAllLetters());
        System.out.println( "-----------------------------------------------");
        
        System.out.println( "Maximum allowed incorrect tries for the word: " + hangman1.getMaxAllowedIncorrectTries());

        do {
            System.out.println( "-----------------------------------------------");
            System.out.println( "All used letters: " + hangman1.getUsedLetters());
            System.out.println( "Try a letter");
            
            guessedLetter = scan.nextLine();
            
            System.out.println( "The number of occured letter in the secret word: " + hangman1.tryThis( guessedLetter));
            
            System.out.println( "Number of incorrect tries: " + hangman1.getNumberOfIncorrectTries());
            System.out.println();
            System.out.println(hangman1.getKnownSoFar());
            
        } while ( ! (hangman1.isGameOver()));
        
        
        if ( hangman1.hasLost()) {
            System.out.println( "-----------------------------------------------");
            System.out.println( "           _______");
            System.out.println( "          |/      |");
            System.out.println( "          |      (_)");
            System.out.println( "You Lost  |      /|\\");
            System.out.println( "          |       |");
            System.out.println( "          |      / \\");
            System.out.println( "          |");
            System.out.println( "         _|___");
            System.out.println();
            System.out.println( "The secret word was: " + hangman1.getKnownSoFar() );
        }
        else {
            System.out.println( "-----------------------------------------------");
            System.out.println( "");
            System.out.println( "            (_)");
            System.out.println( "Victory!    \\|/");
            System.out.println( "             |");
            System.out.println( "            / \\");
        }
        
        
    }
    
}