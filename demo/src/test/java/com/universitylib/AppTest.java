package com.universitylib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.universitylib.App.CouseScenarios;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void addingCourseTest() {
        Course course = CouseScenarios.addingCourse();
        assertEquals(1, course.getCode());
    }

    @Test
    public void addingCourseToWaitlistTest() {
        Course course = CouseScenarios.addingCourseToWaitlist();
        assertEquals(10, course.getCode());
    }

    @Test
    public void gettingWaitlistCapacityTest() {
        Course course = CouseScenarios.gettingWaitlistCapacity();
        assertFalse(course.getWaitlist(course.getCode()));
    }


    @Test
    public void addingCourseToWaitlist() {
        Course course = CouseScenarios.addingCourseToWaitlist();
        assertEquals(10, course.getCode());
    }

    // @Test
    // public void maxOutCourseCapacityTesst() {
    //     Student Student5 = new Student(100, 3.2, 22);
    //     Course course = CouseScenarios.maxOutCourseCapacity();
    //     assertFalse(course.addToCourse(Student5, course.getCode()));
    // }
}
