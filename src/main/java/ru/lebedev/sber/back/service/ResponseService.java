package ru.lebedev.sber.back.service;

import ru.lebedev.sber.back.model.Airport;
import ru.lebedev.sber.back.model.Request;
import ru.lebedev.sber.back.model.Response;

public interface ResponseService {

	Response create(Request request, Airport airport);

}
