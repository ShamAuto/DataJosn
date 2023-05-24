package com.fundjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadUmberallaFunds {

	public static void main(String[] args) throws ParseException, IOException {

		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		JSONArray fundPartyRoles;
		JSONObject detailsArray = null;
		Object obj;
		JSONParser js = new JSONParser();
		File sourceFolder = new File("./FundJson/UmbrellaFund/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			System.out.println(fileName+" ,");
			fileresder = new FileReader("./FundJson/UmbrellaFund/" + fileName);
			obj = js.parse(fileresder);
			JSONObject read = (JSONObject) obj;

			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {

				fundPartyRoles = (JSONArray) read.get("UmbrellaFunds");
				detailsArray = (JSONObject) fundPartyRoles.get(0);
			   String umbrellaFundIdentifierText=(String)detailsArray.get("UmbrellaFundIdentifierText");
			   System.out.print(umbrellaFundIdentifierText+" ,\n");
			   
			   JSONArray umbrellaFundPartyRoleAssociationArray=(JSONArray)detailsArray.get("UmbrellaFundPartyRoleAssociationArray");
			     
				for (int i = 0; i < umbrellaFundPartyRoleAssociationArray.size(); i++) {
					JSONObject data1 = (JSONObject) umbrellaFundPartyRoleAssociationArray.get(i);
				     String	fundPartyRoleIdentifierText   =(String)data1.get("FundPartyRoleIdentifierText");
			         System.out.print(fundPartyRoleIdentifierText +","); 
				} 
			   
			   System.out.println();
				}
				
		else {
			
				System.out.println("Not support");
			}

	
	}
		return fileExt;

}}
