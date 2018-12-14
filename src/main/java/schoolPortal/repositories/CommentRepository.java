package schoolPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import schoolPortal.Model.Comment;

import java.util.List;

/**
 * Created by hamid on 1/10/17.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment save(Comment entity);

    @Query(value = "select * from Comment where id = :id", nativeQuery = true)
    Comment findById(@Param("id") Long primaryKey);

    @Query(value = "select * from Comment where studentid = :studentid", nativeQuery = true)
    List<Comment> findByStudentId(@Param("studentid") Long primaryKey);

    @Query(value = "select * from Comment where lessonid = :lessonid", nativeQuery = true)
    List<Comment> findByLessonId(@Param("lessonid") Long primaryKey);

    List<Comment> findAll();

    void delete(Comment entity);

    List<Comment> findCommentById(long teamId);

}
