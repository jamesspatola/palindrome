/*GitHub personal project
 * James Spatola on 7/14/2018 wrote this
 * string test for palindrome*/
import java.util.*;

//create class, define global variables
public class Pal {
	private static Scanner input = new Scanner(System.in);
	private static String test = "",
		modified = "";
	private static boolean flag = true;
	private static int upper = 0,
		lower = 0;

//have main method start start method
	public static void main(String[] args) {
		while (flag) {
			begin();
		}
	}

//input method with validation
	private static void sinput() {
		test = input.nextLine();
		int tcount = test.length();
		while (tcount < 1){
			System.out.print("At least one character is needed for input.\n");
			System.out.print("Please try to reenter: ");
			test = input.nextLine();
			tcount = test.length();
		}
	}

//method for staring palindrome testing that prompts for test string
	private static void begin() {
		System.out.print("Enter a word, phrase, sentence, or paragraph ");
		System.out.print("to be tested if it's a palindrome: ");
		sinput();
		modify();
	}

//method for showing answer and prompt for repeat
	private static void ender(String answer) {
		System.out.print(test + " is " + answer + "a palindrome.\n");
		System.out.print("Do you wish to test another?\n");
		System.out.print("Please enter Y for yes or N for no: ");
		sinput();
		if ( test.charAt(0) == 'n' || test.charAt(0) == 'N' ) {
			flag = false;
		}
	}

//method for removing all non alpha/numeric characters and forcing all lowercase
	private static String modify() {
		modified = test.toLowerCase();
		upper = modified.length();
		lower = 0;
		upper--;
		for ( int i = upper; i > -1; i-- ) {
			if ( Character.isLetterOrDigit(modified.charAt(i)) ) {}
			else {
				/*left in for testing
				System.out.print("Character " + i + ", " + modified.charAt(i));
				System.out.print(" is not alpha/numeric\n");
				 */
				if (i == upper) {
					modified = modified.substring(0, upper);
				}
				else {
					modified = modified.substring(0, i) + modified.substring((i + 1));
				}
				upper--;
			}
		}
		ender( tester() );
	}

//method for testing with answer as return
	private static String tester() {
		while (true) {
			if ( modified.charAt(lower) != modified.charAt(upper) ){
				return "not ";
			}
			if ( (lower + 2) >= upper ) {
				return "";
			}
			lower++;
			upper--;
		}
	}