package test.app;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class ExtractbyteXML {
	public static String extractBytes(String data)
            throws UnsupportedEncodingException, IOException, DataFormatException {
//        System.out.println("inside 1:" + data.toString());
        if (data.contains("x")) {
            data = data.split("x")[1];
        }
        Inflater ifl = new Inflater();
        byte[] input = hexStringToByteArrayM(data);
//        System.out.println("Data 2:"+input.toString());
//        System.out.println("Length: " + input.length);
        ifl.setInput(input);
         
        ByteArrayOutputStream baos = new ByteArrayOutputStream(input.length);
        byte[] buff = new byte[1024];
        while (!ifl.finished()) {
            int count = ifl.inflate(buff);
            baos.write(buff, 0, count);
        }
        baos.close();
        byte[] output = baos.toByteArray();
//        System.out.println("Original: " + input.length);
//        System.out.println("Extracted: " + output.length);
//        System.out.println("Data:");

//        System.out.println(new String(output));

        return new String(output);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[(i / 2)] =
                    ((byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16)));
        }
        return data;
    }

    public static byte[] hexStringToByteArrayM(String s) {
        byte[] data = new byte[s.length() / 2];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) ((Character.digit(s.charAt(i * 2), 16) << 4)
                    + Character.digit(s.charAt(i * 2 + 1), 16));
        }
        return data;
    }
}
