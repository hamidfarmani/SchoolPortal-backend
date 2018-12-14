package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.Classroom;
import schoolPortal.Model.Classroom;
import schoolPortal.Service.ClassRoomService;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.List;


@RestController
@CrossOrigin
public class ClassRoomController implements Serializable {
    private ClassRoomService classRoomService;

    @Autowired
    public void setProductService(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }


    @PostMapping("/classRooms")
    public ResponseEntity<String> createClassroom(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        String name = jsonObjectRequest.getString("name").trim();
        Classroom classRoom= new Classroom(name);
        classRoomService.saveClassroom(classRoom);
        return returnResponse(Status.OK);
    }

    @PatchMapping("/classRooms/{id}")
    public ResponseEntity<String> updateClassroom(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Classroom toUpdate = classRoomService.findClassroom(Long.valueOf(id));
        String name = jsonObjectRequest.getString("name").trim();
        toUpdate.setName(name);
        classRoomService.updateClassroom(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/classRooms/{id}")
    public ResponseEntity<String> DeleteClassroom(@PathVariable String id){
        Classroom toDelete = classRoomService.findClassroom(Long.valueOf(id));
        classRoomService.deleteClassroom(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/classRooms")
    public List<Classroom> getClassrooms(){
       return classRoomService.getAllClassrooms();
    }

    @GetMapping("/classRooms/{id}")
    public Classroom getClassrooms(@PathVariable String id) {
        Classroom toShow = classRoomService.findClassroom(Long.valueOf(id));
        return toShow;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason = "ID Not Found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //nothing to do
    }

//    @PostMapping("/schoolPortal")
//    //@ResponseStatus(HttpStatus.CREATED)
//    public TclassRoom CreateNewProduct(@RequestBody TclassRoom tclassRoom){
//        tclassRooms.add(tclassRoom);
//        return tclassRoom;
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
