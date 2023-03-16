package resources;

import java.util.ArrayList;

import pojo.addPlace;
import pojo.location;

public class testData {
	
	public static addPlace datapayload(String name, String language, String address) {
	
	addPlace add= new addPlace();
	add.setAccuracy(50);
	add.setAddress(address);
	add.setLanguage(language);
	location locate= new location();
	locate.setLat(-38.383494);
	locate.setLng(33.427362);
	add.setLocation(locate);
	add.setName(name);
	add.setPhone_number("(+91) 983 893 3937");
	ArrayList<String> typelist= new ArrayList<String>();
	typelist.add("shoe park");
	typelist.add("shop");
	add.setTypes(typelist);
	add.setWebsite("http://google.com");
	
	return add;
	
	}
	
	public static String deletePlacePayload(String place_id) {
		
		return "{\n"
				+ "    \"place_id\": \""+place_id+"\"\n"
				+ "}";
		
	}

}
