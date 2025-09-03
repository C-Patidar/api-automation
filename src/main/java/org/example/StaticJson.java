package org.example;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import org.example.files.ReUsableMethods;
import org.example.files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StaticJson {

	@Test
	public void addBook() throws IOException {
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().
				header("Content-Type","application/json").
				body(GenerateStringFromResource("\\Users\\f2173/Documents\\cp_personal\\rest-assured\\Addbookdetails.json")).
				when().
				post("/Library/Addbook.php").
				then().assertThat().statusCode(200).
				extract().response().asString();
		JsonPath js= ReUsableMethods.rawToJson(resp);
		String id=js.get("ID");
		System.out.println(id);

		//deleteBOok
	}

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}

