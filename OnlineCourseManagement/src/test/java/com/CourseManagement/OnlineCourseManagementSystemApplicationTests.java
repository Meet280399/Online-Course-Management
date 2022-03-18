package com.CourseManagement;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.course_management.OnlineCourseManagementApplication;
import com.course_management.dao.CourseRepository;
import com.course_management.dao.InstructorRepository;
import com.course_management.dao.StudentRepository;
import com.course_management.model.Course;
import com.course_management.model.Instructor;
import com.course_management.model.Student;

@SpringBootTest(classes = OnlineCourseManagementApplication.class)
class OnlineCourseManagementSystemApplicationTests {
	@Autowired
	public CourseRepository courseRepository;
	@Autowired
	public InstructorRepository instructorRepository;
	@Autowired
	public StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}
//		@Test
//		public void testUpdateStudent()
//		{
//			Student student=studentRepository.findById(101).get();
//			student.setFirstName("patel");
//			studentRepository.save(student);
//			assertNotEquals("patel meet",studentRepository.findById(101).get().getFirstName());
//		}

//		@Test
//		public void testUpdateCourse()
//		{
//			Course course=courseRepository.findById(14).get();
//			course.setCourseName("J2EE");
//			courseRepository.save(course);
//			assertNotEquals("J2EE",courseRepository.findById(14).get().getCourseName());
//		}
//		
//		@Test
//		public void testUpdateInstructor()
//		{
//			Instructor instructor=instructorRepository.findById(51).get();
//			instructor.setInstructorId(50);
//			instructorRepository.save(instructor);
//			assertNotEquals(50,instructorRepository.findById(51).get().getInstructorId());
//		}

	@Test
	public void testUpdateCourse() {
		Course course = courseRepository.findById(11).get();
		course.setCourseName("Full Stack Java Development with DellBhoomi");
		courseRepository.save(course);
		assertNotEquals("Full Stack Java Development", courseRepository.findById(11).get().getCourseName());
	}

}
