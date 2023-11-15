
public class GuitarHero {
	
	public String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // String ends with a space
	public GuitarString[] ta;
	public char key;
	
	public GuitarHero () {
		ta = new GuitarString[keyboard.length()];
		
		for(int i = 0; i<keyboard.length(); i++) {
			ta[i] = new GuitarString(440*Math.pow(1.05956, i-25));
		}
    }
    
    public void play(char key) {        // the main input loop
        	
        	int temp = 0;

            if(keyboard.indexOf(String.valueOf(key))!=-1) {
            	temp = keyboard.indexOf(String.valueOf(key));
            	System.out.println(temp);
            	ta[temp].pluck();
            }

            
            double sample = 0;
            // compute the superposition of the samples
            for(int i = 0; i<keyboard.length(); i++){
            	sample+=ta[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int i = 0; i<keyboard.length(); i++){
            	ta[i].tic();
            }
            
        }
}
