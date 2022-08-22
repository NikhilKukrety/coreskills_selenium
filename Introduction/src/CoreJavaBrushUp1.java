
public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=5;
		String name = "Nikhil";
		char letter = 'r';
		double dec = 5.99;
		boolean res = true;
		
		System.out.println("Number displayed is "+num);
		
		//These are examples of static arrays. Dynamic arrays are called arraylists.
		//Arrays - First way - Use this method when we don't know the values initially:
		//Always first declare an array:
		//Below means size of integer array "arr" will be 5:
		int[] arr = new int[5];
		
		//We always start giving values to arrays starting from index 0:
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 5;
		arr[4] = 6;
		
		//second/shortcut way - Directly assigning values to variables - use when we already know the values:
		int[] arr1 = {1,2,3,4,5};
		
		//Accessing the array:
		System.out.println(arr1[0]);
		
		
		//For loop statement:
		for (int i=0; i<arr1.length; i++)
		{
			System.out.println(arr1[i]);
		}
		
		//Printing array of string:
		String[] name1 = {"Nikhil", "Arnav", "Max", "Mummy", "Papa"};
		
		for(int j=0; j<name1.length; j++)
		{
			System.out.println(name1[j]);
		}
		
	


	
	/*Enhanced For loop - write the array name and put a colon on the left,
	and then declare a variable with data type string*/
		
		for(String s: name1)
		{
			System.out.println(s);
		}
	}

}
