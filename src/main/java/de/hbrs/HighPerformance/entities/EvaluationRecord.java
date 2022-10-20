package de.hbrs.HighPerformance.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EvaluationRecord {
    @Id
    private Integer goalId;
    private String goalDescription;
    private Integer targetValue;
    private Integer actualValue;
    private Integer year;
}
