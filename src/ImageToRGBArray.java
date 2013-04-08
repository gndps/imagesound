import java.awt.Color;
import java.awt.image.BufferedImage;
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
			
		
//write colors to new BufferedImage
				img2= new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
				int i,j;
				j=0;
				for( i = 0; i < w; i++ )
				    for( j = 0; j < h; j++ )
				    	{
				    	Color c2=new Color(pixels[i][j][0], 0, 0);
				    	img2.setRGB(i, j, c2.getRGB());
				    	
				    	}
				//final int len[][];
			int len[][]=new int[i][j];
				for(i=0;i<w;i++)
					for(j=0;j<h;j++)
						{
						len[i][j]=pixels[i][j][0];
						}
//define totallen of sound				
				
				int totallen=w*h;
				
				byte[] buf = new byte[ 1 ];
			    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
			
//image to sound inputs
			    
					
						SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
						sdl = AudioSystem.getSourceDataLine(af);
						sdl.open(af);
						sdl.start();
						for(int x=0;x<w;x++)
						{
							for(int y=0;y<h;y++)
							{
						for (int run = 0; run < 2200; run++) 
							{
								double angle = run*100 /  (len[x][y]+1) / 440 * 2.0 * Math.PI;
								buf[0] = (byte) (Math.sin(angle) * 1000);
								sdl.write(buf, 0, 1);
								System.out.println("masti");
							}
							}
						}
						sdl.drain();
						sdl.stop();
						sdl.close();
						
						
					
		
				    // retrieve image
				    File outputfile = new File("D:\\saved.png");
				    ImageIO.write(img2, "png", outputfile);
				    File outputfile2 = new File("D:\\saved2.png");
				    ImageIO.write(imgBuffer, "png", outputfile2);
				} 
				catch (IOException e) 
					{
				    	e.printStackTrace();
					}
			
			
/*			
 		//print rgb on console
 		
 			for(int j=0;j<h;j++)
			{
				System.out.println("");
				for(int i=0;i<w;i++)
				{
				System.out.print(" r"+pixels[i][j][0]+" g"+pixels[i][j][1]+" b"+pixels[i][j][2]);
				//System.out.print("()"+(img2.getRGB(i, j)-imgBuffer.getRGB(i, j)));
				}
			}
*/		
		System.out.println("Completed");
		
	}

}
