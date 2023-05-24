package com.readingjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LetterOFComfort {

	public static void main(String[] args) throws ParseException, IOException {

		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		 Object obj;
		JSONParser js=new JSONParser();
		File sourceFolder = new File("./LetterOfComfort/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			//System.out.println(fileName);
			fileresder = new FileReader("./LetterOfComfort/"+fileName);
			obj = js.parse(fileresder);
			 JSONObject read=(JSONObject)obj;
			 
			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {
				 String data1=(String) read.get("LttrOfCmftIdTxt");
				 String data2=(String) read.get("CmftLttrTyp");
				/* String data3=(String) read.get("ScndryPtyRlIdTxt");
				 String data4=(String) read.get("RelspTyp")*/;
				 
				System.out.println(fileName+","+data1+","+data2);
			} else {
				System.out.println("Not support");
			}

		}
		return fileExt;
	}

}
