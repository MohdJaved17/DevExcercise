# DevExcercise
Implemented REST API using Java and springboot to achieve the desired funtionality.

Used Maven as project management and build tool, project structure is created using SpringInitializer

Postman is required to test the functinality.

To run the application:
	-Download from repository
	-import it as a existing maven project
	-run the application as java application or run build package maven goals and run the jar file using java -jar
	command


URLs:

List all contacts:  http://localhost:8080/contacts (GET Request)


Add New Contact:  https://localhost:8080/contact  with JSON in body (POST Request)
Ex:-
			
{
	"firstName":"Aman",
	
	"lastName":"Bansal",
		
	"contactNo":"9876543211",
		
	"email":"aman@ggl.com",

	status":"Active"
	

}

Edit Contact:  https://localhost:8080/contact/9876543211  with JSON in body (PUT Request)
Ex:-
			
{
	"firstName":"Aman",
	
	"lastName":"Bansal",
				
	"email":"aman@ggl.com",

	status":"InActive"
	

}
Delete Contact:  https://localhost:8080/contact/9876543211  (DELETE Request)
