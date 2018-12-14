package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Lesson;
import schoolPortal.repositories.LessonRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class LessonServiceImpl implements LessonService {


    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllUsers() {
        return lessonRepository.findAll();
    }


    public Lesson saveLesson(Lesson lesson) {
        Lesson res = lessonRepository.save(lesson);
        return res;
    }

    public Lesson updateLesson(Lesson lesson) {
        Lesson res = lessonRepository.save(lesson);
        return res;
    }

    public Lesson findLesson(Long ID){
        Lesson res = lessonRepository.findById(ID);
        return res;
    }

    public void deleteLesson(Lesson lesson){
        lessonRepository.delete(lesson);
    }
    public List<Lesson> getAllLessons(){
        List<Lesson> all = lessonRepository.findAll();
        return all;
    }
}
