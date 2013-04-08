import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;


public class sound1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] buf = new byte[ 1 ];;
	    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
	    
	     try {
			SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
			sdl = AudioSystem.getSourceDataLine(af);
			sdl.open(af);
			sdl.start();
			int amp;
			 	
			    for(int test=1;test<8;test++)
			    {
			for (int i = 1; i < 350  * (float) 44100 / 1000; i++) 
			{
				double angle = i / ((float) 5000*test / 440) * 2.0 * Math.PI;
				amp=100;
				buf[0] = (byte) (Math.sin(angle) * amp);
				sdl.write(buf, 0, 1);
				
			}
			System.out.println(test);
			    }//test for end
			sdl.drain();
			sdl.stop();
			sdl.close();
		}//try end
	    catch (Exception e) 
			{
				e.printStackTrace();
				// TODO: handle exception
			}
	    

	}

}
