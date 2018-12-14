package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Timetable;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    Timetable save(Timetable entity);

    @Query(value = "select * from Timetable where id = :id", nativeQuery = true)
    Timetable findById(@Param("id") Long primaryKey);

    @Query(value = "select * from Timetable where studentid = :studentid", nativeQuery = true)
    List<Timetable> findByStudentId(@Param("studentid") Long primaryKey);

    @Query(value = "select * from Timetable where lessonid = :lessonid", nativeQuery = true)
    List<Timetable> findByLessonId(@Param("lessonid") Long primaryKey);

    List<Timetable> findAll();

    void delete(Timetable entity);

    List<Timetable> findTimetableById(long teamId);

}
