package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Parent;

import java.util.List;

public interface ParentService {
    public Parent saveParent(Parent parent);
    public Parent updateParent(Parent parent);
    public void deleteParent(Parent parent);
    public Parent findParent(Long ID);
    public Parent findParent(String username, String password);
    public List<Parent> findParentByStudentID(Long studentID);
    public List<Parent> getAllParents();
}
