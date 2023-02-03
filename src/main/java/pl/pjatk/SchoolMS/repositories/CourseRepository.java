package pl.pjatk.SchoolMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.pjatk.SchoolMS.model.Course;
import pl.pjatk.SchoolMS.model.Student;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Teacher te join te.courseList c WHERE te.id = :id")
    List<Course> findCoursesByTeacherId(@Param("id") Long id);
}
