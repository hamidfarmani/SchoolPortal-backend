package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Studentgroup;
import schoolPortal.Service.StudentgroupService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class StudnetgroupController implements Serializable {
    private StudentgroupService studentgroupService;

    @Autowired
    public void setProductService(StudentgroupService studentgroupService) {
        this.studentgroupService = studentgroupService;
    }


    @PostMapping("/studentgroups")
    public ResponseEntity<String> createStudentgroup(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String name = jsonObjectRequest.getString("name").trim();
        Studentgroup studentgroup= new Studentgroup(name);
        studentgroupService.saveStudentgroup(studentgroup);
        return returnResponse(Status.OK);
    }

    @PatchMapping("/studentgroups/{id}")
    public ResponseEntity<String> updateStudentgroup(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Studentgroup toUpdate = studentgroupService.findStudentgroup(Long.valueOf(id));
        String name = jsonObjectRequest.getString("name").trim();
        toUpdate.setName(name);
        studentgroupService.updateStudentgroup(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/studentgroups/{id}")
    public ResponseEntity<String> DeleteStudentgroup(@PathVariable String id){
        Studentgroup toDelete = studentgroupService.findStudentgroup(Long.valueOf(id));
        studentgroupService.deleteStudentgroup(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/studentgroups")
    public List<Studentgroup> getStudentgroups(){
       return studentgroupService.getAllStudentgroups();
    }

    @GetMapping("/studentgroups/{id}")
    public Studentgroup getStudentgroups(@PathVariable String id) {
        System.out.println("**** : " + id);
        Studentgroup toShow = studentgroupService.findStudentgroup(Long.valueOf(id));
        return toShow;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason = "ID Not Found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //nothing to do
    }

//    @PostMapping("/schoolPortal")
//    //@ResponseStatus(HttpStatus.CREATED)
//    public Tstudentgroup CreateNewProduct(@RequestBody Tstudentgroup tstudentgroup){
//        tstudentgroups.add(tstudentgroup);
//        return tstudentgroup;
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
