package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Teacher;
import schoolPortal.repositories.TeacherRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllUsers() {
        return teacherRepository.findAll();
    }


    public Teacher saveTeacher(Teacher teacher) {
        Teacher res = teacherRepository.save(teacher);
        return res;
    }

    public Teacher updateTeacher(Teacher teacher) {
        Teacher res = teacherRepository.save(teacher);
        return res;
    }

    public Teacher findTeacher(Long ID){
        Teacher res = teacherRepository.findById(ID);
        return res;
    }

    public Teacher findTeacher(String username,String password){
        Teacher res = teacherRepository.findByUsernameAndAndPassword(username,password);
        return res;
    }

    public void deleteTeacher(Teacher teacher){
        teacherRepository.delete(teacher);
    }
    public List<Teacher> getAllTeachers(){
        List<Teacher> all = teacherRepository.findAll();
        return all;
    }
}
