package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Classroom;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface ClassRoomRepository extends JpaRepository<Classroom, Long> {

    Classroom save(Classroom entity);

    @Query(value = "select * from Classroom where id = :id", nativeQuery = true)
    Classroom findById(@Param("id") Long primaryKey);


    List<Classroom> findAll();

    void delete(Classroom entity);

    List<Classroom> findLessonGroupById(long teamId);

}
