import java.util.NoSuchElementException;

public class RingBuffer {
	
	public double[] buffer;
	
	public RingBuffer(int capacity) {
		buffer = new double[capacity];
	}
	
	public int size() {
		int sum = 0;
		for(double i : buffer) {
			if(!(i==0.0)) {
				sum++;
			}
		}
		return sum;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean isFull() {
		return size()==buffer.length;
	}
	
	public void enqueue(double x) {
		if(isFull()) {
			throw new IllegalStateException();
		}
		else {
			buffer[size()] = x;
		}
	}
	
	public double dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			for(int i = 0; i<buffer.length; i++) {
				if(!(buffer[i]==0.0)) {
					Double temp = buffer[i-1];
					buffer[i-1] = 0.0;
					return temp;
				}
			}
		}
		return 0.0;
	}
	
	public double peek() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			for(int i = 0; i<buffer.length; i++) {
				if(!(buffer[i]==0.0)) {
					return buffer[i-1];
				}
			}
		}
		return 0.0;
	}
	
	public String toString() {
		String t = "[";
		for(double i : buffer) {
			t+=String.valueOf(i)+", ";
		}
		t+="]";
		return t;
	}
}
