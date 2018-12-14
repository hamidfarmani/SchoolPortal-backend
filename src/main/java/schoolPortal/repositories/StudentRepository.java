package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Student;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student save(Student entity);

    @Query(value = "select * from Student where id = :id", nativeQuery = true)
    Student findById(@Param("id") Long primaryKey);

    @Query(value = "select * from Student where username = :username and password = :password", nativeQuery = true)
    Student findByUsernameAndAndPassword(@Param("username") String username,@Param("password") String password);

    List<Student> findAll();

    void delete(Student entity);

    List<Student> findStudentById(long teamId);

}
