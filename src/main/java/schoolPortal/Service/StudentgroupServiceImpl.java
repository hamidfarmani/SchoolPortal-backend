package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Studentgroup;
import schoolPortal.repositories.StudentGroupRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class StudentgroupServiceImpl implements StudentgroupService {


    @Autowired
    private StudentGroupRepository studentgeroupRepository;

    public List<Studentgroup> getAllUsers() {
        return studentgeroupRepository.findAll();
    }


    public Studentgroup saveStudentgroup(Studentgroup student) {
        Studentgroup res = studentgeroupRepository.save(student);
        return res;
    }

    public Studentgroup updateStudentgroup(Studentgroup student) {
        Studentgroup res = studentgeroupRepository.save(student);
        return res;
    }

    public Studentgroup findStudentgroup(Long ID){
        Studentgroup res = studentgeroupRepository.findById(ID);
        return res;
    }

    public void deleteStudentgroup(Studentgroup student){
        studentgeroupRepository.delete(student);
    }
    public List<Studentgroup> getAllStudentgroups(){
        List<Studentgroup> all = studentgeroupRepository.findAll();
        return all;
    }
}
