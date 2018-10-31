package repository;

import model.Address;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Repository {

    private EmployeeRepository employeeRepo;
    private AddressRepository addressRepo;

    @Autowired
    public Repository(EmployeeRepository employeeRepo, AddressRepository addressRepo) {
        this.employeeRepo = employeeRepo;
        this.addressRepo = addressRepo;
    }

    public Repository() {}

    public void save(Employee employee, Address address) {
        addressRepo.save(address);
        employee.setAddress(address);
        employeeRepo.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public List<Address> getAddresses() {
        return addressRepo.findAll();
    }

    public void delete(long id) {
        employeeRepo.delete(employeeRepo.findEmployeeById(id));
    }

    public List<Employee> sortById() {
        return employeeRepo.findAllByOrderById();
    }

    public List<Employee> sortByAgeASC() {
        return employeeRepo.findAllByOrderByAgeAsc();
    }

    public List<Employee> sortByAgeDESC() {
        return employeeRepo.findAllByOrderByAgeDesc();
    }

    public List<Employee> sortByEarningsASC() {
        return employeeRepo.findAllByOrderByEarningsAsc();
    }

    public List<Employee> sortByEarningsDESC() {
        return employeeRepo.findAllByOrderByEarningsDesc();
    }
}
