package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Grade;
import schoolPortal.Model.Lesson;
import schoolPortal.Model.Student;
import schoolPortal.Service.GradeService;
import schoolPortal.Service.LessonService;
import schoolPortal.Service.StudentService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
public class GradeController implements Serializable {
    private GradeService gradeService;
    private StudentService studentService;
    private LessonService lessonService;

    @Autowired
    public void setProductService(GradeService gradeService, StudentService studentService, LessonService lessonService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
        this.lessonService = lessonService;
    }


    @PostMapping("/grades")
    public ResponseEntity<String> createGrade(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String mark = jsonObjectRequest.getString("mark").trim();
        String studentID = jsonObjectRequest.getString("studentid").trim();
        String lessonID = jsonObjectRequest.getString("lessonid").trim();
        Student student = studentService.findStudent(Long.valueOf(studentID));
        Lesson lesson = lessonService.findLesson(Long.valueOf(lessonID));
        Grade grade= new Grade(Integer.valueOf(mark),new Date(),student,lesson);
        gradeService.saveGrade(grade);
        return returnResponse(Status.OK);
    }

    @PatchMapping("/grades/{id}")
    public ResponseEntity<String> updateGrade(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Grade toUpdate = gradeService.findGrade(Long.valueOf(id));
        String mark = jsonObjectRequest.getString("mark").trim();
        String studentID = jsonObjectRequest.getString("studentid").trim();
        String lessonID = jsonObjectRequest.getString("lessonid").trim();
        Student student = studentService.findStudent(Long.valueOf(studentID));
        Lesson lesson = lessonService.findLesson(Long.valueOf(lessonID));
        toUpdate.setMark(Integer.valueOf(mark));
        toUpdate.setLessonid(lesson);
        toUpdate.setStudentid(student);
        gradeService.updateGrade(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/grades/{id}")
    public ResponseEntity<String> DeleteGrade(@PathVariable String id){
        Grade toDelete = gradeService.findGrade(Long.valueOf(id));
        gradeService.deleteGrade(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/grades")
    public List<Grade> getGrade(){
       return gradeService.getAllGrades();
    }

    @GetMapping("/grades/{id}")
    public Grade getGradeByID(@PathVariable String id) {
        Grade toShow = gradeService.findGrade(Long.valueOf(id));
        return toShow;
    }

    @GetMapping("/grades/{id}/student")
    public List<Grade> getGradeByStudentID(@PathVariable String id) {
        List<Grade> toShow = gradeService.findByStudentID(Long.valueOf(id));
        return toShow;
    }

    @GetMapping("/grades/{id}/lesson")
    public List<Grade> getGradeByLessonID(@PathVariable String id) {
        List<Grade> toShow = gradeService.findByLessonID(Long.valueOf(id));
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
//        tgrades.add(tstudent);
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
