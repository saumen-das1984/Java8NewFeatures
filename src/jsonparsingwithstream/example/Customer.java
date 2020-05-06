package jsonparsingwithstream.example;

import java.util.List;

import lombok.Data;

@Data
public class Customer {
	private String customerId;
    private String firstName;
    private String lastName;
    private Long age;
    private Address address;
    private List<PhoneNumber> phoneNumber;
}
