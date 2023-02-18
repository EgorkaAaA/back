package ru.lebedev.sber.back;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.lebedev.sber.back.controller.AirportController;
import ru.lebedev.sber.back.model.Request;
import ru.lebedev.sber.back.model.Response;

@SpringBootTest
@RunWith(SpringRunner.class)
class BackApplicationTests {


	@Autowired
	private AirportController airportController;

	@Test
	void contextLoads() {
	}

	@Test
	void getAirport() {
		final Request request = new Request(UUID.randomUUID(), 200L, "thread", LocalDateTime.now());
		final Response response = airportController.get(request);

		assertThat(request.getId())
				.isEqualTo(response.getRequestId());

		assertThat(request.getTimeStamp())
				.isEqualTo(response.getTimeStampRequest());

		assertThat(request.getAirportId())
				.isEqualTo(response.getAirport().getId());

	}

}
