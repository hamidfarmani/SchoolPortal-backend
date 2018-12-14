package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Grade;

import java.util.List;

public interface GradeService {
    public Grade saveGrade(Grade grade);
    public Grade updateGrade(Grade grade);
    public void deleteGrade(Grade grade);
    public Grade findGrade(Long ID);
    public List<Grade> getAllGrades();
    public List<Grade> findByStudentID(Long studentID);
    public List<Grade> findByLessonID(Long lessonID);
}
