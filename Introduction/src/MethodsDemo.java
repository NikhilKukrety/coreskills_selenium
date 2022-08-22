
public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Methods are always created outside the main box
		
		//calling the method which is created outside the main method:
		
			/*To access the method of a class, we need to create an object of that class,
				and then using that object, we will access the method:*/
		
		MethodsDemo d = new MethodsDemo();
		//calling the method now:
		d.getData();
		
		//Now, moving the method to another class:
		MethodsDemo2 demo = new MethodsDemo2();
		demo.getUserData();
		
		/*Very Important**: If I want to access my methods without using objects,
		 * then I will have to write the word "static" on my method,*/
		
		getMyData();
		
		
	}
	
	public void getData()
	{
		System.out.println("Hello World");
	}
	
	//Static method (to access it without using object):
	public static void getMyData()
	{
		System.out.println("Arnav Kukrety");
	}

}
