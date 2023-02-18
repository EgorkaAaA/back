package ru.lebedev.sber.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lebedev.sber.back.model.Airport;
import ru.lebedev.sber.back.service.AirportCacheService;
import ru.lebedev.sber.back.service.AirportService;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

	private final AirportCacheService airportCacheService;

	@Override

	public Airport get(final Long id) {
		return airportCacheService.get(id);
	}

}
