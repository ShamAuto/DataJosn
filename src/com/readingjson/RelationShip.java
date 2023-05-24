package com.readingjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RelationShip {

	public static void main(String[] args) throws ParseException, IOException {

		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		 Object obj;
		JSONParser js=new JSONParser();
		File sourceFolder = new File("./PartyRoleRelationship/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			//System.out.println(fileName);
			fileresder = new FileReader("./PartyRoleRelationship/"+fileName);
			obj = js.parse(fileresder);
			 JSONObject read=(JSONObject)obj;
			 
			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {
				 String data1=(String) read.get("PtyRlRelspIdTxt");
				 String data2=(String) read.get("PrimPtyRlIdTxt");
				 String data3=(String) read.get("ScndryPtyRlIdTxt");
				 String data4=(String) read.get("RelspTyp");
				 
				System.out.println(fileName+","+data1+","+data2+","+data3+","+data4);
			} else {
				System.out.println("Not support");
			}

		}
		return fileExt;
	}

}
