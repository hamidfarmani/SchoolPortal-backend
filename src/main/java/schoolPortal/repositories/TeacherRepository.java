package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Teacher;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher save(Teacher entity);

    @Query(value = "select * from Teacher where id = :id", nativeQuery = true)
    Teacher findById(@Param("id") Long primaryKey);


    @Query(value = "select * from Teacher where username = :username and password = :password", nativeQuery = true)
    Teacher findByUsernameAndAndPassword(@Param("username") String username,@Param("password") String password);


    List<Teacher> findAll();

    void delete(Teacher entity);

    List<Teacher> findTeacherById(long teamId);

}
