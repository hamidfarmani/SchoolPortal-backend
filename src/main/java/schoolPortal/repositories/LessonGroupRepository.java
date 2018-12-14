package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Lessongroup;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface LessonGroupRepository extends JpaRepository<Lessongroup, Long> {

    Lessongroup save(Lessongroup entity);

    @Query(value = "select * from Lessongroup where id = :id", nativeQuery = true)
    Lessongroup findById(@Param("id") Long primaryKey);


    List<Lessongroup> findAll();

    void delete(Lessongroup entity);

    List<Lessongroup> findLessonGroupById(long teamId);

}
