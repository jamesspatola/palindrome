/*GitHub personal project
 * James Spatola on 6/14/2018 wrote this
 * string test for palindrome*/
import java.util.*;

public class Pal{

	public static void main(String[] args) {
		
		/*Big loop for test repeat*/
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while (flag){ 
		
			/*Say Hi and grab input for testing*/
			System.out.print("Enter a word, phrase, sentence, or paragraph ");
			System.out.print("to be tested if it's a palindrome: ");
			String s = input.nextLine();
			/*System.out.print("You entered " + s + "\n");*/
			
			/*Here is a string manipulation to remove all upper case, non-alpha/numeric,
			 * and space characters*/
			String t = s.toLowerCase();
			int upper = s.length();
			int lower = 0;
			upper--;
			for (int i = upper; i > -1; i-- ) {
				if ( Character.isLetterOrDigit(t.charAt(i)) ) {}
				else {
					/*left in for testing
					System.out.print("Character " + i + ", " + t.charAt(i));
					System.out.print(" is not alpha/numeric\n");
					 */
					if (i == upper) {
						t = t.substring(0, upper);
					}
					else {
						t = t.substring(0, i) + t.substring((i + 1));
					}
					upper--;
				}
			}
		
			/*test modified string and announce results*/
			while (true) {
				if (upper == lower) {
					System.out.print(s + " is a palindrome!");
					break;
				}
				if (t.charAt(lower) != t.charAt(upper)){
					System.out.print(s + " is not a palindrome.");
					break;
				}
				if ((lower + 1) == upper) {
					System.out.print(s + " is a palindrome!");
					break;
				}
				lower++;
				upper--;
			}
		
			/*Shall we end testing?*/
			System.out.print("\nDo you wish to test another?\n");
			System.out.print("Please enter Y for yes or N for no: ");
			String f = input.nextLine();
			if ( f.charAt(0) == 'n' || f.charAt(0) == 'N' ) {
				flag = false;
			}
		}
	}
}