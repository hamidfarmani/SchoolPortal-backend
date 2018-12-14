package schoolPortal.Model;

import javax.persistence.*;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Student {

    public Student() {
    }

    public Student(String name, String username, String password, Studentgroup groupid) {
        this.name = name;
        this.username = username;
        this.password = password;
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
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "groupid", referencedColumnName = "id")
    private Studentgroup groupid;


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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (username != null ? !username.equals(student.username) : student.username != null) return false;
        if (password != null ? !password.equals(student.password) : student.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }


    public Studentgroup getGroupid() {
        return groupid;
    }

    public void setGroupid(Studentgroup groupid) {
        this.groupid = groupid;
    }
}
