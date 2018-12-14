package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Parent;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Parent save(Parent entity);

    @Query(value = "select * from Parent where id = :id", nativeQuery = true)
    Parent findById(@Param("id") Long primaryKey);

    @Query(value = "select * from Parent where studentid = :studentid", nativeQuery = true)
    List<Parent> findByStudentId(@Param("studentid") Long primaryKey);

    @Query(value = "select * from Parent where username = :username and password = :password", nativeQuery = true)
    Parent findByUsernameAndAndPassword(@Param("username") String username,@Param("password") String password);

    List<Parent> findAll();

    void delete(Parent entity);

    List<Parent> findParentById(long teamId);

}
