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
public class TeacherController {
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public String getAllTeachers(Model model) {
        List<Teacher> teacherList = teacherService.getAllTeachers();
        List<Course> courseList = courseService.getAllCourses();
        model.addAttribute("allTeachers", teacherList);
        model.addAttribute("allCourses", courseList);
        return "teachers";
    }

    @RequestMapping("/teacher/add/new")
    public String createNewTeacher(Model model) {
        model.addAttribute("newTeacher", new Teacher());
        return "teacherform";
    }

    @PostMapping("/teachers")
    public String saveNewTeacher(Teacher teacher) {
        teacherService.addNewTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teacher")
    public String readTeacher(@RequestParam("id") Long id, Model model) {
        Teacher getTeacher = teacherService.findTeacherById(id);
        List<Course> courseList = courseService.findCoursesByTeacherId(id);
        model.addAttribute("teacher", getTeacher);
        model.addAttribute("allCourses", courseList);
        return "teacher";
    }

    @GetMapping("/teacher/edit")
    public ModelAndView editTeacher(@RequestParam("id") Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("teacheredit");
        Teacher getTeacher = teacherService.findTeacherById(id);
        modelAndView.addObject("newTeacher", getTeacher);
        return modelAndView;
    }

    @GetMapping("/teacher/delete")
    public String deleteCourse(@RequestParam("id") Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }

}
