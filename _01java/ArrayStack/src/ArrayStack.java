
public class ArrayStack {
	private int top;
	private int maxSize;
	private Object[] stackArray;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new Object[this.maxSize];
		this.top = -1;		//top은  0으로 해놓으면 안된다. 스택에 자료가 하나 있을때 top이 0이 되어야하기때문에
	}
	
	//stack 공간이 비어 있는지 확인
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//stack 공간이 꽉차 있는지 확인
	public boolean isFull() {
		return (top == maxSize-1);
	}
	
	//insert == push
	public void push(Object item) {
		if(isFull()){
			return;
			//throw new ArrayIndexOutOfBoundsException((top+1) + ">=" + maxSize);
		}
		stackArray[++top] = item;
	}
	
	//select == peek(top을 취득하는 것)
	public Object peek(){
		if(isEmpty()){	
			throw new ArrayIndexOutOfBoundsException(top);
			
		}
		return stackArray[top];
	}
	
	//delete == pop ()
	public Object pop(){
		Object item = peek();
		top--;
		return item;
	}
	
}
