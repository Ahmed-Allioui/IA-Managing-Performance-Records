package de.hbrs.HighPerformance.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesMan {

    @Id
    private Integer employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private List<EvaluationRecord> records;
}
