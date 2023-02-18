package ru.lebedev.sber.back.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Request {

	private UUID id;

	private Long airportId;

	private String threadName;

	private LocalDateTime timeStamp;
}
