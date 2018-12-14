package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Lessongroup;
import schoolPortal.repositories.LessonGroupRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class LessongroupServiceImpl implements LessongroupService {


    @Autowired
    private LessonGroupRepository lessonGroupRepository;

    public List<Lessongroup> getAllUsers() {
        return lessonGroupRepository.findAll();
    }


    public Lessongroup saveLessongroup(Lessongroup lesson) {
        Lessongroup res = lessonGroupRepository.save(lesson);
        return res;
    }

    public Lessongroup updateLessongroup(Lessongroup lesson) {
        Lessongroup res = lessonGroupRepository.save(lesson);
        return res;
    }

    public Lessongroup findLessongroup(Long ID){
        Lessongroup res = lessonGroupRepository.findById(ID);
        return res;
    }

    public void deleteLessongroup(Lessongroup lesson){
        lessonGroupRepository.delete(lesson);
    }
    public List<Lessongroup> getAllLessongroups(){
        List<Lessongroup> all = lessonGroupRepository.findAll();
        return all;
    }
}
