package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Timetable;

import java.util.List;

public interface TimetableService {
    public Timetable saveTimetable(Timetable timetable);
    public Timetable updateTimetable(Timetable timetable);
    public void deleteTimetable(Timetable timetable);
    public Timetable findTimetable(Long ID);
    public List<Timetable> getAllTimetables();
    public List<Timetable> findByStudentID(Long studentID);
    public List<Timetable> findByLessonID(Long lessonID);
}
