package de.hbrs.HighPerformance.service;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;
import de.hbrs.HighPerformance.factory.EvaluationRecords;
import de.hbrs.HighPerformance.factory.Salesmen;
import de.hbrs.HighPerformance.repository.SalesManRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ManagePersonalImplTest {
    @Autowired
    private ManagePersonalImpl managePersonal;
    List<SalesMan> salesmen = Salesmen.generateSalesMen(10, 5);
    void init(){
        managePersonal.createAllSalesMen(salesmen);
    }

    void drop(){
        managePersonal.deleteAllSalesMen();
    }

    @BeforeEach
    void setUp() {
        init();
    }

    @AfterEach
    void tearDown() {
        drop();
    }

    @Test
    void readSalesMan() {
        SalesMan localSaleman = salesmen.get(0);
        SalesMan dbSalesman = managePersonal.readSalesMan(localSaleman.getEmployeeId());
        assertNotNull(dbSalesman);
        assertEquals(dbSalesman, localSaleman);
    }



    @Test
    void readAllSalesMen() {
        List<SalesMan> all = managePersonal.readAllSalesMen();
        for (SalesMan s: salesmen){
            assertTrue(all.contains(s));
        }
    }

    @Test
    void createSalesMan() {
        managePersonal.deleteAllSalesMen();
        SalesMan dbSalesman = managePersonal.createSalesMan(salesmen.get(0));
        SalesMan localSaleman = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        assertEquals(dbSalesman,localSaleman);
    }

    @Test
    void createAllSalesMen() {
        managePersonal.deleteAllSalesMen();
        List<SalesMan> creatAll = managePersonal.createAllSalesMen(salesmen);
        List<SalesMan> readAll = managePersonal.readAllSalesMen();
        for (SalesMan s: readAll){
            assertTrue(creatAll.contains(s));
        }

    }

    @Test
    void updateSalesMan() {
        SalesMan localSaleman = salesmen.get(0);
        localSaleman.setLastName("Hamid");
        SalesMan s1 = managePersonal.updateSalesMan(localSaleman);
        assertEquals(s1.getLastName(), localSaleman.getLastName());
    }

    @Test
    void deleteSalesMan() {
        SalesMan localSaleman = salesmen.get(0);
        managePersonal.deleteSalesMan(localSaleman.getEmployeeId());
        assertNull(managePersonal.readSalesMan(localSaleman.getEmployeeId()));
    }

    @Test
    void deleteAllSalesMen() {
        managePersonal.createAllSalesMen(salesmen);
        managePersonal.deleteAllSalesMen();
        assertEquals(Collections.EMPTY_LIST,managePersonal.readAllSalesMen());

    }

    @Test
    void addPerformanceRecord() {
        EvaluationRecord record = EvaluationRecord.builder().goalId(0).build();
        SalesMan readSalesMan = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        managePersonal.addPerformanceRecord(record, readSalesMan.getEmployeeId());
        readSalesMan = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        assertTrue(readSalesMan.getRecords().contains(record));
    }

    @Test
    void updatePerformanceRecord() {
        SalesMan readSalesMan = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        EvaluationRecord record = readSalesMan.getRecords().get(0);
        record.setActualValue(500);
        managePersonal.updatePerformanceRecord(record, readSalesMan.getEmployeeId());
        readSalesMan = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        assertTrue(readSalesMan.getRecords().contains(record));
    }

    @Test
    void deletePerformanceRecord() {
        SalesMan readSalesMan = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        EvaluationRecord record = readSalesMan.getRecords().get(0);
        managePersonal.deletePerformanceRecord(record.getGoalId(), readSalesMan.getEmployeeId());
        readSalesMan = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        assertFalse(readSalesMan.getRecords().contains(record));
    }

    @Test
    void querySalesMan() {
        SalesMan salesMan = salesmen.get(0);
        String salesManFirstName = salesMan.getFirstName();
        List<SalesMan> querySalesMan = managePersonal.querySalesMan("firstName", salesManFirstName);
        assertNotNull(querySalesMan);
        assertFalse(querySalesMan.isEmpty());
    }

    @Test
    void readEvaluationRecords() {
        SalesMan readSalesMan = managePersonal.readSalesMan(salesmen.get(0).getEmployeeId());
        List<EvaluationRecord> evaluationRecords = managePersonal.readEvaluationRecords(readSalesMan.getEmployeeId());
        List<EvaluationRecord> localRecords = salesmen.get(0).getRecords();
        for (EvaluationRecord e: localRecords){
            assertTrue(evaluationRecords.contains(e));
        }
    }

}