package pl.pjatk.SchoolMS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjatk.SchoolMS.model.Student;
import pl.pjatk.SchoolMS.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        studentRepository.save(student);
    }

    public Student findStudentById(Long id){
        return studentRepository.getReferenceById(id);
    }

    public void deleteStudent(Long id){
         studentRepository.deleteById(id);
    }

    public List<Student> findAllStudentByCourseId(Long id){
        return studentRepository.findStudentsByCourseId(id);
    }
}
