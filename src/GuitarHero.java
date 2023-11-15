
public class GuitarHero {
	
	public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // String ends with a space
	public static GuitarString[] ta;
	public static char key;
	
	public static void main(String[] args) {
		
		ta = new GuitarString[keyboard.length()];
		
		for(int i = 0; i<keyboard.length(); i++) {
			ta[i] = new GuitarString(440*Math.pow(1.05956, i-25));
		}
		
        // Create two guitar strings, for concert A and C
        /*double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);
        */

        final double TEXT_POS_X = .2;
        final double TEXT_POS_Y = .5;
        
        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Yay!");
        
        play(ta);
    }
    
    private static void play(GuitarString[] t) {        // the main input loop
        while (true) {
        	
        	int temp = 0;
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                key = StdDraw.nextKeyTyped();
                
                if(keyboard.indexOf(String.valueOf(key))!=-1) {
                	temp = keyboard.indexOf(String.valueOf(key));
                    System.out.println(temp);

                    t[temp].pluck();
                }
                    
            }
            
            double sample = 0;
            // compute the superposition of the samples
            for(int i = 0; i<keyboard.length(); i++){
            	sample+=t[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int i = 0; i<keyboard.length(); i++){
            	t[i].tic();
            }
            
        }
        
    }
}
