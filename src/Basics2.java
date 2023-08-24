import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.reporters.jq.Main;

import file.Payload;
import file.ReusableMethod;
public class Basics2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// change pass payloadclass method in 17 row and remove log.all 19 row
	
		RestAssured.baseURI="http://rahulshettyacademy.com";
	String responcebody=	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body(Payload.addplac()).
		when().post("/maps/api/place/add/json?key= qaclick123").
		then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
	
	    // System.out.println(responcebody);
	     JsonPath js=new JsonPath (responcebody);//jason parsing
	  String placeid  = js.get("place_id");
	  System.out.println(placeid);
	  
	  //update place===========================================================
	  given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
	  body("{\r\n"
	  		+ "\"place_id\":\""+placeid+"\",\r\n"
	  		+ "\"address\":\"70 Summer walk, USA\",\r\n"
	  		+ "\"key\":\"qaclick123\"\r\n"
	  		+ "}\r\n"
	  		+ "").
	  when().put("/maps/api/place/update/json?Key=qaclick123").
	  then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));
	  
	  // GET place==========================================
	String getplaceresponce=  given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).
	  when().get("/maps/api/place/get/json").
	  then().assertThat().log().all().statusCode(200).extract().response().asString();
	  //JsonPath js2=new JsonPath(getplaceresponce); ek static method create keli ReusableMethod class madhe 
	JsonPath js2=ReusableMethod.rawTojason(getplaceresponce);
	 String actualadress= js2.getString("address");
	 
	}

	
	}


