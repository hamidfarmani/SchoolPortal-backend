package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Lessongroup;
import schoolPortal.Service.LessongroupService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class LessongroupController implements Serializable {
    private LessongroupService lessongroupService;

    @Autowired
    public void setProductService(LessongroupService lessongroupService) {
        this.lessongroupService = lessongroupService;
    }


    @PostMapping("/lessongroups")
    public ResponseEntity<String> createLessongroup(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String name = jsonObjectRequest.getString("name").trim();
        Lessongroup lessongroup= new Lessongroup(name);
        lessongroupService.saveLessongroup(lessongroup);
        return returnResponse(Status.OK);
    }

    @PatchMapping("/lessongroups/{id}")
    public ResponseEntity<String> updateLessongroup(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Lessongroup toUpdate = lessongroupService.findLessongroup(Long.valueOf(id));
        String name = jsonObjectRequest.getString("name").trim();
        toUpdate.setName(name);
        lessongroupService.updateLessongroup(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/lessongroups/{id}")
    public ResponseEntity<String> DeleteLessongroup(@PathVariable String id){
        Lessongroup toDelete = lessongroupService.findLessongroup(Long.valueOf(id));
        lessongroupService.deleteLessongroup(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/lessongroups")
    public List<Lessongroup> getLessongroups(){
       return lessongroupService.getAllLessongroups();
    }

    @GetMapping("/lessongroups/{id}")
    public Lessongroup getLessongroups(@PathVariable String id) {
        System.out.println("**** : " + id);
        Lessongroup toShow = lessongroupService.findLessongroup(Long.valueOf(id));
        return toShow;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason = "ID Not Found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //nothing to do
    }

//    @PostMapping("/schoolPortal")
//    //@ResponseStatus(HttpStatus.CREATED)
//    public Tlessongroup CreateNewProduct(@RequestBody Tlessongroup tlessongroup){
//        tlessongroups.add(tlessongroup);
//        return tlessongroup;
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
