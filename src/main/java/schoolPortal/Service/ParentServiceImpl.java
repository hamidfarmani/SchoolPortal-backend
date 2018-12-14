package schoolPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolPortal.Model.Parent;
import schoolPortal.repositories.ParentRepository;

import java.util.List;

/**
 * Created by Hamid on 10/26/2018.
 */

@Service
public class ParentServiceImpl implements ParentService {


    @Autowired
    private ParentRepository parentRepository;

    public List<Parent> getAllUsers() {
        return parentRepository.findAll();
    }


    public Parent saveParent(Parent parent) {
        Parent res = parentRepository.save(parent);
        return res;
    }

    public Parent updateParent(Parent parent) {
        Parent res = parentRepository.save(parent);
        return res;
    }

    public Parent findParent(Long ID){
        Parent res = parentRepository.findById(ID);
        return res;
    }
    public Parent findParent(String username,String password){
        Parent res = parentRepository.findByUsernameAndAndPassword(username,password);
        return res;
    }
    public List<Parent> findParentByStudentID(Long studentID){
        List<Parent> res = parentRepository.findByStudentId(studentID);
        return res;
    }

    public void deleteParent(Parent parent){
        parentRepository.delete(parent);
    }
    public List<Parent> getAllParents(){
        List<Parent> all = parentRepository.findAll();
        return all;
    }
}
