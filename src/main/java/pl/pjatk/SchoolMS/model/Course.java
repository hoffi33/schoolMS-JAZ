package pl.pjatk.SchoolMS.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;
    @Column(name = "ECTS_points")
    private int ectsPoints;

    @OneToMany(mappedBy = "course", cascade= CascadeType.REMOVE)
    private List<Student> students;

    @ManyToOne(cascade= CascadeType.REMOVE)
    private Teacher teacher;


    public Course() {
    }

    public Course(Long id, String courseName, int ectsPoints) {
        this.id = id;
        this.courseName = courseName;
        this.ectsPoints = ectsPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacherName() {
        return teacher.getName();
    }
    public String getTeacherEmail() {
        return teacher.getEmail();
    }
}
