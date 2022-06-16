package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ImageUploadTest {

	private static final String JEEP_IMAGE = "JeepRubiconRocks.jpeg";
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testThatTheServerCorrectlyReceivesAnImageAndReturnsAnOKResponse() throws IOException {
		Resource image = new ClassPathResource(JEEP_IMAGE);

		if (!image.exists()) {
			fail("Could not find resource %s", JEEP_IMAGE);

		}
		try (InputStream inputStream = image.getInputStream()) {
			MockMultipartFile file = new MockMultipartFile("image", JEEP_IMAGE, MediaType.TEXT_PLAIN_VALUE,
					inputStream);
		}
	}

}
