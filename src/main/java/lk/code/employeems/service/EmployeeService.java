package lk.code.employeems.service;

import javafx.scene.control.Alert;
import lk.code.employeems.dto.EmployeeDTO;
import lk.code.employeems.entity.Employee;
import lk.code.employeems.repo.EmployeeRepo;
import lk.code.employeems.util.ResponseUtil;
import lk.code.employeems.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmpId())) {
            return VarList.RSP_DUPLICATED;

        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }
}
