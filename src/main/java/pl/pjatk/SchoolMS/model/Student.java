package pl.pjatk.SchoolMS.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String indeks;
    private int age;

    @ManyToOne(cascade= CascadeType.REMOVE)
    private Course course;
    public Student() {
    }

    public Student(String name, String surname, String indeks, int age) {
        this.name = name;
        this.surname = surname;
        this.indeks = indeks;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public Course getCourse() {
        return course;
    }
    public Long getCourseId() {
        return course.getId();
    }
    public String getCourseName() {
        return course.getCourseName();
    }
    public void setCourse(Course course) {
        this.course = course;
    }
}
