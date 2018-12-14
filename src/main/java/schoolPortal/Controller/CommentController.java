package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Comment;
import schoolPortal.Model.Lesson;
import schoolPortal.Model.Student;
import schoolPortal.Service.CommentService;
import schoolPortal.Service.LessonService;
import schoolPortal.Service.StudentService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class CommentController implements Serializable {
    private CommentService commentService;
    private StudentService studentService;
    private LessonService lessonService;

    @Autowired
    public void setProductService(CommentService commentService, StudentService studentService, LessonService lessonService) {
        this.commentService = commentService;
        this.studentService = studentService;
        this.lessonService = lessonService;
    }


    @PostMapping("/comments")
    public ResponseEntity<String> createComment(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String description = jsonObjectRequest.getString("description").trim();
        String studentID = jsonObjectRequest.getString("studentid").trim();
        String lessonID = jsonObjectRequest.getString("lessonid").trim();
        Student student = studentService.findStudent(Long.valueOf(studentID));
        Lesson lesson = lessonService.findLesson(Long.valueOf(lessonID));
        Comment comment= new Comment(description,student,lesson);
        commentService.saveComment(comment);
        return returnResponse(Status.OK);
    }

    @PatchMapping("/comments/{id}")
    public ResponseEntity<String> updateComment(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Comment toUpdate = commentService.findComment(Long.valueOf(id));
        String description = jsonObjectRequest.getString("description").trim();
        String studentID = jsonObjectRequest.getString("studentid").trim();
        String lessonID = jsonObjectRequest.getString("lessonid").trim();
        Student student = studentService.findStudent(Long.valueOf(studentID));
        Lesson lesson = lessonService.findLesson(Long.valueOf(lessonID));
        toUpdate.setDescription(description);
        toUpdate.setLessonid(lesson);
        toUpdate.setStudentid(student);
        commentService.updateComment(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<String> DeleteComment(@PathVariable String id){
        Comment toDelete = commentService.findComment(Long.valueOf(id));
        commentService.deleteComment(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/comments")
    public List<Comment> getComment(){
       return commentService.getAllComments();
    }

    @GetMapping("/comments/{id}")
    public Comment getCommentByID(@PathVariable String id) {
        Comment toShow = commentService.findComment(Long.valueOf(id));
        return toShow;
    }

    @GetMapping("/comments/{id}/student")
    public List<Comment> getCommentByStudentID(@PathVariable String id) {
        List<Comment> toShow = commentService.findByStudentID(Long.valueOf(id));
        return toShow;
    }

    @GetMapping("/comments/{id}/lesson")
    public List<Comment> getCommentByLessonID(@PathVariable String id) {
        List<Comment> toShow = commentService.findByLessonID(Long.valueOf(id));
        return toShow;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason = "ID Not Found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //nothing to do
    }

//    @PostMapping("/schoolPortal")
//    //@ResponseStatus(HttpStatus.CREATED)
//    public Tstudent CreateNewProduct(@RequestBody Tstudent tstudent){
//        tcomments.add(tstudent);
//        return tstudent;
//    }


    private ResponseEntity<String> returnResponse(Status status) {
        return ResponseProvider.getInstance().getResponse(status);
    }

    private ResponseEntity<String> returnResponse(Status status, JSONObject jsonObject) {
        return ResponseProvider.getInstance().getResponse(status, jsonObject);
    }

    private ResponseEntity<String> returnResponse(Status status, HttpHeaders headers) {
        return ResponseProvider.getInstance().getResponse(status, headers);
    }

    private ResponseEntity<String> returnResponse(Status status, JSONObject jsonObject, HttpHeaders headers) {
        return ResponseProvider.getInstance().getResponse(status, jsonObject, headers);
    }
}
