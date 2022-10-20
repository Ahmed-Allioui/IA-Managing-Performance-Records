package de.hbrs.HighPerformance.repository;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesManRepository extends MongoRepository<SalesMan, Long> {

    @Update("{ '$push' : { 'records' : ?1 } }")
    long findAndPushRecordsByEmployeeId(int sid, EvaluationRecord record);

    @Update("{ '$pull' : { 'records' : { '_id' : ?1 } } }")
    long findAndPullRecordsByEmployeeId(int sid, int rid);

    @Query("{ ?0 : ?1 }")
    List<SalesMan> querySalesMan(String attribute , String key );
}
