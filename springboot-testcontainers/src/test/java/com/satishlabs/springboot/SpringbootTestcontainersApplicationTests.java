package com.satishlabs.springboot;

import com.satishlabs.springboot.entity.Student;
import com.satishlabs.springboot.repository.StudentRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringbootTestcontainersApplicationTests {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MockMvc mockMvc;

    //  given/when/then format - BDD Style
    @Test
    public void givenStudent_whenGetAllStudents_thenListOfStudents() throws Exception {
        //given - setup or precondtion
        List<Student> students =
                List.of(Student.builder().firstName("Satish").lastName("Prasad").email("sat@gmail").build(),
                        Student.builder().firstName("Test").lastName("sprinboot").email("test@gmail").build());
        studentRepository.saveAll(students);
        //when - action
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/students"));

        //then - verif the output
        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(students.size())));
    }
}
