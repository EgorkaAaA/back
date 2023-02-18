package ru.lebedev.sber.back.service.impl;

import org.springframework.stereotype.Service;
import ru.lebedev.sber.back.model.Airport;
import ru.lebedev.sber.back.model.Request;
import ru.lebedev.sber.back.model.Response;
import ru.lebedev.sber.back.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService {

	@Override
	public Response create(final Request request, final Airport airport) {
		return new Response(request, airport);
	}

}
