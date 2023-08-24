package file;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Sumofcourse {
	//validate price 
	public static void main(String[]arg) {
	//@Test
	//public void sumprice() {
	
		JsonPath js=new JsonPath(Payload.coursesprice());
		int count=js.getInt("courses.size()");
		int sum=0;
		 for(int i=0;i<count;i++)
		 {
			int copie= js.get("courses["+i+"].copies");
			System.out.println(copie);
			 
		 //	int price =js.get("courses["+i+"].price");  use toStringMethod
			int price =js.get("courses["+i+"].price");
		 	System.out.println(price);
		 	int amount=price*copie;
		 	System.out.println(amount);
		 sum=sum+amount;
	}
		 System.out.println(sum);
}}
