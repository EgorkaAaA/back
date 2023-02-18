package ru.lebedev.sber.back.service;

import jakarta.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;
import ru.lebedev.sber.back.model.Airport;

@Service
public class AirportCacheService {

	public static final String FILE_NAME = "airports.dat";

	/**
	 * Загружаю в map на этапе поднятия приложения, чтобы каждый раз не лезть в файл
	 */
	private Map<Long, Airport> airportMap;

	@SneakyThrows
	@PostConstruct
	private void fillMap() {
		final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		if (resourceAsStream == null) {
			throw new FileNotFoundException("file with name: %s not found".formatted(FILE_NAME));
		}
		final CSVParser csvParser = new CSVParser(new InputStreamReader(resourceAsStream), CSVFormat.DEFAULT.withHeader());
		airportMap = csvParser.getRecords()
				.stream()
				.map(
						csvRecord -> Airport.builder()
								.id(Long.valueOf(csvRecord.get(CsvHeaders.ID.getName())))
								.name(csvRecord.get(CsvHeaders.NAME.getName()))
								.build()
				)
				.collect(Collectors.toMap(Airport::getId, Function.identity()));
		csvParser.close();
	}

	public Airport get(final Long id) {
		return airportMap.get(id);
	}

	@AllArgsConstructor
	@Getter
	private enum CsvHeaders {
		ID("ID"),
		NAME("NAME");

		private final String name;
	}

}
