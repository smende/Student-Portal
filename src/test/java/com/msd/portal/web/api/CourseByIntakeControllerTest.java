package com.msd.portal.web.api;

import com.msd.portal.domain.Course;
import com.msd.portal.domain.CourseByInTake;
import com.msd.portal.service.CourseByInTakeService;
import org.aspectj.apache.bcel.classfile.Constant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
class CourseByIntakeControllerTest {
    
//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext wac;

    @InjectMocks
    CourseByIntakeController courseByIntakeController;

    @Mock
    CourseByInTakeService courseByInTakeService;
//    @Before
//    public void setup() throws Exception{
//        this.mockMvc = webAppContextSetup(wac).build();
//    }
    @Test
    void getAll() throws Exception {

//        ServletContext servletContext = wac.getServletContext();
//        Assert.assertNotNull(servletContext);
//        Assert.assertTrue(servletContext instanceof MockServletContext);
//        ResultActions resultActions = mockMvc
//                .perform(get("/api/coursesbyintake")
//                        .contextPath("/api/coursesbyintake")
//                        .header("Accept","application/json"))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
        List<CourseByInTake> resultList =  courseByIntakeController.getAll();
        System.out.println("-------"+ resultList);

    }

    @Test
    void addNew() {





    }

    @Test
    void bulkSave() {
    }
}