package me.lolico.sms.controller;

import me.lolico.sms.entity.Employee;
import me.lolico.sms.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

/**
 * @author lolico
 */
@Controller
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/EmployeeController", params = "action=show")
    public String common(Model model) throws SQLException {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employeeList);
        return "welcome";
    }

    @PostMapping("/EmployeeController")
    public String common(RedirectAttributes redirectAttributes, String action, Employee employee) throws SQLException {
        switch (action) {
            case "delete": {
                employeeService.deleteEmployeeById(employee.getId());
                break;
            }
            case "update": {
                employeeService.updateEmployee(employee);
                break;
            }
            case "insert": {
                employeeService.insertEmployee(employee);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected action: " + action);
        }
        List<Employee> employeeList = employeeService.getAllEmployee();
        redirectAttributes.addFlashAttribute("employeeList", employeeList);
        return "redirect:/index";
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handle() {
        return ResponseEntity.badRequest().build();
    }

}
