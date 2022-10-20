package de.hbrs.HighPerformance.service;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagePersonal {

    public SalesMan readSalesMan( int sid );

    public List<SalesMan> readAllSalesMen();

    public SalesMan createSalesMan(SalesMan record );

    List<SalesMan> createAllSalesMen(List<SalesMan> records);

    public SalesMan updateSalesMan(SalesMan record );

    void deleteSalesMan(int sid);

    void deleteAllSalesMen();

    public List<EvaluationRecord> readEvaluationRecords(int sid );

    public long addPerformanceRecord(EvaluationRecord record , int sid );

    public long updatePerformanceRecord(EvaluationRecord record , int sid );

    public void deletePerformanceRecord(int rid , int sid );

    public List<SalesMan> querySalesMan(String attribute , String key );
}
