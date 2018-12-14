package schoolPortal.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolPortal.Model.*;
import schoolPortal.Service.*;
import schoolPortal.util.ResponseProvider;
import schoolPortal.util.Status;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
public class TimetableController implements Serializable {
    private TimetableService timetableService;
    private StudentgroupService studentgroupService;
    private LessonService lessonService;
    private ClassRoomService roomseService;
    private TeacherService teacherService;

    @Autowired
    public void setProductService(TimetableService timetableService,
                                  StudentgroupService studentgroupService,
                                  LessonService lessonService,
                                  ClassRoomService roomseService,
                                  TeacherService teacherService) {
        this.timetableService = timetableService;
        this.studentgroupService = studentgroupService;
        this.lessonService = lessonService;
        this.roomseService = roomseService;
        this.teacherService = teacherService;
    }


    @PostMapping("/timetables")
    public ResponseEntity<String> createTimetable(@RequestBody String req){
        JSONObject jsonObjectRequest = new JSONObject(req);
        System.out.println(jsonObjectRequest);
        Long classid = jsonObjectRequest.getLong("classid");
        Integer day = jsonObjectRequest.getInt("day");
        Integer time = jsonObjectRequest.getInt("time");
        Long teacherid = jsonObjectRequest.getLong("teacherid");
        Long studentgroupid = jsonObjectRequest.getLong("studentgroupid");
        Long lessonID = jsonObjectRequest.getLong("lessonid");
        Classroom room = roomseService.findClassroom(classid);
        Teacher teacher = teacherService.findTeacher(teacherid);
        Studentgroup stdGp = studentgroupService.findStudentgroup(studentgroupid);
        Lesson lesson = lessonService.findLesson(lessonID);
        Timetable timetable= new Timetable(day,time,stdGp,lesson,teacher,room);
        timetableService.saveTimetable(timetable);
        return returnResponse(Status.OK);
    }

    @PatchMapping("/timetables/{id}")
    public ResponseEntity<String> updateTimetable(@RequestBody String req, @PathVariable String id){
        JSONObject jsonObjectRequest = new JSONObject(req);
        Timetable toUpdate = timetableService.findTimetable(Long.valueOf(id));
        String mark = jsonObjectRequest.getString("mark").trim();
        String studentID = jsonObjectRequest.getString("studentid").trim();
        String lessonID = jsonObjectRequest.getString("lessonid").trim();
//        Student student = studentService.findStudent(Long.valueOf(studentID));
        Lesson lesson = lessonService.findLesson(Long.valueOf(lessonID));
        toUpdate.setLessonid(lesson);
        timetableService.updateTimetable(toUpdate);
        return returnResponse(Status.OK);
    }

    @DeleteMapping("/timetables/{id}")
    public ResponseEntity<String> DeleteTimetable(@PathVariable String id){
        Timetable toDelete = timetableService.findTimetable(Long.valueOf(id));
        timetableService.deleteTimetable(toDelete);
        return returnResponse(Status.OK);
    }

    @GetMapping("/timetables")
    public List<Timetable> getTimetable(){
       return timetableService.getAllTimetables();
    }

    @GetMapping("/timetables/{id}")
    public Timetable getTimetableByID(@PathVariable String id) {
        Timetable toShow = timetableService.findTimetable(Long.valueOf(id));
        return toShow;
    }

    @GetMapping("/timetables/{id}/student")
    public List<Timetable> getTimetableByStudentID(@PathVariable String id) {
        List<Timetable> toShow = timetableService.findByStudentID(Long.valueOf(id));
        return toShow;
    }

    @GetMapping("/timetables/{id}/lesson")
    public List<Timetable> getTimetableByLessonID(@PathVariable String id) {
        List<Timetable> toShow = timetableService.findByLessonID(Long.valueOf(id));
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
//        ttimetables.add(tstudent);
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
