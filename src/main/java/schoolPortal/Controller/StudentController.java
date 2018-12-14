package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Student;
import schoolPortal.Model.Studentgroup;
import schoolPortal.Service.StudentService;
import schoolPortal.Service.StudentgroupService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class StudentController implements Serializable {
    private StudentService studentService;
    private StudentgroupService studentgroupService;

    @Autowired
    public void setProductService(StudentService studentService, StudentgroupService studentgroupService) {
        this.studentService = studentService;
        this.studentgroupService = studentgroupService;
    }


    @PostMapping("/students")
    public ResponseEntity<String> createStudent(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String name = jsonObjectRequest.getString("name").trim();
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        Studentgroup studentgroup = studentgroupService.findStudentgroup(Long.valueOf(groupid));
        Student student= new Student(name,username,password,studentgroup);
        studentService.saveStudent(student);
        return returnResponse(Status.OK);
    }

    @PostMapping("/students/find")
    public ResponseEntity<String> findStudentByUserPass(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        Student student = studentService.findStudent(username, password);
        if(student!=null) {
            JSONObject returnValue = new JSONObject();
            returnValue.put("name", student.getName());
            return returnResponse(Status.OK,returnValue);
        }else {
            return returnResponse(Status.NOT_FOUND);
        }

    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Student toUpdate = studentService.findStudent(Long.valueOf(id));
        String name = jsonObjectRequest.getString("name").trim();
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        toUpdate.setName(name);
        toUpdate.setUsername(username);
        toUpdate.setPassword(password);
        Studentgroup studentgroup = studentgroupService.findStudentgroup(Long.valueOf(groupid));
        toUpdate.setGroupid(studentgroup);
        studentService.updateStudent(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> DeleteStudent(@PathVariable String id){
        Student toDelete = studentService.findStudent(Long.valueOf(id));
        studentService.deleteStudent(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
       return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentgroupByID(@PathVariable String id) {
        Student toShow = studentService.findStudent(Long.valueOf(id));
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
//        tstudents.add(tstudent);
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
