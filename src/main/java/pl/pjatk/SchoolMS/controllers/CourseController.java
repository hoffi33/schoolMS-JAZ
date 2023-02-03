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
import pl.pjatk.SchoolMS.model.Teacher;
import pl.pjatk.SchoolMS.services.CourseService;
import pl.pjatk.SchoolMS.services.StudentService;
import pl.pjatk.SchoolMS.services.TeacherService;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        List<Course> courseList = courseService.getAllCourses();
        model.addAttribute("allStudents", studentList);
        model.addAttribute("allCourses", courseList);
        return "courses";
    }

    @RequestMapping("/course/add/new")
    public String createNewCourse(Model model) {
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addAttribute("newCourse", new Course());
        model.addAttribute("allTeachers", teacherList);
        return "courseform";
    }

    @PostMapping("/courses")
    public String saveNewCourse(Course course) {
        courseService.addNewCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/course")
    public String readCourse(@RequestParam("id") Long id, Model model) {
        Course getCourse = courseService.findCourseById(id);
        List<Student> studentList = studentService.findAllStudentByCourseId(id);
        model.addAttribute("course", getCourse);
        model.addAttribute("allStudents", studentList);
        return "course";
    }

    @GetMapping("/course/edit")
    public ModelAndView editCourse(@RequestParam("id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("courseedit");
        List<Teacher> teacherList = teacherService.getAllTeachers();
        model.addAttribute("allTeachers",teacherList);
        Course getCourse = courseService.findCourseById(id);
        modelAndView.addObject("newCourse",getCourse);
        return modelAndView;
    }



    @GetMapping("/course/delete")
    public String deleteCourse(@RequestParam("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }

}
