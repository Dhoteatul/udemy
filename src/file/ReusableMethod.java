package file;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {
	public static JsonPath rawTojason(String responce) 
	{
		JsonPath js=new JsonPath(responce);
		return js;
	}

}
