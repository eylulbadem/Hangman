/**
 * Hangman Game 
 * @author Eylul Badem
 * @version 2.0, 14.02.2021
*/ 
public class Hangman
{
    private String secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private StringBuffer knownSoFar;
    private int numberOfIncorrectTries; 
    private final int MAX_ALLOWED_INCORRECT_TRIES;

    public Hangman()
    { 
        numberOfIncorrectTries = 0;
        allLetters = new StringBuffer(); 
        usedLetters = new StringBuffer(); 
        knownSoFar = new StringBuffer();

        for ( int i = 97; i <= 122; i++ )
        {
            allLetters.append( (char) i );
        }

        MAX_ALLOWED_INCORRECT_TRIES = 6; // This will be the maximum number of incorrect tries
        numberOfIncorrectTries = 0; // At the start ther is no trying so it is 0
        chooseSecretWord(); 
    
        String stars;
        stars = "";

        for(int a = 0; a < secretWord.length(); a++)
        {
            stars += "*"; // For getting letter number underScore for empty displaying
        }
        
        knownSoFar.append(stars); // There will stars instead of blank spaces with length
    }

    public String SecretWord()
    {
        return "";
    }
    
     /**
     * This method checks the guessed letter if it is present in the secret word
     * @param letter guessed letter by the player 
     * @return number of occurences of given letter in the secret word
     */
    
    public int tryThis( String letter )
    {
        int numberOfOccurences;
        numberOfOccurences = 0;
        if ( checkLetterAlphabet(letter) == true && checkLetterUsed(letter) == true )
        {
            usedLetters.append( letter.charAt(0) );
                
                for ( int e = 0; e < secretWord.length(); e ++ )
                {
                    if ( letter.charAt(0) == secretWord.charAt(e) )
                    {
                        numberOfOccurences ++;
                        knownSoFar.setCharAt( e, letter.charAt(0) );
                    }
                }
                if ( numberOfOccurences == 0 )
                    numberOfIncorrectTries ++;
        }
        
        return numberOfOccurences;
    }
    
    /**
     * This method chooses a word for the Hangman game.
     * One word from the list is assigned as the secretWord.
     * There is no return.
    */ 
    private void chooseSecretWord() {
        int a;
        
        //List of word will be written here.
        String[] wordList = { "mountain" , "computer" , "phone" , "apple" , "birthday" , "headphones" , "elephant" , "programmer" , "pencil" , "family" , "table" , "watch" , "shoes" , "friends" , "snake" };

        //a word from the list will be chosen randomly with Math.random.
        a = (int) ( Math.random() * wordList.length );
        
        secretWord = wordList[a]; 
    }
    
    private boolean checkLetterAlphabet( String letter ) {
        boolean answer;
        int check;
        check = 0;
        answer = false;
        for ( int m = 0; m < allLetters.length(); m ++ )
        {
            if ( letter.charAt(0) == allLetters.charAt(m) ) {
                answer = true;
                check = 1;
            }
        }
        
        if ( check == 0 ) {
            System.out.println();
            System.out.println( "This letter is not a member of the English alphabet!" );
        }
            
        return answer;
    }
    
    private boolean checkLetterUsed( String letter ) {
        boolean answer;
        answer = true;
        for ( int i = 0; i < usedLetters.length(); i ++ )
        {
            if ( letter.charAt(0) == usedLetters.charAt(i) )
            {
                System.out.println();
                System.out.println( "You already tried this letter!" );
                answer = false;
            }
        }
        return answer;
    }
    
    /**
     * @return value of allLetters
     */
    public String getAllLetters() {
        // convert allLetters from StringBuffer to string then return.
        return allLetters.toString();
    }
    
    /** 
     * @return value of usedLetters
     */
    public String getUsedLetters() {
        // convert usedLetters from StringBuffer to string then return.
        return usedLetters.toString();
    }
    
    /**
     * @return value of numberOfIncorrectTries
     */
    public int getNumberOfIncorrectTries() {
        return numberOfIncorrectTries;
    }
    
    /**
     * @return values maxAllowedIncorrectTries
     */

    public int getMaxAllowedIncorrectTries() {
        return MAX_ALLOWED_INCORRECT_TRIES;
    }
    
    /**
     * @return knownSoFar
     */
    public String getKnownSoFar() {
        // convertknownSoFar from StringBuffer to string then return.
        return knownSoFar.toString();
    }

    //public int tryThis(char letter) {}
    /**
     * @return true if the game is over. Otherwise return false
     */
    public boolean isGameOver() {
        String knownString;
        knownString = knownSoFar.toString();
        boolean answer;
        answer = false;
        if(this.hasLost() || knownString.equals(this.secretWord)){

            answer = true;
            knownSoFar = new StringBuffer( secretWord );
            
        }
        return answer;  
    }
    
    /**
     * @return true if the player reaches maximum number of false tries.
     */
    public boolean hasLost() {
        return numberOfIncorrectTries == MAX_ALLOWED_INCORRECT_TRIES;

    }
    
}