package de.hbrs.HighPerformance;

import de.hbrs.HighPerformance.entities.SalesMan;
import de.hbrs.HighPerformance.repository.SalesManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HighPerformanceApplication implements CommandLineRunner {

	@Autowired
	private SalesManRepository repository;
	// TODO: injection must be deleted (just for testing)
	// TODO: "implements CommandLineRunner" must be removed
	// TODO: run method must be removed

	public static void main(String[] args) {
		SpringApplication.run(HighPerformanceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		SalesMan salesMan = SalesMan.builder()
				.employeeId(1L)
				.firstName("Mehdi")
				.build();
		repository.save(salesMan);
	}


	}
