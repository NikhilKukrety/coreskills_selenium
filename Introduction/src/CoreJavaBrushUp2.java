import java.util.ArrayList;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//If Else Statement:
		
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
		
		//Now, print only those values from above array which are multiple of 2:
		
		for(int a = 0; a<arr2.length; a++)
		{
			if(arr2[a] % 2 == 0)
			{
				System.out.println(arr2[a]+" is a multiple of 2");
			}	
			else
			{
				System.out.println(arr2[a]+" is not a multiple of 2");
			}
			}
		
		//Array Lists (Dynamic arrays which are used in real time):
		//Syntax: Creating object 'a' for the class "ArrayList":
		
		//ArrayList a = new ArrayList();
		
		//Now, this object 'a' can be used to access all the methods present in class "ArrayList"
		//Example: create a dynamic array of type string:
		
		ArrayList<String> a = new ArrayList<String>();
		
		//Now adding values to this array:
		a.add("Nikhil");
		a.add("Kukrety");
		
		//To get a value from the arraylist by index:
		a.get(0);
	
		//Printing the array:
		System.out.println(a.get(1));
		//Remove any value by index:
		a.remove(0);
	
		
		
		
		}

	}


