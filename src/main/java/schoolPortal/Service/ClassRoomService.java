package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Classroom;

import java.util.List;

public interface ClassRoomService {
    public Classroom saveClassroom(Classroom classroom);
    public Classroom updateClassroom(Classroom classroom);
    public void deleteClassroom(Classroom classroom);
    public Classroom findClassroom(Long ID);
    public List<Classroom> getAllClassrooms();
}
