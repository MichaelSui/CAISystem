package cn.sjy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

public class FileUtils {
    // 将String类型的字符串content写入目录为directory的fileName文件之中。
    public static boolean writeFile(String directory, String fileName, String content) {
	byte[] contentByte = content.getBytes();
	if (contentByte != null) {
	    try {
		File file = new File(directory + "\\" + fileName);
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

    // 删除directory目录下的所有名字带有fileName的文件。
    public static boolean deleteAllFile(String directory, String fileName) {
	File file = new File(directory);
	if (!file.exists() || !file.isDirectory()) {
	    return false;
	} else {
	    String pattern = fileName + "[\\.]?[0-9a-zA-Z]*";
	    String[] fileList = file.list();
	    for (int i = 0; i < fileList.length; i++) {
		if (Pattern.matches(pattern, fileList[i])) {
		    String deleteFilePath = directory + "\\" + fileList[i];
		    File deleteFile = new File(deleteFilePath);
		    if (deleteFile.isFile()) {
			deleteFile.delete();
		    }
		}
	    }
	    return true;
	}
    }

    // 获取directory目录下的全部文件名。
    public static String[] getAllFileName(String directory) {
	File file = new File(directory);
	if (!file.exists() || !file.isDirectory()) {
	    return new String[0];
	} else {
	    return file.list();
	}
    }
}
