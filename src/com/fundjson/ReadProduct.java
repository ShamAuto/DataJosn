package com.fundjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadProduct {

	public static void main(String[] args) throws ParseException, IOException {

		readjsonFile();
	}

	public static String readjsonFile() throws IOException, ParseException {
		FileReader fileresder = null;
		JSONArray accountFundManagerDetailsArray;
		JSONObject detailsArray = null;
		Object obj;
		JSONParser js = new JSONParser();
		File sourceFolder = new File("./FundJson/Product/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			System.out.print(fileName+" ,");
			fileresder = new FileReader("./FundJson/Product/" + fileName);
			obj = js.parse(fileresder);
			JSONObject read = (JSONObject) obj;

			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {

				accountFundManagerDetailsArray = (JSONArray) read.get("Products");
				detailsArray = (JSONObject) accountFundManagerDetailsArray.get(0);
				
				String productIdentifierText=(String)detailsArray.get("ProductIdentifierText");
			     System.out.print(productIdentifierText+",");
		
			     JSONArray productFundPartyRole=(JSONArray)detailsArray.get("ProductFundPartyRoleAssociationArray");
			     
					for (int i = 0; i < productFundPartyRole.size(); i++) {
						JSONObject data1 = (JSONObject) productFundPartyRole.get(i);
					     String	fundPartyRoleIdentifierText   =(String)data1.get("FundPartyRoleIdentifierText");
				         System.out.print(fundPartyRoleIdentifierText +","); 
					}
				
					JSONArray productShareClassLinkageArray=(JSONArray)detailsArray.get("ProductShareClassLinkageArray"); 
					
					if(productShareClassLinkageArray!=null){
					for (int j = 0; j<productShareClassLinkageArray.size(); j++) {
						JSONObject data2 = (JSONObject) productShareClassLinkageArray.get(j);
					    String	productShareClassLinkagFundIdentifierText   =(String)data2.get("ProductShareClassLinkagFundIdentifierText");
					    String	productShareClassLinkageShareClassIdentifierText   =(String)data2.get("ProductShareClassLinkageShareClassIdentifierText");
				        System.out.print(productShareClassLinkagFundIdentifierText +","+productShareClassLinkageShareClassIdentifierText);
				        //System.out.print(productShareClassLinkageShareClassIdentifierText+",");
					}
					}
					
					System.out.println();
				}
				
		else {
			
				System.out.println("Not support");
			}

	
	}
		return fileExt;

}}
