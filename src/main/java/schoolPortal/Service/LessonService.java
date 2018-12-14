package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Lesson;
import schoolPortal.Model.Student;

import java.util.List;

public interface LessonService {
    public Lesson saveLesson(Lesson lesson);
    public Lesson updateLesson(Lesson lesson);
    public void deleteLesson(Lesson lesson);
    public Lesson findLesson(Long ID);
    public List<Lesson> getAllLessons();
}
