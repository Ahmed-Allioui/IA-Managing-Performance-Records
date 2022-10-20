package de.hbrs.HighPerformance.repository;

import de.hbrs.HighPerformance.entities.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesManRepository extends MongoRepository<SalesMan, Long> {
}
