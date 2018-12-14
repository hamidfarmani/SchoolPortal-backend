package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Lesson;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Lesson save(Lesson entity);

    @Query(value = "select * from Lesson where id = :id", nativeQuery = true)
    Lesson findById(@Param("id") Long primaryKey);


    List<Lesson> findAll();

    void delete(Lesson entity);

    List<Lesson> findLessonById(long teamId);

}
