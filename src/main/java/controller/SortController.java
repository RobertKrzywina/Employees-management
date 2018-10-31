package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repository.Repository;

import java.util.List;

@Controller
public class SortController {

    private Repository repository;

    @Autowired
    public SortController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/sortById")
    public String sortById(Model model) {
        List<Employee> employees = repository.sortById();
        model.addAttribute("employees", employees);
        return "show";
    }


    @GetMapping("/sortByAgeASC")
    public String sortByAgeASC(Model model) {
        List<Employee> employees = repository.sortByAgeASC();
        model.addAttribute("employees", employees);
        return "show";
    }

    @GetMapping("/sortByAgeDESC")
    public String sortByAgeDESC(Model model) {
        List<Employee> employees = repository.sortByAgeDESC();
        model.addAttribute("employees", employees);
        return "show";
    }

    @GetMapping("/sortByEarningsASC")
    public String sortByEarningsASC(Model model) {
        List<Employee> employees = repository.sortByEarningsASC();
        model.addAttribute("employees", employees);
        return "show";
    }

    @GetMapping("/sortByEarningsDESC")
    public String sortByEarningsDESC(Model model) {
        List<Employee> employees = repository.sortByEarningsDESC();
        model.addAttribute("employees", employees);
        return "show";
    }
}
