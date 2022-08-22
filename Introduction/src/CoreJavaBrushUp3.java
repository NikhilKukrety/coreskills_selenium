
public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//How to declare Strings and Important String methods:
		//Famous interview question:
		//Important:
		/*String is not a sequence of characters. String is an object that represents sequence of characters.
		Understand the difference between the below two scenarios:*/
		//Strings can be declared in 2 ways like below:
		
		//String is an object. String literal method:
		String s1 = "Nikhil Kukrety";
		String s2 = "Nikhil Kukrety";
		/*Here s2 will be pointed to s1's value as both s1 and s2 have same values. So java will not create
		 another object "s2".
		 */
		
		//Second method:
		//		
		String s3 = new String("Welcome");
		String s4 = new String("Welcome");
		/* Here, 2 objects will be created. Using the "new" keyword, I'm explicitly saying to create
		a new object and allocate a memory in Java for this object.*/
		
		//Break a string into 3 (say) pieces. Breaking a string means putting spaces between words.
		
		String s5 = "Nikhil Kukrety NTTDATA";
		s5.split(" "); //By doing this, we splitting Nikhil, Kukrety and NTTDATA.
		//Now we need to catch these splitted strings in an array:
		
		String[] splittedString = s5.split(" ");
		
		//Storing and printing each string:
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[2]);
		
		//To print each character of the string s5, object.charAt() method is used:
		for (int i=0; i<s5.length(); i++)
		{
			System.out.println(s5.charAt(i));
			
		}
		
		//Famous interview question - print the characters/string in reverse order:
		
		for(int j = s5.length()-1; j>=0; j--)
		{
			System.out.println(s5.charAt(j));
		}
		
		
		
		
		
		
		
	}

}
