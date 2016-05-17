package txh.com.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {

	public static String readTextInputStream(InputStream is) throws IOException {
		StringBuffer strbuffer = new StringBuffer();
		String line;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is));
			while ((line = reader.readLine()) != null) {
				strbuffer.append(line).append("\r\n");
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return strbuffer.toString();
	}
	
	public static String readTextFile(File file) throws IOException {
		String text = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			text = readTextInputStream(is);
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return text;
	}
	
	public static void writeTextFile(File file, String str) throws IOException {
		writeByteFile(file, str.getBytes());
	}
	
	/**
	 * 创建文件
	 * 
	 * @param folderPath
	 * @param fileName
	 * @return
	 */
	public static File createFile(String folderPath, String fileName) {
		File destDir = new File(folderPath);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		return new File(folderPath, fileName);
	}

	public static void writeByteFile(File file, byte[] bytes)
			throws IOException {
		if (!file.exists()) {
			String parent = file.getParent() == null ? "." : file.getParent();
			createFile(parent, file.getName());
		}
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream(file));
			out.write(bytes);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
