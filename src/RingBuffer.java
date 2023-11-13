import java.util.NoSuchElementException;

public class RingBuffer {
	
	public double[] buffer;
	public int cC;
	public int size;
	public int first;
	public int last;
	
	public RingBuffer(int capacity) {
		cC = capacity;
		buffer = new double[cC];
		first = 0;
		last = 0;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public String getF() {
		return " "+first+" "+last;
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
			buffer[last] = x;
			last = (last+1)%cC;
			size++;
		}
	}
	
	public double dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			size--;
			Double temp = buffer[first];
			buffer[first] = 0.0;
			first = (first+1)%cC;
			return temp;
		}
	}
	
	public double peek() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else {
			for(int i = 0; i<buffer.length; i++) {
				if(!(buffer[i]==0.0)) {
					return buffer[first];
				}
			}
		}
		return 0.0;
	}
	
	public String toString() {
		String t = "[";
		for(int i = 0; i<size()-1; i++) {
			t+=buffer[(first+i)%cC]+", ";
		}
		if(!isEmpty()) {
			t+=buffer[(first+(size()-1))%cC]+"]";
		}
		else {
			t+="]";
		}
		return t;
	}
}
