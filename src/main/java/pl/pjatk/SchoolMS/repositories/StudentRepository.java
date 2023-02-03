package pl.pjatk.SchoolMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.pjatk.SchoolMS.model.Student;

import java.util.Collection;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Course cs join cs.students s WHERE cs.id = :id")
    List<Student> findStudentsByCourseId(@Param("id") Long id);




}
