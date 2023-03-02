package lambdaproject;

public class MyFunctionHolder implements OperationHolder {	
	@Override
	public Integer operation(Integer a, Integer b) {
		return a*b;
	}
}
