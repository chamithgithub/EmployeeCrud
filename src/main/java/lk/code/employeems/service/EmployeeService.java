package lk.code.employeems.service;

import lk.code.employeems.dto.EmployeeDTO;
import lk.code.employeems.entity.Employee;
import lk.code.employeems.repo.EmployeeRepo;
import lk.code.employeems.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    public String updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepo.existsById(employeeDTO.getEmpId())) {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<EmployeeDTO>getAllEmplokyee() {
        List<Employee> employeeList = employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>() {
        }.getType());
    }

}

