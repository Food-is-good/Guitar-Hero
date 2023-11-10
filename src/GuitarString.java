import java.util.Random;

public class GuitarString {
	
	public RingBuffer ringBuffer;
	
	public GuitarString (double frequency)
	{
		int cap = (int) Math.round(44100.0 / frequency);
		ringBuffer = new RingBuffer(cap);
		
		for(int x = 0; x < cap; x++)
		{
			ringBuffer.enqueue(0.0);
		}
	}
	
	 public GuitarString (double[] init)
	{
		int capacity = init.length;
		ringBuffer = new RingBuffer(cap);
		
		for( double val: init)
		{
			
			ringBuffer.enqueue(value);
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
		//The energy decay factor (.994 in this case) models the slight dissipation in energy as the wave makes a roundtrip through the string.
		ringBuffer.dequeue();
		ringBuffer.peek();
		
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
