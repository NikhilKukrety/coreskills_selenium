
public class Synchronization {

	public static void main(String[] args) {

		//Waits:
		//There is no mechanism to use only 1 wait. You can use any wait for your framework.
		//Implicit wait is more recommended.
		
		/* 1. Implicit wait: Hey, wait for 'n' number of seconds before you throw an exception.
			  It is defined globally which means, it is applicable at every step.
			  If page loads in less than 'n' seconds, it will not wait for 'n' seconds, and will come out of the link.
			  So, 'n' is the maximum time out limit.
			  Disadvantage of Implicit wait is that it cannot be specifically target a particular step.
			  Another disadvantage is Performance issue. Suppose you give 5 seconds wait, but say a step should be executed in
			  3 seconds, but it takes 5 seconds, but your test is passing. Hence, this bug will be hidden.
			  It is same for all steps. To solve this problem, we have EXPLICIT WAIT.
			  Code is Readable.*/
		
		/* 2. Explicit wait: If a particular step takes more than 'n' seconds, then we can target a specific element.
		 * Wait is applied to target elements.
		 * There is no performance issue.
		 * Disadvantage is more lines of code.*/
		
		/* 3. Thread.sleep(n000) - Hold the complete test for 'n' seconds It does not come out like implicit wait.
		 * Thread.sleep() is a part of Java and not selenium.*/
		
		/*IMPORTANT - Combination of both is recommended to achieve synchronization.*/
		
		
		
		

	}

}
