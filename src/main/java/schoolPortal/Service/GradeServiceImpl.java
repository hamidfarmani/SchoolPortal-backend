package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Grade;
import schoolPortal.repositories.GradeRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class GradeServiceImpl implements GradeService {


    @Autowired
    private GradeRepository gradeRepository;

    public Grade saveGrade(Grade grade) {
        Grade res = gradeRepository.save(grade);
        return res;
    }

    public Grade updateGrade(Grade grade) {
        Grade res = gradeRepository.save(grade);
        return res;
    }

    public Grade findGrade(Long ID){
        Grade res = gradeRepository.findById(ID);
        return res;
    }

    public void deleteGrade(Grade grade){
        gradeRepository.delete(grade);
    }

    public List<Grade> getAllGrades(){
        List<Grade> all = gradeRepository.findAll();
        return all;
    }

    public List<Grade> findByStudentID(Long studentID){
        List<Grade> res = gradeRepository.findByStudentId(studentID);
        return res;
    }

    public List<Grade> findByLessonID(Long lessonID){
        List<Grade> res = gradeRepository.findByLessonId(lessonID);
        return res;
    }
}
