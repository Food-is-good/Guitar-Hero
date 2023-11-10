import java.util.Random;

public class GuitarString {
	
	public RingBuffer ringBuffer;
	public int cap;
	
	public GuitarString (double frequency)
	{
		cap = (int) Math.ceil(44100.0 / frequency);
		ringBuffer = new RingBuffer(cap);
		
		for(int x = 0; x < cap; x++)
		{
			ringBuffer.enqueue(0.0);
		}
	}
	
	 public GuitarString (double[] init)
	{
		cap = init.length;
		ringBuffer = new RingBuffer(cap);
		
		for( double val: init)
		{
			
			ringBuffer.enqueue(val);
		}
		
		
	}
	
	public void pluck()
	{
		Random ranval = new Random();
		
		int cap = ringBuffer.cap();
		
		for(int x =0; x < cap; x++)
		{
			
			Double ranVal = ranval.nextDouble() - 0.5;
			
			ringBuffer.dequeue();
			ringBuffer.enqueue(ranVal);
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
