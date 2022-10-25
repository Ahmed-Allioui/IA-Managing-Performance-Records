package de.hbrs.HighPerformance.shell;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

public interface Command {

    void init(int salesmen, int records);

    void readSalesMan(int sid );

    void readAllSalesMen();

    void createSalesMan(Integer employeeId, String firstName, String middleName, String lastName,
                        String fullName, String jobTitle, List<EvaluationRecord> records);

    void updateSalesMan(Integer employeeId, String firstName, String middleName, String lastName,
                        String fullName, String jobTitle, List<EvaluationRecord> records);

    void deleteSalesMan(int sid);

    void readEvaluationRecords(int sid );

    void addPerformanceRecord(Integer goalId, String goalDescription, Integer targetValue, Integer actualValue,
                              Integer year, int sid );

    void updatePerformanceRecord(Integer goalId, String goalDescription, Integer targetValue, Integer actualValue,
                                 Integer year, int sid );

    void deletePerformanceRecord(int rid , int sid );

    void querySalesMan(String attribute , String key );
}
