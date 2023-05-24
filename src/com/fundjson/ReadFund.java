package com.fundjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFund {

	public static void main(String[] args) throws ParseException, IOException {

		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		JSONArray accountFundManagerDetailsArray;
		JSONObject detailsArray = null;
		Object obj;
		JSONParser js = new JSONParser();
		File sourceFolder = new File("./FundJson/Fund/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			System.out.print(fileName+" ,");
			fileresder = new FileReader("./FundJson/Fund/" + fileName);
			obj = js.parse(fileresder);
			JSONObject read = (JSONObject) obj;

			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {

				JSONArray fund = (JSONArray) read.get("Funds");
				JSONObject detailsArray1 = (JSONObject) fund.get(0);
				String fundIdentifierText=(String )detailsArray1.get("FundIdentifierText");
				System.out.println(fundIdentifierText);
				/*String fundUmbrellaFundIdentifierText=(String)detailsArray.get("FundUmbrellaFundIdentifierText");
			     System.out.print(fundUmbrellaFundIdentifierText+",");*/
			     
			/*	String fundIdentifierText=(String)detailsArray.get("FundIdentifierText");
				     System.out.print(fundIdentifierText+",");
			    
			   JSONArray fundPartyRoleAssociationArray=(JSONArray)detailsArray.get("FundPartyRoleAssociationArray");	     
			   JSONObject fundPartyRole=(JSONObject)fundPartyRoleAssociationArray.get(0);
			   String fundPartyRoleIdentifierText=(String)fundPartyRole.get("FundPartyRoleIdentifierText");
			   System.out.print(fundPartyRoleIdentifierText+" ,");
			    JSONArray shareClassArray=(JSONArray)detailsArray.get("ShareClassArray");
			     
					for (int i = 0; i < shareClassArray.size(); i++) {
						JSONObject data1 = (JSONObject) shareClassArray.get(i);
					     String	shareClassIdentifierText   =(String)data1.get("ShareClassIdentifierText");
				         System.out.print(shareClassIdentifierText +","); 
					}	
					System.out.println();
				}
				
		else {
			
				System.out.println("Not support");
			}

	*/
			}}
		return fileExt;

}}
