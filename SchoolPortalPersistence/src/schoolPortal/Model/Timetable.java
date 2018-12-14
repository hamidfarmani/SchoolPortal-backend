package schoolPortal.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Timetable {
    private Integer id;
    private Integer day;
    private Integer time;
    private Integer studentgroupid;
    private Integer lessonid;
    private Integer teacherid;
    private Integer classid;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "day")
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Basic
    @Column(name = "time")
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

    @Basic
    @Column(name = "studentgroupid")
    public Integer getStudentgroupid() {
        return studentgroupid;
    }

    public void setStudentgroupid(Integer studentgroupid) {
        this.studentgroupid = studentgroupid;
    }

    @Basic
    @Column(name = "lessonid")
    public Integer getLessonid() {
        return lessonid;
    }

    public void setLessonid(Integer lessonid) {
        this.lessonid = lessonid;
    }

    @Basic
    @Column(name = "teacherid")
    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    @Basic
    @Column(name = "classid")
    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}
