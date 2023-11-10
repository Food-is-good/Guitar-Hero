import java.util.Random;

public class GuitarString {
	
	public GuitarString (double frequency)
	{
		int cap = (int) Math.round(44100.0 / frequency);
		RingBuffer ringBuffer = new RingBuffer(cap);
		
		for(int x = 0; x < cap; x++)
		{
			ringBuffer.enqueue(0.0);
		}
	}
	
	 public GuitarString (double[] init)
	{
		int capacity = init.length;
		RingBuffer = new RingBuffer(cap);
		
		for( double val: init)
		{
			
			RingBuffer.enqueue(value);
		}
		
		
	}
	
	public void pluck()
	{
		Random ranval = new Random();
		
		int cap = ringBuffer.cap();
		
		for(int x =0; x < cap; x++)
		{
			
			 ranval = random.nextDouble() - 0.5;
			
			RingBuffer.dequeue();
			RingBuffer.enqueue(ranval);
		}
	}
	
	
	
	
	void tic()
	{
		
	}
	
	double sample()
	{
		return 0;
		
	}
	
	int time()
	{
		return 0;
		
	}

}
