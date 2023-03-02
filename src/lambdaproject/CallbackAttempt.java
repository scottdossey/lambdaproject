package lambdaproject;

import java.util.function.BiFunction;

public class CallbackAttempt {

//	function myFunction(p1, p2) {
//	    return p1*p2;
//	}
//
//	function process(operation) {
//	    x = [1, 2, 3, 4, 5, 6, 7, 8];
//	    y = [2, 4, 5, 6, 7, 8, 9, 10];
//	    sum = 0;
//	    for(let i=0; i<x.length; ++i) {
//	        sum += operation(x[i], y[i]);
//	    }
//	    return sum;
//	}
//
//	//This is a pretty standard example of passing a function to
//	//another function in Javascript.
//	console.log(process(myFunction));

	
	//IN EARLY JAVA, there is no way to pass
	//a method as a reference......so this code 
	//would have to use some other approach..
	
	//Instead of passing a method directly which 
	//we can't do, we could pass an object, and call
	//a known method on that object.
	
	
	//I can use the interfaces of java.util.function in many
	//cases to quickly declare a functional interface.
	
	//I just have to use the write Interface with the write type
	//parameters
	//BiFunction<Integer, Integer, Integer> holder
	public static int process(OperationHolder holder) {
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] y = {2, 4, 5, 6, 7, 8, 9, 10};
		int sum = 0;
		for(int i=0; i<x.length; ++i) {
			sum += holder.operation(x[i], y[i]);
		}
		return sum;		
	}
	
	public static void displayComparison(ComparisonOperationHolder holder, 
			                             String a,
			                             String b) {
	
		int result = holder.compareOperation(a, b);
		if(result == 0) {
			System.out.println("Strings are equal");
		} 
		else if(result > 0) {
			System.out.println("A>B");
		}
		else {
			System.out.println("A<B");
		}			
	}
	
	public static Widget createWidget(WidgetFactory factory) {
		return factory.factory("default settings");
	}
	
	public static Widget widgetFactoryExample(String settings) {
		return new Widget(settings);
	}
	
	
	public static Integer foobarbaz(Integer a, Integer b) {
		return a*b;
	}
	
	
	public static int compareStringExample(String a, String b) {
		return a.compareTo(b); //wrapping String.compareTo
		//String.compareTo(String other)
 	}
	
	public static void main(String[] args) {
		//Old school way, have to create a class that
		//implements interface.
		MyFunctionHolder holder = new MyFunctionHolder();
		System.out.println(process(holder));
		
		//Now let's do the same thing with a method reference:
		//Static method reference
		System.out.println(process(CallbackAttempt::foobarbaz));
		                         
		//Instance method reference
		System.out.println(process(holder::operation));
		
		//I can call displayComparison with a static method
		//reference....
		displayComparison(CallbackAttempt::compareStringExample, "Hello", "Hello");
		
		//Another option I have is I can pass the third type of method reference.....
	
		displayComparison(String::compareTo, "Hello", "Hello");
		//String::compareTo is a method reference here, but surprisingly
		//it doesn't conform to the same interface as displayComparison wants.
		//displayComparison takes a ComparisonOperationHolder functional interface
		//and therefore it expects a method that has the same signature as:
		//
		//int compareOperation(String a, String b);
		//
		//IF we look String::compareTo we will discover that its
		//method signature is:
		//
		//int compareTo(String anotherString)
		//
		//How is this working?  Well this the third type of method
		//reference....the format is 
		//3. ContainingClass::instanceMethodName
		// It will convert the interface call.....
		
		//interface call
		//compareOperation(String a, String b);
		//a.newCall(String b)
		
		//Calling createWidget with a static method reference (type 1)		
		Widget myWidget= createWidget(CallbackAttempt::widgetFactoryExample);
		
		
		//Call createWidget with a constructor method reference (type 4)
		myWidget = createWidget(Widget::new);
		
		
		
		//So Java Method References are a way of referring
		//to a method in Java.
		
		//The method will masquerade as a "Functional Interface"
		
		//There are 4 different types of method references in Java.
		//And they are all represented in a subtly different way.
		//And they are handy to pass a method reference...
		//They are still kinda cumbersome
		
		//In order to have typesafe way to specify what type of method
		//a function takes, the only way to do it is to specify an interface.
		
		//java.util.function
		
		//Java has the concept very similar to Javascript arrow functions.
		//You can define a function right in the middle of the code.
		//In Javascript we define arrow functions with =>
		//In java we define lambda functions with ->
		
		System.out.println("------");
		System.out.println(process((a,b)->a*b));
		
		OperationHolder example = (a,b)->a*b;
		//The arrow functions in JAva have otherwise the exact same syntax
		//as Javascript.
		// GENERAL FORM:
		//  (a, b, ...) -> { <code> };
		
		//If you don't have any parameters you use still
		// have to include the parenthesis () -> { <code> }

		//If you have one parameter, you can omit the parenthesis.
		//a -> { return a+1 };
		
		//If the only thing you are doing in the code is returning a new value...
		//you can omit the {} code block and just specify the new value.
		//a -> a+1; 
		
		//Lastly, you generally don't have to specify types for arrow function
		//parameters, because USUALLY java can figure it out from the context
		//of what type (a functional interface) you are storing the arrow function
		//to---it can usually infer what the types are.
		
		//IN some rare cases.....you may have to specify types....
		//(int a, int b) -> a+b;
		
		//You can use a lambdaa (arrow functions) any place you could
		//use a method reference....IE, where functional interfaces
		//are specified as the type.
		
		
		
		
	}

}
