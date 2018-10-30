package controller;

import model.Address;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repository.Repository;

import java.util.List;

@Controller
public class EmployeeController {

    private Repository repository;

    @Autowired
    public EmployeeController(Repository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Employee employee,
                         @ModelAttribute Address address) {
        repository.save(employee, address);
        return "success";
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<Employee> employees = repository.getEmployees();
        List<Address> addresses = repository.getAddresses();
        model.addAttribute("employees", employees);
        model.addAttribute("addresses", addresses);
        return "show";
    }
}
