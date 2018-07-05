package com.example.lesson_15;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    /* **** creating employee*******************/
    public String index(Model model){
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("888-52-6666");

        ///**** creating laptop****************** */
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");

        //****add laptop to employee*****///
        employee.setLaptop(laptop);

        //**save employee to database ******///
        employeeRepository.save(employee);

        //*** grab all the employee from the database and send them to the template******///
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";

    }

}
