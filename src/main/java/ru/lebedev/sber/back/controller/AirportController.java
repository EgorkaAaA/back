package ru.lebedev.sber.back.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lebedev.sber.back.model.Request;
import ru.lebedev.sber.back.model.Response;
import ru.lebedev.sber.back.service.AirportService;
import ru.lebedev.sber.back.service.ResponseService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airport")
@Log4j2
public class AirportController {

	private final ResponseService responseService;

	private final AirportService airportService;

	@PostMapping
	public Response get(@RequestBody final Request request) {
		log.info("request: {}", request.toString());
		Response response = responseService.create(request, airportService.get(request.getAirportId()));
		log.info("response: {}", response.toString());
		return response;
	}
}
