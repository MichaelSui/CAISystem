package cn.sjy.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
    public static boolean writeFile(String path, String content) {
	byte[] contentByte = content.getBytes();
	if (contentByte != null) {
	    try {
		File file = new File(path);
		if (!file.exists()) {
		    File dir = new File(file.getParent());
		    dir.mkdirs();
		    file.createNewFile();
		}
		FileOutputStream outStream = new FileOutputStream(file);
		outStream.write(contentByte);
		outStream.flush();
		outStream.close();
		return true;
	    } catch (Exception e) {
		e.printStackTrace();
		return false;
	    }
	}
	return false;
    }
}
