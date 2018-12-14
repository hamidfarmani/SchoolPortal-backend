package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Lesson;
import schoolPortal.Model.Lessongroup;
import schoolPortal.Service.LessonService;
import schoolPortal.Service.LessongroupService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class LessonController implements Serializable {
    private LessonService lessonService;
    private LessongroupService lessongroupService;

    @Autowired
    public void setProductService(LessonService lessonService, LessongroupService lessongroupService) {
        this.lessonService = lessonService;
        this.lessongroupService = lessongroupService;
    }


    @PostMapping("/lessons")
    public ResponseEntity<String> createLesson(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String name = jsonObjectRequest.getString("name").trim();
        String unit = jsonObjectRequest.getString("unit").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        Lessongroup lessongroup = lessongroupService.findLessongroup(Long.valueOf(groupid));
        Lesson lesson= new Lesson(name,Integer.valueOf(unit),lessongroup);
        lessonService.saveLesson(lesson);
        return returnResponse(Status.OK);
    }

    @PatchMapping("/lessons/{id}")
    public ResponseEntity<String> updateLesson(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Lesson toUpdate = lessonService.findLesson(Long.valueOf(id));
        String name = jsonObjectRequest.getString("name").trim();
        String unit = jsonObjectRequest.getString("unit").trim();
        String groupid = jsonObjectRequest.getString("groupid").trim();
        toUpdate.setName(name);
        toUpdate.setUnit(Integer.valueOf(unit));
        Lessongroup lessongroup = lessongroupService.findLessongroup(Long.valueOf(groupid));
        toUpdate.setGroupid(lessongroup);
        lessonService.updateLesson(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/lessons/{id}")
    public ResponseEntity<String> DeleteLesson(@PathVariable String id){
        Lesson toDelete = lessonService.findLesson(Long.valueOf(id));
        lessonService.deleteLesson(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/lessons")
    public List<Lesson> getLessons(){
       return lessonService.getAllLessons();
    }

    @GetMapping("/lessons/{id}")
    public Lesson getLessongroupByID(@PathVariable String id) {
        Lesson toShow = lessonService.findLesson(Long.valueOf(id));
        return toShow;
    }




    @ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason = "ID Not Found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //nothing to do
    }

//    @PostMapping("/schoolPortal")
//    //@ResponseStatus(HttpStatus.CREATED)
//    public Tlesson CreateNewProduct(@RequestBody Tlesson tlesson){
//        tlessons.add(tlesson);
//        return tlesson;
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
