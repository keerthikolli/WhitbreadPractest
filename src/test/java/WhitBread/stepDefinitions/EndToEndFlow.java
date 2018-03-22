package WhitBread.stepDefinitions;


import WhitBread.objectRepository.Resources;
import Whitbread.Compare;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import WhitBread.genericFunctions.Reuse;
import org.junit.Assert;

import java.io.FileReader;

import static WhitBread.genericFunctions.Reuse.baseuri;
import static io.restassured.RestAssured.given;

public class EndToEndFlow {
        Response res;
        String response,customerid,Sess_Id;
        boolean delete = true;
        boolean success = true;

        /* Post Request to create customer is placed in given and customer Id from response is extracted to
        replace in get request.
         */
    @Given("^I have created customer through Post method$")
    public void i_have_created_customer_through_Post_method() throws Throwable {
        JSONParser parser = new JSONParser();
        Object object = parser
                .parse(new FileReader("C:\\wbTest\\src\\test\\java\\WhitBread\\json\\create.json"));
        baseuri();
        res = given().header("Content-Type","application/json")
                .body(object).when().post(Resources.CreateCustomer)
                .then().assertThat().statusCode(200).contentType(ContentType.JSON).and()
                .extract().response();
        response = res.asString();

        JsonPath js = new JsonPath(response);
        success = js.get("body.success");
        if(success == true){}
        else{
            Assert.fail("Success value is false");
        }


        customerid = js.get("body.customerId");
        System.out.println(customerid);

        /*Tried to do schema validation to compare entire response with Expected result,
        i know i messing something while replacing value. I may need some time to dig into solution.*/


       /* Sess_Id = js.get("body.sessionId");
        System.out.println(Sess_Id);

       Compare com = new Compare();
        JSONObject ranTest = com.testread();
        ranTest.put("customerId",customerid);

        ranTest.put("sessionId",Sess_Id);

        String ExpectedResult = ranTest.toString();

        System.out.println(ranTest);
        System.out.println(js);

        Assert.assertEquals(ExpectedResult,response);*/

    }

/* Get request to above created customer and validation done for response */

    @When("^i retrieve the above created customer for confirmation$")
    public void i_retrieve_the_above_created_customer_for_confirmation() throws Throwable {
        baseuri();
        res = given().pathParam("email", customerid)
                .when().get(Resources.GetCustomer)
                .then().assertThat().statusCode(200).contentType(ContentType.JSON).and()
                .extract().response();
        response = res.asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String CusID = js.get("customerId");
        if(CusID.equals("kollitest.com")){}
        else{
            Assert.fail("CustomerId is not same ");
        }

    }
/*  Delete request for Above created customer and validated the response for confirmation of deletion */

    @Then("^I should be able to delete it\\.$")
    public void i_should_be_able_to_delete_it() throws Throwable {
        baseuri();
        res = given().pathParam("DeleteEmail", customerid)
                .when().delete(Resources.DeleteCustomer)
                .then().assertThat().statusCode(200).contentType(ContentType.JSON).and()
                .extract().response();
        response = res.asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);

        delete = js.get("deleted");
        if(delete == true){}
        else{
            Assert.fail("Deleted value is false");
        }
    }


}
