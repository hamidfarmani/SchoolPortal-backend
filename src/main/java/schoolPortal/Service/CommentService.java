package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Comment;

import java.util.List;

public interface CommentService {
    public Comment saveComment(Comment comment);
    public Comment updateComment(Comment comment);
    public void deleteComment(Comment comment);
    public Comment findComment(Long ID);
    public List<Comment> getAllComments();
    public List<Comment> findByStudentID(Long studentID);
    public List<Comment> findByLessonID(Long lessonID);
}
