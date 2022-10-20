package de.hbrs.HighPerformance.service;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;
import de.hbrs.HighPerformance.repository.SalesManRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ManagePersonalImpl implements ManagePersonal {

    private final SalesManRepository repository;

    @Override
    public SalesMan readSalesMan(int sid) {
        return repository.findById((long) sid).orElse(null);
    }

    @Override
    public List<SalesMan> readAllSalesMen() {
        return repository.findAll();
    }

    @Override
    public SalesMan createSalesMan(SalesMan record) {
        return repository.save(record);
    }

    @Override
    public List<SalesMan> createAllSalesMen(List<SalesMan> records) {
        return repository.saveAll(records);
    }

    @Override
    public SalesMan updateSalesMan(SalesMan record) {
        if (record == null || record.getEmployeeId() == null) return null;
        return repository.save(record);
    }

    @Override
    public void deleteSalesMan(int sid) {
        repository.deleteById((long) sid);
    }

    @Override
    public void deleteAllSalesMen() {
        repository.deleteAll();
    }

    @Override
    public long addPerformanceRecord(EvaluationRecord record, int sid) {
        return repository.findAndPushRecordsByEmployeeId(sid, record);
    }

    @Override
    public long updatePerformanceRecord(EvaluationRecord record, int sid) {
        if (record == null || record.getGoalId() == null) return 0;
        return repository.findAndPushRecordsByEmployeeId(sid, record);
    }

    @Override
    public void deletePerformanceRecord(int rid, int sid) {
        repository.findAndPullRecordsByEmployeeId(sid, rid);
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        return repository.querySalesMan(attribute, key);
    }

    @Override
    public List<EvaluationRecord> readEvaluationRecords(int sid) {
        SalesMan salesman = repository.findById((long) sid).orElse(null);
        return salesman == null ? null : salesman.getRecords();
    }
}
