package com.readingjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AFP_MF {

	public static void main(String[] args) throws ParseException, IOException {

		/*
		 * File sourceFolder =new File("./Data/"); String fileExt=""; for(File
		 * sourceFile : sourceFolder.listFiles()){ String
		 * fileName=sourceFile.getName();
		 * fileExt=fileName.substring(fileName.lastIndexOf(".")+1);
		 * if(fileExt.equalsIgnoreCase("json")){
		 * 
		 * 
		 * System.out.println(fileName); }else{
		 * System.out.println("Not support"); }
		 */
		
		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		 Object obj;
		JSONParser js=new JSONParser();
		File sourceFolder = new File("./AgentFundParticipation/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			//System.out.println(fileName);
			fileresder = new FileReader("./AgentFundParticipation/"+fileName);
			obj = js.parse(fileresder);
			 JSONObject read=(JSONObject)obj;		 
			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {
				JSONArray accountFundManagerDetailsArray = (JSONArray) read.get("AgentFundHierarchyArray");
				JSONObject agentFundHierarchyArray = (JSONObject) accountFundManagerDetailsArray.get(0);
				JSONObject fndPtyRlRef=(JSONObject)agentFundHierarchyArray.get("FndPtyRlRef");
				String fndPtyRlIdTxt=(String)fndPtyRlRef.get("FndPtyRlIdTxt");
				
				 String agtFndPrtcpnIdTxt=(String) read.get("AgtFndPrtcpnIdTxt");
				 String ptyRlAgtIdTxt=(String) read.get("PtyRlAgtIdTxt");
				System.out.println(fileName+","+agtFndPrtcpnIdTxt+","+ptyRlAgtIdTxt+","+fndPtyRlIdTxt);
			} else {
				System.out.println("Not support");
			}

		}
		return fileExt;
	}

}
