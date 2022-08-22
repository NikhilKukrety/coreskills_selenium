import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

		//STREAM IS A COLLECTION OF STRINGS.
		
		
		//Using normal code - Below is an example to show how to check if how many names are there is an array list which starts with 'A':
		@Test
		public void regular()
		{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Ajinkya");
		names.add("Ram");
		names.add("Adam");
		
		int count = 0;
		
		//Iterating through each String and checking if the name strats with letter 'A':
		
		for(int i =0; i<names.size(); i++)
		{
			String nameReceived = names.get(i);
			if(nameReceived.startsWith("A"))
			{
				count++;
			}
			
		}
		
		System.out.println("Number of names starting with letter 'A' are "+count);
		}
	

		//NOW, USING STREAM, WE WILL PERFORM THE ABOVE OPERATION USING JUST A SINGLE LINE OF CODE:
		@Test
		public void streamFilter()

		{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Ajinkya");
		names.add("Ram");
		names.add("Adam");
		
		//Below, first convert it into stream, then perform intermediate operation "filter", and then perform terminal operation "count":
		//Also, just like we use 'i' for iteration, below is 's' for iteration:
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//We can directly write like this:
		Long d = Stream.of("Abhijeet","Don","Ajinkya","Ram","Adam").filter(s->
		{
			//We can write like this if there are more than one operations to be performed:
			s.startsWith("A");
			return true; //We need to write this (condition)
			
		}).count();
		System.out.println(d);
		
		//To print all the names whose length is greater than 4 using java streams:
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//To print only 1 result:
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		
		}
	
		
		//Now print the strings having name ends with 'a' and also convert them to upper case:
		@Test
		public void streamMap()
		{
			
			ArrayList<String> names = new ArrayList<String>();
			names.add("men");
			names.add("Don");
			names.add("women");

			
			//To manipulate streams, there is a method called "map"
			Stream.of("Abhijeet","Don","Ajinkya","Rama","Adam").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
			.forEach(s->System.out.println(s));
			
			//Now, we need to convert the strings starting with 'a', and SORT them:
			//First convert the array into a array list:
			List<String> names1 = Arrays.asList("Abhijeet","Don","Ajinkya","Rama","Adam");
			names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			//Merging two Lists:
			Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
			
			//Now printing the concatenated list:
			//newStream.sorted().forEach(s->System.out.println(s));
			
			//Commenting above line bcoz once stream is modified, we cannot perform any other operation on it, like below:
			//Checking if "Adam" is present in the concatenated list:
			boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam")); //stores true in variable "flag":
			Assert.assertTrue(flag);
		
		}
		
		
		//Collect method - to collect the results and convert them back to list:
		@Test
		public void streamCollect()
		{
			List<String> newList = Stream.of("Abhijeet","Don","Ajinkya","Rama","Adam").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
			.collect(Collectors.toList());
			System.out.println(newList.get(0)); // This is same as limit (printing first element using collectors).
			
			//Now, print unique numbers from this array, and sort them:
			List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
			
			values.stream().distinct().forEach(s->System.out.println(s));
			
			//Now, sort and print the third index, i.e print 3 - 1,2,3,5,7,9:
			List<Integer> newValues = values.stream().distinct().sorted().collect(Collectors.toList());
			System.out.println(newValues.get(2));
			
		}
		
		
}
	

