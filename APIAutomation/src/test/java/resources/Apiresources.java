package resources;

public enum Apiresources {
	
	AddPlaceApi("/maps/api/place/add/json"),
	GetPlaceApi("/maps/api/place/get/json"),
	DeletePlaceApi("/maps/api/place/delete/json"),
	UpdatePlaceApi("maps/api/place/update/json");
	
	
	
	private String resource;
	
	
	

	Apiresources(String resource) {
		
		this.resource=resource;
	}
	
	public String getResource() {
		
		return resource;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	static String AddPlace="/maps/api/place/add/json";
//	
//	public static String AddPlace() {
//		return AddPlace;
//	
//	}

}
