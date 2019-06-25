package cn.wolfcode.trip.app.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传工具
 */
public class UploadUtil {

	public static String commonPath = "D:/images";

	/**
	 * 处理文件上传
	 * @param file
	 * @param basePath      
	 * @return  123.png
	 */
	public static String upload(MultipartFile file, String basePath) {
		//生成不会重复的文件名，防止重名覆盖掉其它文件
		String uuid = UUID.randomUUID().toString();

		String orgFileName = file.getOriginalFilename();
		String ext= "." + FilenameUtils.getExtension(orgFileName);
		String fileName = uuid + ext;
		try {
			File targetFile = new File(basePath, fileName);
			FileUtils.writeByteArrayToFile(targetFile, file.getBytes());

			return "/upload/" + fileName;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	
}
























