package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Classroom;
import schoolPortal.repositories.ClassRoomRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class ClassRoomServiceImpl implements ClassRoomService {


    @Autowired
    private ClassRoomRepository classRoomRepository;

    public List<Classroom> getAllUsers() {
        return classRoomRepository.findAll();
    }


    public Classroom saveClassroom(Classroom lesson) {
        Classroom res = classRoomRepository.save(lesson);
        return res;
    }

    public Classroom updateClassroom(Classroom lesson) {
        Classroom res = classRoomRepository.save(lesson);
        return res;
    }

    public Classroom findClassroom(Long ID){
        Classroom res = classRoomRepository.findById(ID);
        return res;
    }

    public void deleteClassroom(Classroom lesson){
        classRoomRepository.delete(lesson);
    }
    public List<Classroom> getAllClassrooms(){
        List<Classroom> all = classRoomRepository.findAll();
        return all;
    }
}
