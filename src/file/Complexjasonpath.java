package file;

import io.restassured.path.json.JsonPath;

public class Complexjasonpath {
	public static void main(String[] args) {
 JsonPath js=new JsonPath(Payload.coursesprice());
int count=	js.getInt("courses.size()");
System.out.println(count);
///print parice of courece from responce 
   int amount= js.getInt("dashboard.purchaseAmount");
   System.out.println(amount);
   // print title of courecs
 String title=  js.get("courses[0].title");
 System.out.println(title);
 String title2=  js.get("courses[1].title");
 System.out.println(title2);
 
 //print all title of courecs and pricess
 
 for(int i=0;i<count;i++)
 {
	String titleall= js.get("courses["+i+"].title");
	System.out.println(titleall);
	 
 //	int price =js.get("courses["+i+"].price");  use toStringMethod
	String price =js.get("courses["+i+"].price").toString();
 	System.out.println(price);
 }
}
}