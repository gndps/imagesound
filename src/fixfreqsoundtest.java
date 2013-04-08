import javax.sound.sampled.LineUnavailableException;

import example.fixedfreqsine.FixedFreqSine;


public class fixfreqsoundtest {
	
	public static void main(String[] args)
	{
		try {
			FixedFreqSine a= new FixedFreqSine(550, 1);

			FixedFreqSine b= new FixedFreqSine(450, 1);
			FixedFreqSine c= new FixedFreqSine(250, 1);
			FixedFreqSine d= new FixedFreqSine(350, 1);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
