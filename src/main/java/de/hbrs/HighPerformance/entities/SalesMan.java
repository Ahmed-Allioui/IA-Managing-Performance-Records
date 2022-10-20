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
public class SalesMan {

    @Id
    private Long employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String jobTitle;    // TODO: verify if necessary

}
