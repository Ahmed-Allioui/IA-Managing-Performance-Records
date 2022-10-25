package de.hbrs.HighPerformance.service;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
interface ManagePersonal {

    SalesMan readSalesMan( int sid );

    List<SalesMan> readAllSalesMen();

    SalesMan createSalesMan(SalesMan record );

    List<SalesMan> createAllSalesMen(List<SalesMan> records);

    SalesMan updateSalesMan(SalesMan record );

    void deleteSalesMan(int sid);

    void deleteAllSalesMen();

    List<EvaluationRecord> readEvaluationRecords(int sid );

    long addPerformanceRecord(EvaluationRecord record , int sid );

    long updatePerformanceRecord(EvaluationRecord record , int sid );

    void deletePerformanceRecord(int rid , int sid );

    List<SalesMan> querySalesMan(String attribute , String key );
}
