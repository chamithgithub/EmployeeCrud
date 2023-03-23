package lk.code.employeems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class EmployeeDTO {

    private int empId;
    private String empName;
    private String empAddress;
    private String empContract;
}
