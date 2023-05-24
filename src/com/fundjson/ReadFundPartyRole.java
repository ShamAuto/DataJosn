package com.fundjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFundPartyRole {

	public static void main(String[] args) throws ParseException, IOException {

		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		JSONArray fundPartyRoles;
		JSONObject detailsArray = null;
		Object obj;
		JSONParser js = new JSONParser();
		File sourceFolder = new File("./FundJson/FundPartyRole/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			System.out.print(fileName+" ,");
			fileresder = new FileReader("./FundJson/FundPartyRole/" + fileName);
			obj = js.parse(fileresder);
			JSONObject read = (JSONObject) obj;

			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {

				fundPartyRoles = (JSONArray) read.get("FundPartyRoles");
				detailsArray = (JSONObject) fundPartyRoles.get(0);
			   String fundPartyRoleIdentifierText=(String)detailsArray.get("FundPartyRoleIdentifierText");
			   String fundPartyRoleType=(String)detailsArray.get("FundPartyRoleType");
			   System.out.println(fundPartyRoleIdentifierText+" ,"+fundPartyRoleType);
			   
				}
				
		else {
			
				System.out.println("Not support");
			}

	
	}
		return fileExt;

}}
