package com.jsonDiffetence;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class JsonDiff {
	
	@SuppressWarnings("deprecation")
	public static JsonElement getJson1() {
        @SuppressWarnings("deprecation")
		JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement=null;
        try {
            FileReader fileReader = new FileReader("./LE/2202240937PartyRole220224093711_1.json");//Json1 filePath
            jsonElement = jsonParser.parse(fileReader);
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return jsonElement;
    }
    
	 public static void main(String[] args) {
	        JsonElement Json1=getJson1();
	         // JsonElement Json2=getJson2();


	        Gson g = new Gson();
	        Type mapType = new TypeToken<Map<String, Object>>() {
	        }.getType();
	        Map<String, Object> firstMap = g.fromJson(Json1, mapType);
	       System.out.println(firstMap);
	       
	       /* Set<Entry<String, Object>> ent = firstMap.entrySet();
	        for (Entry<String, Object> entry : ent) {
				System.out.println(entry.getKey()+"-----------"+entry.getValue());
			}*/
	        
	       /* Map<String, Object> secondMap = g.fromJson(Json2, mapType);
	        MapDifference<String, Object> difference = Maps.difference(firstMap, secondMap);
*/
	       // System.out.println("\n\nEntries are missing in Json2\n--------------------------\n");
	       // difference.entriesOnlyOnLeft().forEach((key, value) -> System.out.println("\n--> " + key + ": " + value));

}}
