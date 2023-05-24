package com.readingjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadMultFile_PR {

	public static void main(String[] args) throws ParseException, IOException {
	
		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		 Object obj;
		JSONParser js=new JSONParser();
		File sourceFolder = new File("./PR/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			//System.out.println(fileName);
			fileresder = new FileReader("./PR/"+fileName);
			obj = js.parse(fileresder);
			 JSONObject read=(JSONObject)obj;
			 
			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {
				JSONObject org = (JSONObject) read.get("OrganizationInformation");
				JSONArray companyNumber = (JSONArray) org.get("CompanyNumberExternalIdentificationArray");
				
				JSONObject compNum=(JSONObject)companyNumber.get(0);
				String coNumExtIdnValTxt=(String)compNum.get("CoNumExtIdnValTxt");
				String data1=(String) read.get("PtyRlIdTxt");
				 String data2=(String) read.get("PtyTyp");
				 String data3=(String) read.get("RlTyp");
				 String data4=(String) read.get("LglEntPtyRlIdTxt");
				 String data5=(String) read.get("RlSubTyp");
				// String data6=(String) read.get("AMLTyp");
				System.out.println(fileName+","+data1+","+data2+","+data3+","+data4+","+data5+","+coNumExtIdnValTxt);
			} else {
				System.out.println("Not support");
			}

		}
		return fileExt;
	}

}
