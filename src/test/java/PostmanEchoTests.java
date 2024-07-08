import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {


        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRequestRawText() {

        String postRequestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(postRequestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));

    }

    @Test
    public void testPostFormRequest() {

        given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void testPutRequest() {
        String putRequestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(putRequestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testPatchRequest() {

        String patchRequestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(patchRequestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void testDeleteRequest() {

        String requestDeleteBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(requestDeleteBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

}





