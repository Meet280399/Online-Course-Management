package com.CourseManagement;
 
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
 
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.course_management.OnlineCourseManagementApplication;
import com.course_management.dao.CourseRepository;
import com.course_management.dao.FeedbackRepository;
import com.course_management.dao.InstructorRepository;
import com.course_management.dao.StudentRepository;
import com.course_management.model.Course;
import com.course_management.model.Feedback;
import com.course_management.model.Instructor;
import com.course_management.model.Student;
 
@SpringBootTest(classes = OnlineCourseManagementApplication.class)
class OnlineCourseManagementSystemApplicationTests {
    // connecting to the course repository for methods defined
    @Autowired
    public CourseRepository courseRepository;
 
    // connecting to the instructor repository for methods defined
    @Autowired
    public InstructorRepository instructorRepository;
 
    // connecting to the student repository for methods defined
    @Autowired
    public StudentRepository studentRepository;
 
    // connecting to the feedback repository for methods defined
    @Autowired
    public FeedbackRepository feedbackRepository;
 
    @Test
    void contextLoads() {
    }
 
    // test case for checking the updation of student
    @Test
    public void testUpdateStudent() {
        Student student = studentRepository.findById(101).get();
        student.setFirstName("patel");
        studentRepository.save(student);
        assertNotEquals("patel meet", studentRepository.findById(101).get().getFirstName());
    }
 
    // test case for checking the list of the students
    @Test
    public void testViewStudent() {
        List<Student> list = studentRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
 
//        @Test
//        public void testUpdateCourse()
//        {
//            Course course=courseRepository.findById(14).get();
//            course.setCourseName("J2EE");
//            courseRepository.save(course);
//            assertNotEquals("J2EE",courseRepository.findById(14).get().getCourseName());
//        }
 
    // test case for checking the updation of instructor
    @Test
    public void testUpdateInstructor() {
        Instructor instructor = instructorRepository.findById(51).get();
        instructor.setInstructorId(50);
        instructorRepository.save(instructor);
        assertNotEquals(50, instructorRepository.findById(51).get().getInstructorId());
    }
 
    // test case for checking the list of the instructor
    @Test
    public void testViewInstructor() {
        List<Instructor> list = instructorRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
 
    // test case for checking the updation of course
    @Test
    public void testUpdateCourse() {
        Course course = courseRepository.findById(11).get();
        course.setCourseName("Full Stack Java Development with DellBhoomi");
        courseRepository.save(course);
        assertNotEquals("Full Stack Java Development", courseRepository.findById(11).get().getCourseName());
    }
 
    // test case for checking the list of the course
    @Test
    public void testViewCourse() {
        List<Course> list = courseRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
 
    // test case for checking the updation of feedback
    @Test
    public void testUpdateFeedback() {
        Feedback feedback = feedbackRepository.findById(604).get();
        feedback.setDescription("Really Doing Great");
        feedbackRepository.save(feedback);
        assertNotEquals("Doing Great", feedbackRepository.findById(604).get().getDescription());
    }
 
    // test case for checking the list of the feedback
    @Test
    public void testViewFeedback() {
        List<Feedback> list = feedbackRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
 
}