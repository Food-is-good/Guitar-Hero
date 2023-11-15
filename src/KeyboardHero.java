
public class KeyboardHero {
	
	public static String song = "cbm;/;mbcnm/mvcbm;/;,mvccdcdz[pzcvbvczbmbvcvc=[=xcvdczd=bvccdc=[zcmnmnbbvcz=vbvc ";
	public static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/'S";
	public static char key;
	public static GuitarString[] ta;
	
	public static void main(String[] args) {
		
		double TEXT_POS_X = .5;
        double TEXT_POS_Y = 1;
        
        double[] cnt = new double[song.length()];
        
        
        ta = new GuitarString[keyboard.length()];
		
		for(int i = 0; i<keyboard.length(); i++) {
			ta[i] = new GuitarString(440*Math.pow(1.05956, i-24));
		}
		
		for(int i = 0; i<cnt.length; i++) {
			cnt[i] = 1;
		}
		
		int count = -1; 
		
		for(char a : song.toCharArray()) {
			count++;
			boolean correct = true;
			
			TEXT_POS_X = (keyboard.indexOf(a))/35.0;
			TEXT_POS_Y = cnt[count];
			
			StdDraw.text(TEXT_POS_X, TEXT_POS_Y, String.valueOf(a));
			
			while(correct) {
				
				if(StdDraw.hasNextKeyTyped()) {
					key = StdDraw.nextKeyTyped();

					if(key == a) {
						correct = false;		
						play(key);
						StdDraw.clear();
					}
					else {
						play(key);
					}
					
				}
				
				double sample = 0;
		        // advance the simulation of each guitar string by one step
		        for(int i = 0; i<keyboard.length(); i++){
		        	ta[i].tic();
		        	sample+=ta[i].sample();
		        }
		        
		        StdAudio.play(sample);
		        cnt[count]-=0.01;
		        
			}
			
		}		
	}
	
	public static void play(char key) {        // the main input loop
    	
    	int temp = 0;

        if(keyboard.indexOf(String.valueOf(key))!=-1) {
        	temp = keyboard.indexOf(String.valueOf(key));
        	ta[temp].pluck();
        }  
        
    }
}
