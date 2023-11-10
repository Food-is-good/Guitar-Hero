import java.util.Random;

public class GuitarString {
	
	public RingBuffer ringBuffer;
	public int cap;
	public int count;
	
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
		Random random = new Random();
		
		for(int x =0; x < cap; x++)
		{
			
			double ranVal = (random.nextDouble() * 1.0)-0.5;
			
			ringBuffer.dequeue();
			ringBuffer.enqueue(ranVal);
		}
	}
	
	public void tic()
	{
		count++;
	}
	
	public double sample()
	{
		return ringBuffer.peek();
		
	}
	
	public int time()
	{
		return count;
		
	}

}
