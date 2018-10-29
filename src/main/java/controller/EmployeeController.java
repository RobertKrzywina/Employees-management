package controller;

import model.Address;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repository.EmployeeRepository;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employee employee,
                         @ModelAttribute Address address) {
        employee.setAddress(address);
        employeeRepo.save(employee);
        return "success";
    }
}
