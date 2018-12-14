package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Studentgroup;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface StudentGroupRepository extends JpaRepository<Studentgroup, Long> {

    Studentgroup save(Studentgroup entity);

    @Query(value = "select * from Studentgroup where id = :id", nativeQuery = true)
    Studentgroup findById(@Param("id") Long primaryKey);


    List<Studentgroup> findAll();

    void delete(Studentgroup entity);

    List<Studentgroup> findStudentGroupById(long teamId);

}
