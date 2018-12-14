package schoolPortal.Model;

import javax.persistence.*;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Lesson {
    public Lesson() {
    }

    public Lesson(String name, Integer unit, Lessongroup groupid) {
        this.name = name;
        this.unit = unit;
        this.groupid = groupid;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "unit")
    private Integer unit;




    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "groupid", referencedColumnName = "id")
    private Lessongroup groupid;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        if (id != null ? !id.equals(lesson.id) : lesson.id != null) return false;
        if (name != null ? !name.equals(lesson.name) : lesson.name != null) return false;
        if (unit != null ? !unit.equals(lesson.unit) : lesson.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }


    public Lessongroup getGroupid() {
        return groupid;
    }

    public void setGroupid(Lessongroup groupid) {
        this.groupid = groupid;
    }
}
