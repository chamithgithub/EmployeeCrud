package lk.code.employeems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empAddress;
    private String empContract;
}
