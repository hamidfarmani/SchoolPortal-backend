package schoolPortal.Model;

import javax.persistence.*;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Comment {
    public Comment() {
    }

    public Comment(String description, Student studentid, Lesson lessonid) {
        this.description = description;
        this.studentid = studentid;
        this.lessonid = lessonid;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "description")
    private String description;

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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (description != null ? !description.equals(comment.description) : comment.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
