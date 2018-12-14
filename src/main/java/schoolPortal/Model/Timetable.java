package schoolPortal.Model;

import javax.persistence.*;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Timetable {

    public Timetable() {
    }

    public Timetable(Integer day,
                     Integer time,
                     Studentgroup studentgroupid,
                     Lesson lessonid,
                     Teacher teacherid, Classroom classid) {
        this.day = day;
        this.time = time;
        this.studentgroupid = studentgroupid;
        this.lessonid = lessonid;
        this.teacherid = teacherid;
        this.classid = classid;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "day")
    private Integer day;

    @Basic
    @Column(name = "time")
    private Integer time;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "studentgroupid", referencedColumnName = "id")
    private Studentgroup studentgroupid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "lessonid", referencedColumnName = "id")
    private Lesson lessonid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "teacherid", referencedColumnName = "id")
    private Teacher teacherid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "classid", referencedColumnName = "id")
    private Classroom classid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }


    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timetable timetable = (Timetable) o;

        if (id != null ? !id.equals(timetable.id) : timetable.id != null) return false;
        if (day != null ? !day.equals(timetable.day) : timetable.day != null) return false;
        if (time != null ? !time.equals(timetable.time) : timetable.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    public Studentgroup getStudentgroupid() {
        return studentgroupid;
    }

    public void setStudentgroupid(Studentgroup studentgroupid) {
        this.studentgroupid = studentgroupid;
    }

    public Lesson getLessonid() {
        return lessonid;
    }

    public void setLessonid(Lesson lessonid) {
        this.lessonid = lessonid;
    }

    public Teacher getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Teacher teacherid) {
        this.teacherid = teacherid;
    }

    public Classroom getClassid() {
        return classid;
    }

    public void setClassid(Classroom classid) {
        this.classid = classid;
    }
}
