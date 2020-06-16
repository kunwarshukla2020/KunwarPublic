package com.mycode.practice;

// A functional interface is basically an interface with a single abstract method. This kind of interfaces are also known as SAM (Single Abstract Method) types
@FunctionalInterface
interface AdderInterface {
	int addNumbers(int a, int b);
	//int divide(int i, int j);
}

interface SubtractInterface {
	int subtract(int i, int j);
}

interface TestShow {
	void show(); //add argument for experiment
}

// With Lambda expressions no need to write implementing class. Also no need to write anonymous inner class. 
/*class A implements AdderInterface{
	public int addNumbers(int a, int b) {
		System.out.println("addddd");
		return a+b;
	}
}*/

//https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm

public class MyClass {

	public static void main(String[] args) {

		AdderInterface obj = (a, b)->  a+b;  // first defining what the implementing interface method will do
		int result = obj.addNumbers(4, 4); 	//calling above interface method in this line, interface should be FunctionalInterface
		System.out.println("result---->> "+result);

		SubtractInterface obj1 = (int a, int b) -> a-b;
		int result1 = obj1.subtract(4, 4);
		System.out.println("result1---->> "+result1);

		TestShow obj2 = () -> System.out.println("Hello World");  //example without arguments
		obj2.show();  //calling above method here, no return type here.
		

	}

//Double Colon Operator in Java 8. It is used as a method reference by replacing lambda expression. Its applicable only in the place where lambda is applicable(means only for functional interface implementaions). So Double colon operator works well in all the places whenever we implement functional interface methods.

}

