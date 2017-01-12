
public class ArrayQueue {
	private int front;	// prev
	private int rear;	// next
	private int maxSize;
	private Object[] queueArray;
	
	public ArrayQueue(int maxSize) {
		this.front = 0;
		this.rear = -1;
		this.maxSize = maxSize;
		this.queueArray = new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return (front == rear +1);
	}
	
	public boolean isFull() {
		return (rear == maxSize -1);
	}
	
	public void push(Object item){
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		queueArray[++rear] = item;
	}
	
	public Object peek() {
		if(isEmpty()){ throw
		new ArrayIndexOutOfBoundsException();
		}
		return queueArray[front];
	}
	
	public Object pop() {
		Object item = peek();
		front ++;
		return item;
	}
}










