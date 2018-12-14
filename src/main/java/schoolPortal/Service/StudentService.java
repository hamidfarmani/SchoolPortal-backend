package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(Student student);
    public Student findStudent(Long ID);
    public Student findStudent(String username, String password);
    public List<Student> getAllStudents();
}
