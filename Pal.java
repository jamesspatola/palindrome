/*GitHub personal project
 * James Spatola on 8/2/2018 wrote this
 * direct recursive string test for palindrome*/
import java.util.*;

//create class and define global variables
public class Pal {
	private static Scanner input = new Scanner(System.in);
	private static String test = "",
		modified = "";
	private static boolean flag = true;
	private static int upper = 0,
		lower = 0;

//main method calls first method
	public static void main(String[] args) { begin(); }

//input method with validation
	private static void sinput() {
		test = input.nextLine();
		while (test.length() < 1){
			System.out.print("At least one character is needed for input.\n");
			System.out.print("Please try to reenter: ");
			test = input.nextLine();
		}
	}

//method prompts for test string and calls itself if needed
	private static void begin() {
		System.out.print("Enter a word, phrase, sentence, or paragraph ");
		System.out.print("to be tested if it's a palindrome: ");
		sinput();
		modify();
		if (flag) { begin(); }
	}

//method announces results and prompts for repeat
	private static void ender(boolean answer) {
		System.out.print(test + " tested for palindrome is " + answer + ".\n");
		System.out.print("Do you wish to test another?\n");
		System.out.print("Please enter Y for yes or N for no: ");
		sinput();
		flag = (test.charAt(0) == 'n' || test.charAt(0) == 'N') ? false : true;
	}

//method for removing all non alpha/numeric characters and forcing all lowercase
	private static void modify() {
		modified = test.toLowerCase();
		upper = modified.length() - 1;
		lower = 0;
		for ( int i = upper; i > -1; i-- ) {
			if ( !Character.isLetterOrDigit(modified.charAt(i)) ) {
				if (i == upper) { modified = modified.substring(0, upper); }
				else {
					modified = modified.substring(0, i) + modified.substring((i + 1));
				}
				upper--;
			}
		}
		ender( tester() );
	}

//recursive style method for testing with boolean answer as return
	private static boolean tester() {
		if ( modified.charAt(lower) != modified.charAt(upper) ){ return false; }
		if ( (lower + 2) >= upper ) { return true; }
		lower++;
		upper--;
		return ( tester() );
	}
}