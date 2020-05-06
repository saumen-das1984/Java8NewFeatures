package jsonparsingwithstream.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CustomerJsonRead {
	public static void main(String[] args) {
		CustomerJsonRead customerJsonRead = new CustomerJsonRead();
		Map<String, Customer> customers = customerJsonRead.readCustomerData();

		customers.entrySet().stream().forEach(CustomerJsonRead.printit);
	}

	/**
	 * print a Map.Entry
	 */
	private static Consumer<Map.Entry<String, Customer>> printit = customer -> {
		final Customer cust = customer.getValue();
		System.out.println("Customer Details are ");
		System.out.println("========================================");
		System.out.println("Customer Key is: " + customer.getKey());
		System.out.println("Customer FirstName is: " + cust.getFirstName());
		System.out.println("Customer LastName is: " + cust.getLastName());
		System.out.println("Customer Age is: " + cust.getAge());
		System.out.println("Customer Address is: ");
		final Address address = cust.getAddress();
		System.out.println("Address StreetAddress is: "
				+ address.getStreetAddress());
		System.out.println("Address City is: " + address.getCity());
		System.out.println("Address State is: " + address.getState());
		System.out.println("Address PostalCode is: " + address.getPostalCode());
		System.out.println("Customer Phonumbers are: ");
		final List<PhoneNumber> phonumbers = cust.getPhoneNumber();
		phonumbers.stream().forEach(phone -> {
			System.out.println("Phonumber type is: " + phone.getType());
			System.out.println("Phonumber number is: " + phone.getNumber());
		});
		System.out.println();
	};

	@SuppressWarnings("unchecked")
	public Map<String, Customer> readCustomerData() {
		Map<String, Customer> customers = null;

		File customer = getCustomerFileReader.apply("customer.json");
		JSONParser parser = new JSONParser();
		try (Reader is = new FileReader(customer)) {
			JSONArray jsonArray = (JSONArray) parser.parse(is);

			customers = (Map<String, Customer>) jsonArray.stream().collect(
					Collectors.toMap(key_customer, value_requestCustomer));

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return customers;
	}

	/**
	 * Retrieve a file with specified name
	 */
	public Function<String, File> getCustomerFileReader = filename -> {
		ClassLoader cl = getClass().getClassLoader();
		
		File customer = new File(cl.getResource(filename).getFile());
		return customer;
	};

	/**
	 * Read the JSON entry and return customer Id
	 */
	private Function<JSONObject, String> key_customer = c -> (String) ((JSONObject) c)
			.get("Customer_id");

	/**
	 * Read the JSON entry and return the request Customer
	 */
	@SuppressWarnings("unchecked")
	private Function<JSONObject, Customer> value_requestCustomer = json -> {
		Customer cust = new Customer();
		cust.setFirstName((String) json.get("firstName"));
		cust.setLastName((String) json.get("lastName"));
		cust.setAge((Long) json.get("age"));

		final JSONObject address = (JSONObject) json.get("address");
		Address addressObj = new Address((String) address.get("streetAddress"),
				(String) address.get("city"), (String) address.get("state"),
				(String) address.get("postalCode"));

		cust.setAddress(addressObj);

		ArrayList<PhoneNumber> PhoneNumberList = new ArrayList<PhoneNumber>();
		JSONArray phoneNumberJsonArray = (JSONArray) json.get("phoneNumber");
		Iterator<JSONObject> itr = phoneNumberJsonArray.iterator();
		while (itr.hasNext()) {
			final JSONObject phNum = itr.next();
			PhoneNumberList.add(new PhoneNumber((String) phNum.get("type"),
					(String) phNum.get("number")));
		}
		cust.setPhoneNumber(PhoneNumberList);

		return cust;
	};
}
