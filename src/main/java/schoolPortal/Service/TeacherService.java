package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher saveTeacher(Teacher teacher);
    public Teacher updateTeacher(Teacher teacher);
    public void deleteTeacher(Teacher teacher);
    public Teacher findTeacher(String username, String password);
    public Teacher findTeacher(Long ID);
    public List<Teacher> getAllTeachers();
}
