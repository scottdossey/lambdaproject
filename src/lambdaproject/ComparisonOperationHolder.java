package lambdaproject;

public interface ComparisonOperationHolder {
	// returns 0 if two strings are equal
	// return <0 if "a" is lexicographically before "b".
	// return >0 if "a" is lexicographically after "b" 
	int compareOperation(String a, String b);
}
