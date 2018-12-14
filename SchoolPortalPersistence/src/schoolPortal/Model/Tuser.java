package schoolPortal.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Hamid on 11/17/2018.
 */
@Entity
public class Tuser {
    private Long userid;
    private Timestamp creationdate;
    private String email;
    private String firstname;
    private Timestamp lastmodified;
    private String lastname;
    private String password;
    private String phonenumber;
    private String username;

    @Id
    @Column(name = "userid")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "creationdate")
    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastmodified")
    public Timestamp getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Timestamp lastmodified) {
        this.lastmodified = lastmodified;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phonenumber")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuser tuser = (Tuser) o;

        if (userid != null ? !userid.equals(tuser.userid) : tuser.userid != null) return false;
        if (creationdate != null ? !creationdate.equals(tuser.creationdate) : tuser.creationdate != null) return false;
        if (email != null ? !email.equals(tuser.email) : tuser.email != null) return false;
        if (firstname != null ? !firstname.equals(tuser.firstname) : tuser.firstname != null) return false;
        if (lastmodified != null ? !lastmodified.equals(tuser.lastmodified) : tuser.lastmodified != null) return false;
        if (lastname != null ? !lastname.equals(tuser.lastname) : tuser.lastname != null) return false;
        if (password != null ? !password.equals(tuser.password) : tuser.password != null) return false;
        if (phonenumber != null ? !phonenumber.equals(tuser.phonenumber) : tuser.phonenumber != null) return false;
        if (username != null ? !username.equals(tuser.username) : tuser.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (creationdate != null ? creationdate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastmodified != null ? lastmodified.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
