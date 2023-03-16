package stepDefination;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	
	public void beforeDeletePlace() throws Throwable {
		stepDefination sd=new stepDefination();
		
		if(stepDefination.place_id==null) {
			
			sd.addplace_api_payload_with_something_something_something("Giri", "Odia-IN", "230, hsr layout, cohen 09");
			sd.user_calls_something_with_something_http_request("AddPlaceApi", "POST");
			sd.api_call_got_success_with_something_status_code(200);
			sd.verify_that_something_created_maps_to_something_using_something("place_id", "Giri", "GetPlaceApi");
			
			
			
		}
		
		 
		
		
		
	}

}
