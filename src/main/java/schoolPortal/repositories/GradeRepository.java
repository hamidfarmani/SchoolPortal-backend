package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Grade;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface GradeRepository extends JpaRepository<Grade, Long> {

    Grade save(Grade entity);

    @Query(value = "select * from Grade where id = :id", nativeQuery = true)
    Grade findById(@Param("id") Long primaryKey);

    @Query(value = "select * from Grade where studentid = :studentid", nativeQuery = true)
    List<Grade> findByStudentId(@Param("studentid") Long primaryKey);

    @Query(value = "select * from Grade where lessonid = :lessonid", nativeQuery = true)
    List<Grade> findByLessonId(@Param("lessonid") Long primaryKey);

    List<Grade> findAll();

    void delete(Grade entity);

    List<Grade> findGradeById(long teamId);

}
