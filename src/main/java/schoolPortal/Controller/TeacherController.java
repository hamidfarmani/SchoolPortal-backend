package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Teacher;
import schoolPortal.Model.Lessongroup;
import schoolPortal.Service.LessongroupService;
import schoolPortal.Service.TeacherService;
import schoolPortal.Service.LessongroupService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class TeacherController implements Serializable {
    private TeacherService teacherService;
    private LessongroupService lessongroupService;

    @Autowired
    public void setProductService(TeacherService teacherService, LessongroupService lessongroupService) {
        this.teacherService = teacherService;
        this.lessongroupService = lessongroupService;
    }


    @PostMapping("/teachers")
    public ResponseEntity<String> createTeacher(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String name = jsonObjectRequest.getString("name").trim();
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        Lessongroup lessongroup = lessongroupService.findLessongroup(Long.valueOf(groupid));
        Teacher teacher= new Teacher(name,username,password,lessongroup);
        teacherService.saveTeacher(teacher);
        return returnResponse(Status.OK);
    }

    @PostMapping("/teachers/find")
    public ResponseEntity<String> findTeacherByUserPass(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        Teacher teacher = teacherService.findTeacher(username, password);
        if(teacher!=null) {
            JSONObject returnValue = new JSONObject();
            returnValue.put("name", teacher.getName());
            return returnResponse(Status.OK,returnValue);
        }else {
            return returnResponse(Status.NOT_FOUND);
        }

    }

    @PatchMapping("/teachers/{id}")
    public ResponseEntity<String> updateTeacher(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Teacher toUpdate = teacherService.findTeacher(Long.valueOf(id));
        String name = jsonObjectRequest.getString("name").trim();
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        toUpdate.setName(name);
        toUpdate.setUsername(username);
        toUpdate.setPassword(password);
        Lessongroup lessongroup = lessongroupService.findLessongroup(Long.valueOf(groupid));
        toUpdate.setGroupid(lessongroup);
        teacherService.updateTeacher(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<String> DeleteTeacher(@PathVariable String id){
        Teacher toDelete = teacherService.findTeacher(Long.valueOf(id));
        teacherService.deleteTeacher(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(){
       return teacherService.getAllTeachers();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getLessongroupByID(@PathVariable String id) {
        Teacher toShow = teacherService.findTeacher(Long.valueOf(id));
        return toShow;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason = "ID Not Found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //nothing to do
    }

//    @PostMapping("/schoolPortal")
//    //@ResponseStatus(HttpStatus.CREATED)
//    public Tteacher CreateNewProduct(@RequestBody Tteacher tteacher){
//        tteachers.add(tteacher);
//        return tteacher;
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
