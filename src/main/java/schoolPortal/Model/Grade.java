package schoolPortal.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Grade {

    public Grade() {
    }

    public Grade(Integer mark, Date creationdate, Student studentid, Lesson lessonid) {
        this.mark = mark;
        this.creationdate = creationdate;
        this.studentid = studentid;
        this.lessonid = lessonid;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "mark")
    private Integer mark;

    @Basic
    @Column(name = "creationdate")
    private Date creationdate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "studentid", referencedColumnName = "id")
    private Student studentid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "lessonid", referencedColumnName = "id")
    private Lesson lessonid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }


    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (id != null ? !id.equals(grade.id) : grade.id != null) return false;
        if (mark != null ? !mark.equals(grade.mark) : grade.mark != null) return false;
        if (creationdate != null ? !creationdate.equals(grade.creationdate) : grade.creationdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (creationdate != null ? creationdate.hashCode() : 0);
        return result;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Lesson getLessonid() {
        return lessonid;
    }

    public void setLessonid(Lesson lessonid) {
        this.lessonid = lessonid;
    }
}
