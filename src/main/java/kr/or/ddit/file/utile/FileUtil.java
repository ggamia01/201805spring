package kr.or.ddit.file.utile;

import java.io.File;
import java.util.UUID;

import kr.or.ddit.file.model.FileVo;

//FileUtil.getFileExt(String fileName);
//확장자가 있을 경우 .을 포함한 확장자 값을 리턴
//확장자가 없을 경우 ""whitespace를 리턴
// 테스트값 : sally.png ==> .png
// 테스트값 : sally ==> ""
public class FileUtil {
	public static String getFileExt(String fileName) {

		int fileNameExt = fileName.lastIndexOf(".");
		String ext="";
		if(fileNameExt >0) {
			ext = fileName.substring(fileName.lastIndexOf("."));
			
			return ext;
		}else {
			return "  ";
		}
		 
	}
}
