package com.restassured.positivetestcases;

import java.io.IOException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class PositiveTestCases {
	 @Test
	    public void CountryCapitalReturn() throws IOException {
		 String name = "india";
		 
	        RestAssured.baseURI = "http://localhost:9001/CountryInfo/countryname";
	 
	        Response response = null;
	 
	        try {
	            response = RestAssured.given()
	                                  .pathParam("name", name)
	                                  .when()
	                                  .get("/{name}");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	        System.out.println("Does Reponse contains 'capital'? :" + response.asString().contains("capital"));
	 
	        assertEquals(200, response.getStatusCode());
	    }
	 
	 
	 @Test
	    public void CountryCodeReturn() throws IOException {
		 String code = "co";
		 
	        RestAssured.baseURI = "http://localhost:9001/CountryInfo/countrycode";
	 
	        Response response = null;
	 
	        try {
	            response = RestAssured.given()
	                                  .pathParam("code", code)
	                                  .when()
	                                  .get("/{code}");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	        System.out.println("Does Reponse contains 'alpha2code'? :" + response.asString().contains("alpha2code"));
	 
	        assertEquals(200, response.getStatusCode());
	        assertEquals("application/json",response.getContentType());
	         }

	  
}
