package controller;

import model.Address;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repository.AddressRepository;
import repository.EmployeeRepository;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepo;
    private AddressRepository addressRepo;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepo,
                              AddressRepository addressRepo) {
        this.employeeRepo = employeeRepo;
        this.addressRepo = addressRepo;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employee employee,
                         @ModelAttribute Address address) {
        employee.setAddress(address);
        employeeRepo.save(employee);
        return "success";
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<Employee> employees = employeeRepo.findAll();
        List<Address> addresses = addressRepo.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("addresses", addresses);
        return "show";
    }
}
