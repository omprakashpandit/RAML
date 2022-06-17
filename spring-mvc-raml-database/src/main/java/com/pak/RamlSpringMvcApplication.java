package com.pak;

import com.pak.web.StudentController;
import com.pak.web.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@SpringBootApplication
public class RamlSpringMvcApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    public static void main(String[] args) {
        SpringApplication.run(RamlSpringMvcApplication.class, args);
    }
    ///////############################## TESTING CODE ############################################//

    @Autowired
    StudentController studentController;

    @Override
    public void run(String... args) throws Exception {

        //get list of drinks (GET list)
 //       ResponseEntity<List<Student>> getDrinksResponse = studentController.getStudents();
        //assertTrue(getDrinksResponse.getStatusCode().equals(HttpStatus.OK), "Failed to perform GET request.");
   //     getDrinksResponse.getBody().forEach(d -> LOG.info(d.getName() + ","));

		//create drink (POST)
/*		Student createDrinkRequest = new Student();
		createDrinkRequest.setName("Wine");
		createDrinkRequest.setCode("ALCOHOL");
		ResponseEntity createDrinkResponse = studentController.createStudent(createDrinkRequest);
		//assertTrue("Failed to perform POST request.", createDrinkResponse.getStatusCode().equals(HttpStatus.ACCEPTED));
		LOG.info("Successfully created drink with name [{}]", createDrinkRequest.getName());
		LOG.info("Successfully created drink type [{}]", createDrinkRequest.getCode());
*/

  /*
        //update drink (PUT)
        Student updateDrinkByIdRequest = new Student();
        updateDrinkByIdRequest.setName("Beer");
        ResponseEntity updateResponse = studentController.updateStudent("wine", updateDrinkByIdRequest);
       // assertTrue("Failed to perform PUT request.", updateResponse.getStatusCode().equals(HttpStatus.OK));
        LOG.info("Successfully updated drink. Verifying ...");


        //Verify update
        ResponseEntity<Student> updatedDrink = studentController.getStudentById(updateDrinkByIdRequest.getName());
        boolean responseOK = updatedDrink.getStatusCode().equals(HttpStatus.OK) && updatedDrink.getBody()!=null;
      //  assertTrue("Failed to verify PUT request. Failed to update drink", responseOK);
        LOG.info("Successfully verified drink update!");



        //delete drink (DELETE)
        ResponseEntity deleteResponse = studentController.deleteStudentById(updateDrinkByIdRequest.getName());
       // assertTrue("Failed perform DELETE request.", deleteResponse.getStatusCode().equals(HttpStatus.ACCEPTED));
        LOG.info("Successfully deleted drink with name: [{}]", updateDrinkByIdRequest.getName());

         */




    }



	
	
	
	
	
	
/*	@RequestMapping("/hello")
	public String hello()
	{
		return "Hello World..";
	}

 */
/*
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/students")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8080/api/students", HttpMethod.GET, entity, String.class).getBody();
	}

 */


}
//################################################  RUN  ##################################################
//mvn clean package
// http://localhost:8081/api/students --GET
/*
[
    {
        "id": 1,
        "code": "001",
        "name": "Khanh"
    },
    {
        "id": 2,
        "code": "002",
        "name": "Quan"
    }
]
----------------------------------JAVA-----------------------------------------
URL url = new URL("http://localhost:8081/api/students");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("GET");

int status = con.getResponseCode();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while((inputLine = in.readLine()) != null) {
	content.append(inputLine);
}
in.close();
con.disconnect();
System.out.println("Response status: " + status);
System.out.println(content.toString());
-----------------------------------SPRING------------------------------------
RestTemplate rest = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
String body = "";

HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
ResponseEntity<String> responseEntity = rest.exchange("http://localhost:8081/api/students", HttpMethod.GET, requestEntity, String.class);
HttpStatus httpStatus = responseEntity.getStatusCode();
int status = httpStatus.value();
String response = responseEntity.getBody();
System.out.println("Response status: " + status);
System.out.println(response);



//
http://localhost:8081/api/students/{id}
{
    "id": 1,
    "code": "001",
    "name": "Khanh"
}
-----------------------------JAVA--------------------------------
URL url = new URL("http://localhost:8081/api/students/{id}");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("GET");

int status = con.getResponseCode();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while((inputLine = in.readLine()) != null) {
	content.append(inputLine);
}
in.close();
con.disconnect();
System.out.println("Response status: " + status);
System.out.println(content.toString());

-----------------------------SPRING------------------------------
RestTemplate rest = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
String body = "";

HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
ResponseEntity<String> responseEntity = rest.exchange("http://localhost:8081/api/students/{id}", HttpMethod.GET, requestEntity, String.class);
HttpStatus httpStatus = responseEntity.getStatusCode();
int status = httpStatus.value();
String response = responseEntity.getBody();
System.out.println("Response status: " + status);
System.out.println(response);

http://localhost:8081/api/students --POST
{
    "code": "005",
    "name": "Khanh"
}
-----------------------------JAVA--------------------------------
URL url = new URL("http://localhost:8081/api/students");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("POST");
con.setDoOutput(true);
DataOutputStream out = new DataOutputStream(con.getOutputStream());
out.writeBytes("{\n");
out.writeBytes("    \"code\": \"005\",\n");
out.writeBytes("    \"name\": \"Khanh\"\n");
out.writeBytes("}");
out.flush();
out.close();

int status = con.getResponseCode();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while((inputLine = in.readLine()) != null) {
	content.append(inputLine);
}
in.close();
con.disconnect();
System.out.println("Response status: " + status);
System.out.println(content.toString());

-----------------------------SPRING------------------------------
RestTemplate rest = new RestTemplate();
HttpHeaders headers = new HttpHeaders();

StringBuilder sb = new StringBuilder();
sb.append("{\n");
sb.append("    \"code\": \"005\",\n");
sb.append("    \"name\": \"Khanh\"\n");
sb.append("}");
String body = sb.toString();

HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
ResponseEntity<String> responseEntity = rest.exchange("http://localhost:8081/api/students", HttpMethod.POST, requestEntity, String.class);
HttpStatus httpStatus = responseEntity.getStatusCode();
int status = httpStatus.value();
String response = responseEntity.getBody();
System.out.println("Response status: " + status);
System.out.println(response);

http://localhost:8081/api/students/{id} --PUT
{
    "id": 1,
    "code": "001",
    "name": "Khanh"
}
-----------------------------JAVA--------------------------------

URL url = new URL("http://localhost:8081/api/students/{id}");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("PUT");

/* Payload support
con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes("{\n");
        out.writeBytes("    \"id\": 1,\n");
        out.writeBytes("    \"code\": \"001\",\n");
        out.writeBytes("    \"name\": \"Khanh\"\n");
        out.writeBytes("}");
        out.flush();
        out.close();

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
        content.append(inputLine);
        }
        in.close();
        con.disconnect();
        System.out.println("Response status: " + status);
        System.out.println(content.toString());

-----------------------------SPRING------------------------------

RestTemplate rest = new RestTemplate();
HttpHeaders headers = new HttpHeaders();

StringBuilder sb = new StringBuilder();
sb.append("{\n");
sb.append("    \"id\": 1,\n");
sb.append("    \"code\": \"001\",\n");
sb.append("    \"name\": \"Khanh\"\n");
sb.append("}");
String body = sb.toString();

HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
ResponseEntity<String> responseEntity = rest.exchange("http://localhost:8081/api/students/{id}", HttpMethod.PUT, requestEntity, String.class);
HttpStatus httpStatus = responseEntity.getStatusCode();
int status = httpStatus.value();
String response = responseEntity.getBody();
System.out.println("Response status: " + status);
System.out.println(response);

http://localhost:8081/api/students/{id} --DELETE
{
  "message": "Student deleted!"
}
-----------------------------JAVA--------------------------------
URL url = new URL("http://localhost:8081/api/students/{id}");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("DELETE");

int status = con.getResponseCode();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer content = new StringBuffer();
while((inputLine = in.readLine()) != null) {
	content.append(inputLine);
}
in.close();
con.disconnect();
System.out.println("Response status: " + status);
System.out.println(content.toString());
-----------------------------SPRING------------------------------
RestTemplate rest = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
String body = "";

HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
ResponseEntity<String> responseEntity = rest.exchange("http://localhost:8081/api/students/{id}", HttpMethod.DELETE, requestEntity, String.class);
HttpStatus httpStatus = responseEntity.getStatusCode();
int status = httpStatus.value();
String response = responseEntity.getBody();
System.out.println("Response status: " + status);
System.out.println(response);


 */