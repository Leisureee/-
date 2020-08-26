package me.lolico.sms.controller;

import me.lolico.sms.entity.Employee;
import me.lolico.sms.service.EmployeeService;
import me.lolico.sms.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    EmployeeService employeeService;

    List<Employee> employeeList;

    @Before
    public void setUp() throws Exception {
        Employee employee = new Employee();
        employee.setName("test");
        employeeList = Collections.singletonList(employee);

        when(employeeService.getAllEmployee()).thenReturn(employeeList);
    }

    @Test
    public void redirectLoginPageWhenGetWithoutAuthentication() throws Exception {
        mvc.perform(get("/EmployeeController?action=show"))
                .andExpect(result -> assertThat(result.getResponse().getRedirectedUrl())
                        .endsWith("/account/login?status=4"));
    }

    @Test
    public void forbiddenWhenPostWithoutAuthentication() throws Exception {
        mvc.perform(post("/EmployeeController?action=delete"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void showAllEmployeesWithMockUserPrincipal() throws Exception {
        mvc.perform(get("/EmployeeController?action=show"))
                .andExpect(model().attribute("employeeList", employeeList))
                .andExpect(view().name("welcome"));
    }

    @Test
    @WithMockUser
    public void badRequestWhenPostWithInvalidAction() throws Exception {
        mvc.perform(post("/EmployeeController?action=invalid").with(csrf()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void forbiddenWhenPostWithoutCsrfToken() throws Exception {
        mvc.perform(post("/EmployeeController?action=delete"))
                .andExpect(status().isForbidden());
    }

    @TestConfiguration
    static class TestConfig { //for spring security UserDetailsService
        @Bean
        public UserService userService() {
            return mock(UserService.class);
        }
    }
}