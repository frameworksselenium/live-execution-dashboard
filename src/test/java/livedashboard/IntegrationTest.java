package livedashboard;

import live.execution.dashboard.beans.Execution;
import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@SpringBootTest(classes= ServiceUnitTest.class)
@TestMethodOrder(OrderAnnotation.class)
public class IntegrationTest {


	@Test @Order(1)
	void getAllExecutionsIntegrationTest() throws JSONException {
		System.out.println("Started IntegrationTest getAllExecutionsIntegrationTest");

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://18.206.176.58:8089/getExecution", String.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		String noOfExecutions = String.valueOf(response.getBody().length());
		JSONAssert.assertNotEquals("1", noOfExecutions, true);
		System.out.println("Ended IntegrationTest getAllExecutionsIntegrationTest");

	}

	@Test @Order(2)
	void getExecutionByIdIntegrationTest() throws JSONException {
		System.out.println("Started IntegrationTest getExecutionByIdIntegrationTest");

		String expectedValue = "{\n" +
				"    \"id\": 1,\n" +
				"    \"executionID\": \"10001\",\n" +
				"    \"testcaseName\": \"Test Case Name 1001\",\n" +
				"    \"executionStatus\": \"Pass\",\n" +
				"    \"executionDate\": \"05/05/2022\"\n" +
				"}";
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://18.206.176.58:8089/getExecution/1", String.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		JSONAssert.assertEquals(expectedValue, response.getBody(), false);
		System.out.println("Ended IntegrationTest getExecutionByIdIntegrationTest");

	}

	@Test @Order(3)
	void addExecutionIntegrationTest() throws JSONException {
		System.out.println("Started IntegrationTest addExecutionIntegrationTest");

		Execution country = new Execution(4, "1004", "TC004","Pass", "2022-03-24");
		String expectedValue = "{\n" +
				"    \"executionID\": \"1004\",\n" +
				"    \"testcaseName\": \"TC004\",\n" +
				"    \"executionStatus\": \"Pass\",\n" +
				"    \"executionDate\": \"2022-03-24\"\n" +
				"}";

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Execution> request = new HttpEntity<Execution>(country, headers);
		ResponseEntity<String> response = testRestTemplate.postForEntity("http://18.206.176.58:8089/addExecution", request, String.class);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());

//		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		System.out.println(response.getBody());
		JSONAssert.assertEquals(expectedValue, response.getBody(), false);
		System.out.println("Ended IntegrationTest addExecutionIntegrationTest");

	}

}