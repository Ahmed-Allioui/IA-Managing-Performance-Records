package de.hbrs.HighPerformance.factory;

import de.hbrs.HighPerformance.entities.EvaluationRecord;
import de.hbrs.HighPerformance.entities.SalesMan;

import java.util.ArrayList;
import java.util.List;

public class Salesmen {

    public static SalesMan create(
            Integer employeeId,
            String firstName,
            String middleName,
            String lastName,
            String fullName,
            String jobTitle,
            List<EvaluationRecord> records) {
        return SalesMan.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .fullName(fullName)
                .jobTitle(jobTitle)
                .records(records)
                .build();
    }

    public static List<SalesMan> generateSalesMen(int salesMen, int records) {
        List<EvaluationRecord> listRecords = EvaluationRecords.generateRecords(records);
        List<SalesMan> listSalesMen = new ArrayList<>();
        for (int i = 0; i < salesMen; i++) {
            listSalesMen.add(SalesMan.builder()
                    .employeeId(i)
                    .firstName("firstName_" + i)
                    .lastName("lastName_" + i)
                    .jobTitle("Salesman")
                    .records(listRecords)
                    .build());
        }
        return listSalesMen;
    }
}
