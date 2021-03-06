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
		String path = new String("D:\\artificial.wav");
		File wavFile=new File(path);
		try {
			AudioInputStream ais=AudioSystem.getAudioInputStream(wavFile);
			byte[] data=new byte[ais.available()];
			ais.read(data);
			
//------------------FIXING NEGATIVE VALUES ----------------------
			
			for(int i=0;i<data.length;i++)
			{
			// if (data[i]<0)
				 data[i]=(byte)(128-(int)data[i]);
			}
			
//--------------------ONE SIDE FOR SQUARE IMAGE-----------------------------
			
			int oneSide = (int)Math.ceil(Math.sqrt((double)data.length));
			int temp = data.length;
			System.out.println("lnght="+data.length+"and sqr="+oneSide*oneSide);
			
					
//--------------------WRITE COLORS TO NEW BUFFEREDIMAGE----------------------
			BufferedImage img= new BufferedImage(oneSide, oneSide, BufferedImage.TYPE_INT_RGB);
			int i,j,ptr=0;
			for( j = 0; j < oneSide; j++ )
			    for( i = 0; i < oneSide; i++ )
			    	{
			    	Color c2=new Color(Math.abs(data[ptr]),0, 0 );
			    	img.setRGB(i, j, c2.getRGB());
			    	//img.setRGB(i, j, Math.abs(data[ptr]) );
			    //	System.out.println("pxl["+j+"]["+i+"]  R="+ c2.getRed()+" G="+c2.getGreen()+"  B="+c2.getBlue());
			    	if(ptr==data.length-1)
			    	break;
			    	ptr++;
			    	}
			
		/*	for( j = 0; j < oneSide; j++ )
			    for( i = 0; i < oneSide; i++ )
			System.out.println("data["+j+"]["+i+"] = "+data[ptr]);
			*/
//-------------------WRITING BUFFERED IMAGE TO DISK--------------------------
			
			File outputfile = new File("D:\\FinalOutput.png");
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
