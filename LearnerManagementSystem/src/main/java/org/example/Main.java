package org.example;

import java.util.ArrayList;
import java.util.List;
import org.airtribe.cohort.Cohort;
import org.airtribe.course.Course;
import org.airtribe.course.JavaOnlineCourse;
import org.airtribe.instructor.Instructor;
import org.airtribe.learner.JavaLearner;
import org.airtribe.learner.Learner;
import org.airtribe.learner.NodeLearner;
import org.w3c.dom.Node;
import org.w3c.dom.css.Rect;


public class Main {


  public static void main(String[] args) {
//    NodeLearner nodeLearner = new NodeLearner("1", "John", 100, 5, 10);
//    nodeLearner.displayLearnerDetails();
//
//    JavaLearner javaLearner = new JavaLearner("2", "Jane", 200, 10, 20);
//    javaLearner.displayLearnerDetails();
//
//    Instructor instructor = new Instructor("1", "Pawan");
//    instructor.displayInstructorDetails();
//
//    List<Learner> learnerList = new ArrayList<>();
//    learnerList.add(nodeLearner);
//    learnerList.add(javaLearner);
//
//    List<Instructor> instructorList = new ArrayList<>();
//    instructorList.add(instructor);
//
//    Cohort cohort = new Cohort("1", "01/01/2020", "01/01/2021", "Cohort 1", "Cohort 1 description", learnerList, instructorList);
//    cohort.displayCohortDetails();
//    cohort.calculateAverageXps();
//
//    Course course = new JavaOnlineCourse("1", "Java Course", "Java Course Description", "https://zoom.us/java", "JAVA");
//    course.setCohortList(new ArrayList<>(List.of(cohort)));
//    course.displayCourseDetails();

    ElectricEngine engine = new ElectricEngine("1", "test", 100);
    Car car = new Car("1", engine);
    car.start();

    HybridEngine engine1 = new HybridEngine("2", "test", 100);
    car.setEngine(engine1);

  }
}