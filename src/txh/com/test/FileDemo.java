package txh.com.test;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dest = new File("pass.txt");
		try {
			FileUtil.writeTextFile(dest, "imopan507:123456");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String data = FileUtil.readTextFile(dest);
			String[] up = data.split(":");
			System.out.println("name:"+up[0]);
			System.out.println("pass:"+up[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
