package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Timetable;
import schoolPortal.repositories.TimetableRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class TimetableServiceImpl implements TimetableService {


    @Autowired
    private TimetableRepository timetableRepository;

    public Timetable saveTimetable(Timetable timetable) {
        Timetable res = timetableRepository.save(timetable);
        return res;
    }

    public Timetable updateTimetable(Timetable timetable) {
        Timetable res = timetableRepository.save(timetable);
        return res;
    }

    public Timetable findTimetable(Long ID){
        Timetable res = timetableRepository.findById(ID);
        return res;
    }

    public void deleteTimetable(Timetable timetable){
        timetableRepository.delete(timetable);
    }

    public List<Timetable> getAllTimetables(){
        List<Timetable> all = timetableRepository.findAll();
        return all;
    }

    public List<Timetable> findByStudentID(Long studentID){
        List<Timetable> res = timetableRepository.findByStudentId(studentID);
        return res;
    }

    public List<Timetable> findByLessonID(Long lessonID){
        List<Timetable> res = timetableRepository.findByLessonId(lessonID);
        return res;
    }
}
