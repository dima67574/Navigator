package com.qaprosoft.navigator.algorithm;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.navigator.models.Distance;

public class JacksonParser {
	private final static Logger logger = Logger.getLogger(JacksonParser.class);
	private final static String baseFile = "navigator.json";

	public static void toJSON(Distance distance) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(baseFile), distance);
		logger.info("json created");
	}

	
}


