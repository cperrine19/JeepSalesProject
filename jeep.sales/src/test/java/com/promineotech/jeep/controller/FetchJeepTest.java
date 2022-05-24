package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.HttpMethod;

import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class FetchJeepTest extends FetchJeepTestSupport {


	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrumAreSupplied() {
		// given: a valid model, trim and URI
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);

		System.out.println(uri);

		// When: a connection is made to the URI
		ResponseEntity<List<Jeep>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<>() {});

		// Then: a success (OK 200) is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//And: the actual list returned is the same as the expected list
		List<Jeep> expected = buildExpected();
		System.out.println(expected);
		assertThat(response.getBody()).isEqualTo(expected);
		
	}

	protected List<Jeep> buildExpected() {
		return null;
	}

}
