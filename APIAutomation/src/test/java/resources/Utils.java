package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	static ResponseSpecification response;
	public  static RequestSpecification req;

	
	public static RequestSpecification requestspecs() throws IOException {
		
		
		if(req==null) {
			
		PrintStream log= new PrintStream(new FileOutputStream("logs.txt"));		
		req=new RequestSpecBuilder().setBaseUri(Utils.getBaseURI("BaseUri")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
		}
		
	  return req;
				
	}
	
	public static ResponseSpecification responsespecs() {
		
		response=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return response;
	}
	
	public static String getBaseURI(String key) throws IOException {
		
		Properties prop=new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/global.properties");

		prop.load(file);
		return prop.getProperty(key);
		
	}
	
	public String getJsonPath(String response, String key) {
		
		JsonPath js=new JsonPath(response);
		return js.get(key).toString();
	}

}
