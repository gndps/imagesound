import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;




public class ImageToRGBArray {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws LineUnavailableException {
		// TODO Auto-generated method stub
		int w=0 ,h = 0;
		Color c;
		BufferedImage imgBuffer,img2 = null;
		try {
			imgBuffer = ImageIO.read(new File("res/rgbimage.png"));
			w=imgBuffer.getWidth();
			h=imgBuffer.getHeight();
			int totallen=w*h;
			int[][][] pixels = new int[w][h][3];
			//get colors to pixels[][][]
			
			for( int i = 0; i < w; i++ )
			    for( int j = 0; j < h; j++ )
			    	{
			    	c = new Color(imgBuffer.getRGB(i,j));
			    	pixels[i][j][0] = c.getRed();
					pixels[i][j][1] = c.getGreen();
					pixels[i][j][2] = c.getBlue();
					
			    	}
			int ptr=0;
			byte buf[]=new byte[totallen];
			for(int y=0;y<h;y++)
				for(int x=0;x<w;x++)
				{
					ptr++;
					buf[ptr]=pixels[x][y][0];
				}
//-------------------CREATING BYTEARRAY INPUT STREAM
			ByteArrayInputStream bias =new ByteArrayInputStream(byte[] buf);
		
//--------------------WRITE COLORS TO NEW BUFFEREDIMAGE----------------------
				img2= new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
				int i,j;
				j=0;
				for( i = 0; i < w; i++ )
				    for( j = 0; j < h; j++ )
				    	{
				    	Color c2=new Color(pixels[i][j][0], 0, 0);
				    	img2.setRGB(i, j, c2.getRGB());
				    	
				    	}			
		
//--------------------------------RETRIEVE IMAGE-----------------------------
				
				    File outputfile = new File("D:\\saved.png");
				    ImageIO.write(img2, "png", outputfile);
				    File outputfile2 = new File("D:\\saved2.png");
				    ImageIO.write(imgBuffer, "png", outputfile2);
				} 
				catch (IOException e) 
					{
				    	e.printStackTrace();
					}
			
/*-------------------------------PRINT RGB ON CONSOLE------------------------
 * 
 			for(int j=0;j<h;j++)
			{
				System.out.println("");
				for(int i=0;i<w;i++)
				{
				System.out.print(" r"+pixels[i][j][0]+" g"+pixels[i][j][1]+" b"+pixels[i][j][2]);
				//System.out.print("()"+(img2.getRGB(i, j)-imgBuffer.getRGB(i, j)));
				}
			}
-----------------------------------------------------------------------------*/		
		
		System.out.println("Completed");
		
	}

}
