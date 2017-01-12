
public class MyClass<T,A> {
	T num1;
	A num2;
	
	public MyClass(T num1, A num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public T plus() {
		Integer res;
		res = (Integer)num1 + (Integer)num2;
		return (T)res;
	}
}
