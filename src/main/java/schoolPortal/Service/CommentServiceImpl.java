package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Comment;
import schoolPortal.repositories.CommentRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllUsers() {
        return commentRepository.findAll();
    }


    public Comment saveComment(Comment comment) {
        Comment res = commentRepository.save(comment);
        return res;
    }

    public Comment updateComment(Comment comment) {
        Comment res = commentRepository.save(comment);
        return res;
    }

    public Comment findComment(Long ID){
        Comment res = commentRepository.findById(ID);
        return res;
    }

    public void deleteComment(Comment comment){
        commentRepository.delete(comment);
    }

    public List<Comment> getAllComments(){
        List<Comment> all = commentRepository.findAll();
        return all;
    }

    public List<Comment> findByStudentID(Long studentID){
        List<Comment> res = commentRepository.findByStudentId(studentID);
        return res;
    }

    public List<Comment> findByLessonID(Long lessonID){
        List<Comment> res = commentRepository.findByLessonId(lessonID);
        return res;
    }
}
