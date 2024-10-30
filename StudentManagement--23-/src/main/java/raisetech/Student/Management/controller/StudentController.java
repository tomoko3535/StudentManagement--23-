package raisetech.Student.Management.controller;

import ch.qos.logback.core.model.Model;
import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.Student.Management.Servise.StudentService;
import raisetech.Student.Management.controller.converter.StudentConverter;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class StudentController {

    private StudentService service;
    private StudentConverter converter;

    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public String getStudentList(Model model){
       List<Student> students = service.searchStudentList();
       List<StudentsCourses> studentsCourses = service.searchStudentCourseList();

       model.addAttribute("studentList", converter.covertStudentDetails(students,studentsCourses));
       return "studentList";
    }


    @GetMapping("/students_coursesList")
    public List<StudentsCourses> getStudentcoursesList() {
        return service.searchStudentCourseList();
    }
}



