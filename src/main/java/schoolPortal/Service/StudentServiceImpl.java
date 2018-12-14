package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Student;
import schoolPortal.repositories.StudentRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllUsers() {
        return studentRepository.findAll();
    }


    public Student saveStudent(Student student) {
        Student res = studentRepository.save(student);
        return res;
    }

    public Student updateStudent(Student student) {
        Student res = studentRepository.save(student);
        return res;
    }

    public Student findStudent(Long ID){
        Student res = studentRepository.findById(ID);
        return res;
    }

    public Student findStudent(String username,String password){
        Student res = studentRepository.findByUsernameAndAndPassword(username,password);
        return res;
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
    public List<Student> getAllStudents(){
        List<Student> all = studentRepository.findAll();
        return all;
    }
}
