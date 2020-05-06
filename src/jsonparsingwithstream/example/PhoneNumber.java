package jsonparsingwithstream.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneNumber {
	private String type;
    private String number;
}
