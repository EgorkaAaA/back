package ru.lebedev.sber.back.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Response {

	private final UUID id = UUID.randomUUID();

	private final LocalDateTime timeStampResponse = LocalDateTime.now();

	private final UUID requestId;

	private final LocalDateTime timeStampRequest;

	private Airport airport;

	public Response(final Request request, final Airport airport) {
		this.requestId = request.getId();
		this.timeStampRequest = request.getTimeStamp();
		this.airport = airport;
	}

}
