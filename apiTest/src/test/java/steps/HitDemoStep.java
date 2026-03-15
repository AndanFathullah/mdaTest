package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import org.json.simple.JSONObject;

public class HitDemoStep {

    public int ResponseCode;
    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody body;
    public JSONObject requestParams;
    public JsonPath jsonpath;
    public static String baseUrl = "https://jsonplaceholder.typicode.com";

    @Given("I hit the API")
    public void hit_the_api(){
        RestAssured.baseURI = baseUrl;
        httpRequest = given();
        requestParams = new JSONObject();
    }

    @And("I add body {} and {} request to the URL")
    public void pass_post_request(String field, String value){
        httpRequest = RestAssured.given();
        requestParams.put(field, value);
    }

    @And("I add integer body {} and {} request to the URL")
    public void pass_int_post_request(String field, Integer value){
        httpRequest = RestAssured.given();
        requestParams.put(field, value);
    }

    @When("I hit the Post URL using request body")
    public void hit_post_using_request_url(){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.post("posts");
        body = response.getBody();
        jsonpath = response.jsonPath();
        System.out.println(body.asString());
    }

    @When("I pass the Get request to the URL")
    public void hit_get_url(){
        httpRequest.header("Content-Type", "application/json");
        response = httpRequest.get("posts");
    }

    @When("I pass the delete {} request to the URL")
    public void hit_delete_url(Integer id){
        httpRequest.header("Content-Type", "application/json");
        response = httpRequest.delete("posts/"+ id);
    }

    @When("I pass the put {} request to the URL")
    public void hit_put_url(Integer id){
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("posts/" + id);
        body = response.getBody();
        jsonpath = response.jsonPath();
        System.out.println(body.asString());
    }

    @Then("I receive put response {} and {} and {} as expected")
    public void receive_put_response(String title, String body, Integer userId){
        ResponseCode = response.getStatusCode();
        assertEquals(200, ResponseCode);
        String responseTitle = response.jsonPath().get("title");
        String responseBody = response.jsonPath().get("body");
        Integer responseUserId = response.jsonPath().get("userId");
        assertEquals(title, responseTitle);
        assertEquals(body, responseBody);
        assertEquals(userId, responseUserId);
    }

    @Then("I receive delete response as expected")
    public void receive_delete_response(){
        ResponseCode = response.getStatusCode();
        assertEquals(200, ResponseCode);
    }

    @Then("I receive Post response {} and {} and {} as expected")
    public void receive_post_response(String title, String body, Integer userId){
        ResponseCode = response.getStatusCode();
        assertEquals(201, ResponseCode);
        String responseTitle = response.jsonPath().get("title");
        String responseBody = response.jsonPath().get("body");
        Integer responseUserId = response.jsonPath().get("userId");
        assertEquals(title, responseTitle);
        assertEquals(body, responseBody);
        assertEquals(userId, responseUserId);
    }

    @Then("I receive Get response as expected")
    public void receive_get_response(){
        ResponseCode = response.getStatusCode();
        assertEquals(200, ResponseCode);
        jsonpath = response.jsonPath();
        assertNotNull(jsonpath);
        checkIdsIndividually(response);
    }

    public void checkIdsIndividually(Response response) {
        JsonPath jsonPath = response.jsonPath();
        int listSize = jsonPath.getList("$").size();
        for (int i = 0; i < listSize; i++) {
            Integer id = jsonPath.get("[" + i + "].id");

            assertNotNull(id);
        }
        System.out.println("Successfully verified " + listSize + " indices.");
    }
}
