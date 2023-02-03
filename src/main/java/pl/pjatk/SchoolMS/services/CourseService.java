package pl.pjatk.SchoolMS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjatk.SchoolMS.model.Course;
import pl.pjatk.SchoolMS.model.Student;
import pl.pjatk.SchoolMS.repositories.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course){
        courseRepository.save(course);
    }

    public Course findCourseById(Long id){
        return courseRepository.getReferenceById(id);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public List<Course> findCoursesByTeacherId(Long id){
        return courseRepository.findCoursesByTeacherId(id);
    }
}
