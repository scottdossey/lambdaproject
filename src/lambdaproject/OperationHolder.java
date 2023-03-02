package lambdaproject;

//Functional interfaces are interfaces that have 
//one unimplemented method.

//There are specific things you can do with functional
//interface in modern Java that you cannot do with
//a interface that has multiple unimplemented methods.

//Around the same time as method references and 
//lambdas were being added, Java added the capability
//to actually have methods in an interface that
//had implementations.  This broke the original JAVA
//model that interfaces were purely for INTERFACE 
//inheritance rather than IMPLEMENTATION inheritance...
//and effectively made JAva a multiple inheritance
//language that supports multiple IMPLEMENTATION inheritance.
public interface OperationHolder {
	Integer operation(Integer a, Integer b);
	

}
