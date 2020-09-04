package json.parsing.stream.api.example;

import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JSONParseringStreamingAPI {

	public static void main(String[] args) {
		String jsonString = "{\"name\":\"Adithya\",\"employeeId\":\"115\",\"age\":\"30\"}";
		JsonParser parser = Json.createParser(new StringReader(jsonString));
		while (parser.hasNext()) {
			Event event = parser.next();
			if (event == Event.KEY_NAME) {
				switch (parser.getString()) {
				case "name":
					parser.next();
					System.out.println("Name: " + parser.getString());
					break;
				case "employeeId":
					parser.next();
					System.out.println("EmployeeId: " + parser.getString());
					break;
				case "age":
					parser.next();
					System.out.println("Age: " + parser.getString());
					break;
				}
			}
		}
	}

}
