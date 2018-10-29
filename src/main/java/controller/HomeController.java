package controller;

import model.Address;
import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("newEmployee", new Employee());
        model.addAttribute("employeeAddress", new Address());
        return "index";
    }
}
