package schoolPortal.Service;

/**
 * Created by Hamid on 10/26/2018.
 */

import schoolPortal.Model.Studentgroup;

import java.util.List;

public interface StudentgroupService {
    public Studentgroup saveStudentgroup(Studentgroup student);
    public Studentgroup updateStudentgroup(Studentgroup student);
    public void deleteStudentgroup(Studentgroup student);
    public Studentgroup findStudentgroup(Long ID);
    public List<Studentgroup> getAllStudentgroups();
}
