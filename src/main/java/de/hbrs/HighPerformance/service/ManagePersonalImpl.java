package de.hbrs.HighPerformance.service;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagePersonalImpl implements ManagePersonal {
    @Override
    public void createSalesMan(SalesMan record) {

    }

    @Override
    public void addPerformanceRecord(EvaluationRecord record, int sid) {

    }

    @Override
    public SalesMan readSalesMan(int sid) {
        return null;
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        return null;
    }

    @Override
    public EvaluationRecord readEvaluationRecords(int sid) {
        return null;
    }
}
