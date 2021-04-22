package kpmg;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class RESTDammyAPITest {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }

    @Test
    public void GET_EmployeeName() {
        String request = "/employee/1";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(request);
        JsonPath jsonPathEvaluator = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(), 200);

        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println("GET_EmployeeName response body: " + bodyAsString);
        String employeeName = jsonPathEvaluator.get("data.employee_name");
        System.out.println("GET_EmployeeName employee name: " + employeeName);

        Assert.assertEquals(employeeName, "Tiger Nixon");
    }

    @Test
    public void GET_EmployeeSalary() {
        String request = "/employee/1";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(request);
        JsonPath jsonPathEvaluator = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(), 200);

        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println("GET_EmployeeName response body: " + bodyAsString);
        int employeeSalary = jsonPathEvaluator.get("data.employee_salary");
        System.out.println("GET_EmployeeName employee name: " + employeeSalary);

        Assert.assertEquals(employeeSalary, 320800);
    }

    @Test
    public void POST_NewEmployee() {
        given().urlEncodingEnabled(true)
                .param("name", "Doris Wilder")
                .param("salary", "85600")
                .param("age", "23")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("http://dummy.restapiexample.com/api/v1/create")
                .then().statusCode(200);
    }

    @Test
    public void PUT_EmployeeData() {
        given().urlEncodingEnabled(true)
                .param("name", "Doris Wilder")
                .param("salary", "85600")
                .param("age", "23")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .put("http://dummy.restapiexample.com/api/v1/update/21")
                .then().statusCode(200);
    }

    @Test
    public void DELETE_Employee() {
        String request = "/delete/2";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.delete(request);
        JsonPath jsonPathEvaluator = response.jsonPath();

        Assert.assertEquals(response.getStatusCode(), 200);

        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println("DELETE_Employee response body: " + bodyAsString);
        String message = jsonPathEvaluator.get("message");
        System.out.println("DELETE_Employee employee name: " + message);

        Assert.assertEquals(message, "Successfully! Record has been deleted");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Test Completed!");
    }

}
