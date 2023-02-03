package pl.pjatk.SchoolMS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjatk.SchoolMS.model.Course;
import pl.pjatk.SchoolMS.model.Teacher;
import pl.pjatk.SchoolMS.repositories.CourseRepository;
import pl.pjatk.SchoolMS.repositories.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public Teacher findTeacherById(Long id){
        return teacherRepository.getReferenceById(id);
    }

    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }

}
