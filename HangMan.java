import java.io.*;
import java.util.*;
import java.util.Random;


public class HangMan {
	  
	public static void main(String[] args) throws IOException{
		//idk what these two lines of code are supposed to mean
		String[] words = new String[183719];
		readWords(words);
		// hangman implementation goes below
		
		//Retrieve a random word from .txt file
		Random rand = new Random();
		String keyword = words[rand.nextInt(words.length)];
		List<Character> listOfGuesses = new ArrayList<>();

		
		
		//Just for testing
		System.out.println(keyword);

		//Obtaining the user's guesses
		Scanner userInput = new Scanner(System.in);

		while (!(showStatus(keyword, listOfGuesses))) {
		play(userInput, listOfGuesses, keyword);
		}
	}

	
	
   // Store the words from dictionary.txt in an array
	public static void readWords(String[] words)throws IOException {
		File dict = new File("/Users/Cindy/Documents/classes/comp182/HangmanProj/src/dictionary.txt");
		try(Scanner in = new Scanner(dict);){
			int i=0;
			while(in.hasNext()) {
				words[i++]=in.next();
			}
		}
		
	}
	//Shows how far the user has progressed in guessing the keyword
	private static boolean showStatus (String word, List<Character> guesses) {
		int correct = 0;
		for (int i=0; i < word.length(); i++) {
			if (guesses.contains(word.charAt(i)))  {
			System.out.print(word.charAt(i)+ " ");
			correct++;
			}
		else {
			System.out.print("* ");
			}
		}
		System.out.println("");
		return (correct == word.length());
	}
	private static void play(Scanner userInput, List<Character> listOfGuesses, String keyword) {
		System.out.println(" ");
		System.out.println("Enter a 1 letter guess:");
		String userGuess = userInput.nextLine();
		listOfGuesses.add(userGuess.charAt(0));
		
		
	}

	//continuation of game after finishing 
	private static boolean playAgain() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Play again? (Y/N): ");
		String replay = keyboard.nextLine();
		return replay.equals("Y");
	}
}