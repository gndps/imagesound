import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;


public class WavToByte {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = new String("D:\\shot1.wav");
		File wavFile=new File(path);
		try {
			AudioInputStream ais=AudioSystem.getAudioInputStream(wavFile);
			byte[] data=new byte[ais.available()];
			ais.read(data);
//------------------FIXING NEGATIVE VALUES ----------------------
			
			for(int i=0;i<data.length;i++)
			{
				data[i]+=128;
			}
			
//--------------------ONE SIDE FOR SQUARE IMAGE-----------------------------
			
			int oneSide = (int)Math.ceil(Math.sqrt((double)data.length));
					
//--------------------WRITE COLORS TO NEW BUFFEREDIMAGE----------------------
			BufferedImage img= new BufferedImage(oneSide, oneSide, BufferedImage.TYPE_INT_RGB);
			int i,j,ptr=0;
			for( i = 0; i < oneSide-1; i++ )
			    for( j = 0; j < oneSide-1; j++ )
			    	{
			    	Color c2=new Color(0, 0, Math.abs(data[ptr]));
			    	img.setRGB(i, j, c2.getRGB());
			    	ptr++;
			    	}
//-------------------WRITING BUFFERED IMAGE TO DISK--------------------------
			
			File outputfile = new File("D:\\wavtoimage.png");
		    ImageIO.write(img, "png", outputfile);
		    System.out.println("woosh!!!");
		    
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
