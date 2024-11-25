package Handlejson;

import java.io.File;
import java.io.IOException;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class readjsondata {
	public static jsondatastructure readJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), jsondatastructure.class);
    }
}
