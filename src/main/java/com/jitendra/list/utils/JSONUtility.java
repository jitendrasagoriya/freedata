package com.jitendra.list.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jitendra.list.json.city.Cities;
import com.sun.codemodel.JCodeModel;

public class JSONUtility {

	public static String convertObjectToJSON(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";

		// Object to JSON in file
		try {

			jsonInString = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonInString;

	}

	public static Map<String, Object> jsonToMap(String jsonString) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {

			ObjectMapper mapper = new ObjectMapper();
			// convert JSON string to Map
			map = mapper.readValue(jsonString, new TypeReference<Map<String, String>>() {
			});

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;

	}

	public static String jsonToMap(Map<String, Object> map) {
		String json = "";
		try {

			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	
	 public void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className) throws IOException{  
         JCodeModel codeModel = new JCodeModel();  
         URL source = inputJson;  
         GenerationConfig config = new DefaultGenerationConfig() {  
         @Override  
         public boolean isGenerateBuilders() { // set config option by overriding method  
             return true;  
         }  
         public SourceType getSourceType(){  
     return SourceType.JSON;  
   }  
         };  
         SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());  
         mapper.generate(codeModel, className, packageName, source);  
         codeModel.build(outputPojoDirectory);  
    }  
	 
	public static com.jitendra.list.json.state.State getState()  {
		Gson gson = new Gson();
		com.jitendra.list.json.state.State result = null; 
		ObjectMapper mapper = new ObjectMapper();
		
	    try {
	    	//"D:\\andolan\\FreeData\\src\\\\main\\resources\\state.txt"
	    	String fileData = null; /*new String(Files.readAllBytes(Paths
					.get(new URI(jsonString))));*/
	    	
	    	InputStream in = JSONUtility.class
	                 .getResourceAsStream("/state.txt");
	    	fileData = IOUtils.toString(in);
	    	System.out.println( fileData);
	    	// parse json string to object
	    	//result = gson.fromJson(fileData, com.jitendra.list.json.State.class);
	    	result = mapper.readValue(fileData , com.jitendra.list.json.state.State.class);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	   // System.out.println("emp1 = " + result);
	    return result;
	}
	
	public static Cities getCity()  {
		Cities result = null; 
		ObjectMapper mapper = new ObjectMapper();
		
	    try {
	    	//"D:\\andolan\\FreeData\\src\\main\\resources\\cities.json"
	    	String fileData = null;/*new String(Files.readAllBytes(Paths
					.get(new URI(jsonString))));*/
	    	InputStream in = JSONUtility.class
	                 .getResourceAsStream("/cities.json");
	    	fileData = IOUtils.toString(in);
	    //	System.out.println( fileData);
	    	// parse json string to object
	    	//result = gson.fromJson(fileData, com.jitendra.list.json.State.class);
	    	result = mapper.readValue(fileData , Cities.class);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	   // System.out.println("emp1 = " + result);
	    return result;
	}

	 public static void main(String[] args) throws IOException { 
		 InputStream in = JSONUtility.class
                 .getResourceAsStream("/district.csv");
		 
		 System.out.println( IOUtils.toString(in));
		// System.out.println("City "+ getCity("https://drive.google.com/open?id=1PAY4LeX1G9yK1qYZI8A05orXS3vTYaM_"));
         /*String packageName="com.jitendra.list.json.city";  
         File inputJson= new File("D:\\andolan\\FreeData\\src\\main\\resources\\cities.json");  
         File outputPojoDirectory=new File("D:\\andolan\\FreeData\\src\\main\\java\\com\\jitendra\\list\\json\\city");  
         outputPojoDirectory.mkdirs();  
         try {  
              new JSONUtility().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));  
         } catch (IOException e) {  
              // TODO Auto-generated catch block  
              System.out.println("Encountered issue while converting to pojo: "+e.getMessage());  
              e.printStackTrace();  
         } */ 
    } 
}
