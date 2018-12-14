package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Parent;
import schoolPortal.Model.Student;
import schoolPortal.Model.Studentgroup;
import schoolPortal.Service.StudentService;
import schoolPortal.Service.ParentService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class ParentController implements Serializable {
    private StudentService studentService;
    private ParentService parentService;

    @Autowired
    public void setProductService(StudentService studentService, ParentService parentService) {
        this.studentService = studentService;
        this.parentService = parentService;
    }


    @PostMapping("/parents")
    public ResponseEntity<String> createParent(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String name = jsonObjectRequest.getString("name").trim();
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        String phonenumber = jsonObjectRequest.getString("phonenumber").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        Student student = studentService.findStudent(Long.valueOf(groupid));
        Parent parent= new Parent(name,username,password,phonenumber,student);
        parentService.saveParent(parent);
        return returnResponse(Status.OK);
    }

    @PostMapping("/parents/find")
    public ResponseEntity<String> findParentByUserPass(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        Parent parent = parentService.findParent(username, password);
        if(parent!=null) {
            JSONObject returnValue = new JSONObject();
            returnValue.put("name", parent.getName());
            return returnResponse(Status.OK,returnValue);
        }else {
            return returnResponse(Status.NOT_FOUND);
        }

    }

    @PatchMapping("/parents/{id}")
    public ResponseEntity<String> updateParent(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Parent toUpdate = parentService.findParent(Long.valueOf(id));
        String name = jsonObjectRequest.getString("name").trim();
        String username = jsonObjectRequest.getString("username").trim();
        String password = jsonObjectRequest.getString("password").trim();
        String phonenumber = jsonObjectRequest.getString("phonenumber").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        toUpdate.setName(name);
        toUpdate.setUsername(username);
        toUpdate.setPassword(password);
        toUpdate.setPhonenumber(phonenumber);
        Student student = studentService.findStudent(Long.valueOf(groupid));
        toUpdate.setStudentid(student);
        parentService.updateParent(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/parents/{id}")
    public ResponseEntity<String> DeleteParent(@PathVariable String id){
        Parent toDelete = parentService.findParent(Long.valueOf(id));
        parentService.deleteParent(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/parents")
    public List<Parent> getParent(){
       return parentService.getAllParents();
    }

    @GetMapping("/parents/{id}")
    public Parent getParentByID(@PathVariable String id) {
        Parent toShow = parentService.findParent(Long.valueOf(id));
        return toShow;
    }

    @GetMapping("/parents/{id}/student")
    public List<Parent> getParentByStudentID(@PathVariable String id) {
        List<Parent> toShow = parentService.findParentByStudentID(Long.valueOf(id));
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
//        tparents.add(tstudent);
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
