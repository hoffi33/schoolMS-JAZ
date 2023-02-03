package pl.pjatk.SchoolMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.pjatk.SchoolMS.model.Course;
import pl.pjatk.SchoolMS.model.Student;
import pl.pjatk.SchoolMS.services.CourseService;
import pl.pjatk.SchoolMS.services.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> studentList = studentService.getAllStudents();

        model.addAttribute("allStudents", studentList);

        return "students";
    }

    @RequestMapping("/student/add/new")
    public String createNewStudent(Model model) {
        List<Course> courseList = courseService.getAllCourses();
        model.addAttribute("newStudent", new Student());
        model.addAttribute("allCourses", courseList);
        return "studentform";
    }

    @PostMapping("/students")
    public String saveNewStudent(Student student){
        studentService.addNewStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/student")
    public String readStudent(@RequestParam("id") Long id, Model model){
        Student getStudent = studentService.findStudentById(id);
        model.addAttribute("student", getStudent);
        return "student";
    }

    @GetMapping("/student/edit")
    public ModelAndView editStudent(@RequestParam("id") Long id, Model model){
        ModelAndView modelAndView = new ModelAndView("studentedit");
        List<Course> courseList = courseService.getAllCourses();
        model.addAttribute("allCourses",courseList);
        Student getStudent = studentService.findStudentById(id);
        modelAndView.addObject("newStudent",getStudent);
        return modelAndView;
    }
    @GetMapping("/student/delete")
    public String deleteStudent(@RequestParam("id") Long id){
        studentService.deleteStudent(id);

        return "redirect:/students";
    }

}
