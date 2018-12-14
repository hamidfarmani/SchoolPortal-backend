package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Lessongroup;

import java.util.List;

public interface LessongroupService {
    public Lessongroup saveLessongroup(Lessongroup lesson);
    public Lessongroup updateLessongroup(Lessongroup lesson);
    public void deleteLessongroup(Lessongroup lesson);
    public Lessongroup findLessongroup(Long ID);
    public List<Lessongroup> getAllLessongroups();
}
