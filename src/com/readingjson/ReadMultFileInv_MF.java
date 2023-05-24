package com.readingjson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadMultFileInv_MF {

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
		FileReader filereader = null;
		Object obj;
		JSONParser js = new JSONParser();
		File sourceFolder = new File("./InvAcct/");
		String fileExt = "";
		for (File sourceFile : sourceFolder.listFiles()) {
			String fileName = sourceFile.getName();
			// System.out.println(fileName);
			filereader = new FileReader("./InvAcct/" + fileName);
			obj = js.parse(filereader);
			JSONObject read = (JSONObject) obj;

			fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (fileExt.equalsIgnoreCase("json")) {

				JSONArray accountFundManagerDetailsArray = (JSONArray) read.get("AccountFundManagerDetailsArray");
				JSONObject detailsArray = (JSONObject) accountFundManagerDetailsArray.get(0);
				
				//RgstNumExtIdnValTxt
				JSONArray registerNumberExternalIdentificationArray= (JSONArray)detailsArray.get("RegisterNumberExternalIdentificationArray");
				JSONObject rgstNumExtIdnValTxt=(JSONObject)registerNumberExternalIdentificationArray.get(0);
				String rgstNumExtIdnValTxtVal=(String)rgstNumExtIdnValTxt.get("RgstNumExtIdnValTxt");
				     System.out.print(rgstNumExtIdnValTxtVal+",");
				
		    // CltNumExtIdnValTxt		     
			JSONArray clientIdentificationArray= (JSONArray)detailsArray.get("ClientIdentificationArray");
			JSONObject cltNumExtIdnValTxt=(JSONObject)clientIdentificationArray.get(0);
			JSONObject	clientNumberExternalIdentification=(JSONObject)cltNumExtIdnValTxt.get("ClientNumberExternalIdentification");
			String cltNumExtIdnValTxt1=(String)clientNumberExternalIdentification.get("CltNumExtIdnValTxt");
						     System.out.print(cltNumExtIdnValTxt1+",");
				     
				     
				// AgtFndPrtcpnIdTxt
				String agtFndPrtcpnIdTxt = (String) detailsArray.get("AgtFndPrtcpnIdTxt");

				// AgtPtyRlIdTxt
				String agtPtyRlIdTxt = (String) detailsArray.get("AgtPtyRlIdTxt");

		       // FndPtyRlRef
				JSONObject fndPtyRlRef = (JSONObject) detailsArray.get("FndPtyRlRef");
				
				String fndPtyRlIdTxt = (String) fndPtyRlRef.get("FndPtyRlIdTxt");
				System.out.print("fndPtyRlIdTx:->"+fndPtyRlIdTxt+",");
				
								// ProdRef
				/*JSONObject prodRef = (JSONObject) detailsArray.get("ProdRef");
				String prodIdTxt = (String) prodRef.get("ProdIdTxt");
				System.out.print("prodIdTxt:->"+prodIdTxt+",");*/

				// InvmtAcctIdentfierTxt
				String invmtAcctIdentfierTxt = (String) read.get("InvmtAcctIdentfierTxt");
				
				//AcctTyp
				String acctTyp = (String) read.get("AcctTyp");
				System.out.print(fileName + "," + invmtAcctIdentfierTxt + "," + agtFndPrtcpnIdTxt + "," + agtPtyRlIdTxt
						+ "," + acctTyp + ",");
				JSONArray data1 = (JSONArray) read.get("InvestmentAccountRoleArray");
				for (int i = 0; i < data1.size(); i++) {
					JSONObject investor = (JSONObject) data1.get(i);

					// PtyRlIdTxt
					String invest = (String) investor.get("PtyRlIdTxt");
					System.out.print(invest + ",");
				}
				System.out.println();

			} else {
				System.out.println("Not support");
			}

		}
		return fileExt;
	}

}
