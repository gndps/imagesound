import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class filetobits {

	/**
	 * @param args
	 * 
	 */
	ReadFile
	public static void main(String[] args) {
		File file = new File("res/shot1.wav");
		try {
			RandomAccessFile f = new RandomAccessFile(file, "r");
			byte[] b = new byte[(int)f.length()];
			
			f.read(b);
			System.out.println("compl.");
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
