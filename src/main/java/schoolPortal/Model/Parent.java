package schoolPortal.Model;

import javax.persistence.*;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Parent {
    public Parent() {
    }

    public Parent(String name, String username, String password, String phonenumber, Student studentid) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.studentid = studentid;
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

    @Basic
    @Column(name = "phonenumber")
    private String phonenumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "studentid", referencedColumnName = "id")
    private Student studentid;


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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (id != null ? !id.equals(parent.id) : parent.id != null) return false;
        if (name != null ? !name.equals(parent.name) : parent.name != null) return false;
        if (username != null ? !username.equals(parent.username) : parent.username != null) return false;
        if (password != null ? !password.equals(parent.password) : parent.password != null) return false;
        if (phonenumber != null ? !phonenumber.equals(parent.phonenumber) : parent.phonenumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        return result;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }
}
