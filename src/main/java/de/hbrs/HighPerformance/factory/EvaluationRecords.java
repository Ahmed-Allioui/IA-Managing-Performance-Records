package de.hbrs.HighPerformance.factory;

import de.hbrs.HighPerformance.entities.EvaluationRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EvaluationRecords {

    public static EvaluationRecord create(Integer goalId,
                                          String goalDescription,
                                          Integer targetValue,
                                          Integer actualValue,
                                          Integer year) {
        return EvaluationRecord.builder()
                .goalId(goalId)
                .goalDescription(goalDescription)
                .targetValue(targetValue)
                .actualValue(actualValue)
                .year(year)
                .build();
    }

    public static List<EvaluationRecord> generateRecords(int n) {
        List<EvaluationRecord> records = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            records.add(EvaluationRecord.builder()
                    .goalId(i)
                    .actualValue((i+1) * 100)
                    .targetValue((i+1) * 100)
                    .year(LocalDate.now().getYear() - n + i)
                    .build());
        }
        return records;
    }
}
