package testPage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class restapicheck {

	@Test
	public void getAllProduct() {
		
		String url = "http://localhost:8080/medicare1/";
		RestAssured.baseURI = url;
		RestAssured.given().get("show/all/products").then().log().body().statusCode(200);
	}
	
	@Test
	public void getCategoryData() {
		 RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("http://localhost:8080/medicare1/show/category/2/products");
		response.then().log().status()
	      .statusCode(200);
		ResponseBody body = response.getBody();
		String bodyStringValue = body.asString();
		  AssertJUnit.assertTrue(bodyStringValue.contains("Analgesics"));
	}
}
