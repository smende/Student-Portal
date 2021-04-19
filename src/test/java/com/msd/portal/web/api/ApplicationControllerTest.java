package com.msd.portal.web.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msd.portal.domain.Application;
import com.msd.portal.domain.Course;
import com.msd.portal.domain.CourseByInTake;
import com.msd.portal.domain.User;
import com.msd.portal.enumtypes.ApplicationStatus;
import com.msd.portal.service.ApplicationService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationControllerTest {

    @Autowired
    private ApplicationService applicationService;

    List<Application> applicationList = new ArrayList<>();

    void finalMethod(Instant startTime, Instant endTime) {

        System.out.println("time taken to process the Request : " + Duration.between(startTime, endTime).toMillis() + " ms");
    }

    @Test
    void getAll() {
        Instant startTime = Instant.now();
        applicationList = applicationService.getAll();
        System.out.printf("allUsersList :: " + applicationList.toString());
        finalMethod(startTime, Instant.now());
    }

    @Test
    void getAllByUserId() {
        Instant startTime = Instant.now();
        applicationList = applicationService.getAllByUserId(6L);
        System.out.println("ALL_BY_User : " + applicationList);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void getById() {
        Instant startTime = Instant.now();
        Optional<Application> applicationList = applicationService.getById(132L);
        System.out.println("Get BY ID : " + applicationList);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void getAllByStatus() {
        Instant startTime = Instant.now();
        applicationList = applicationService.getAllByStatus(ApplicationStatus.SUBMITTED);
        System.out.println("Get BY Status : " + applicationList);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void getAllByUserIdAndStatus() {
        Instant startTime = Instant.now();
        applicationList = applicationService.getAllByUserIdAndStatus(6L, ApplicationStatus.SUBMITTED.toString());
        System.out.println("Get BY User_ID and Status : " + applicationList);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void getApplicationsByUserIdWhichAreNotAllowedToReApply() {
        Instant startTime = Instant.now();
        applicationList = applicationService.getApplicationsByUserIdWhichAreNotAllowedToReApply(6L);
        System.out.println("ApplicationsByUserIdWhichAreNotAllowedToReApply : " + applicationList);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void getByUserIdAndCourseByInTakeId() {
        Instant startTime = Instant.now();
        applicationList = applicationService.getApplicationsByUserIdAndCourseByInTakeId(6L, 109L);
        System.out.println("ByUserIdAndCourseByInTakeId : " + applicationList);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void canUserApplyToCourseByInTakeRecord() {
        Instant startTime = Instant.now();
        Boolean result = applicationService.canUserApplyToCourseByInTakeRecord(6L, 109L);
        System.out.println("canUserApplyToCourseByInTakeRecord : " + result);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void addNew() {
        Application application = new Application();
        application.setId(132L);
        application.setStatus(ApplicationStatus.SUBMITTED);
        application.setNotes("nothing");

        User user = new User();
        user.setId(8L);
        user.setFirstName("bunny");
        user.setLastName("katakam");
        user.setUserName(null);
        user.setEmail("pradeep97.m@mail.com");
        user.setCell("1213");
        application.setUser(user);

        CourseByInTake courseByInTake = new CourseByInTake();
        courseByInTake.setId(110L);
        Course course = new Course();
        //todo Need to Build the Application Object and send in AddNew() method;
        Instant startTime = Instant.now();
        Application result = applicationService.addNew(application);
        System.out.println("Adding New Application : " + result);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void updateById() {
        Instant startTime = Instant.now();
        Application application = new Application();
        //todo need to create Application Object
        applicationService.updateById(6L, application);
        finalMethod(startTime, Instant.now());
    }

    @Test
    void deleteById() {
        Instant starTime = Instant.now();
        applicationService.deleteById(6L);
        finalMethod(starTime, Instant.now());
    }

    @Test
    void withdrawApplication() {
        Instant startTime = Instant.now();
        Application application = new Application();
        //todo Application object need to build
        applicationService.withdrawOwnApplication(application);
        finalMethod(startTime, Instant.now());
    }
}