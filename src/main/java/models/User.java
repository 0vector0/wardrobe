package models;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User extends Model {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;

    private String userName;

    private String password1;

    private String email;

    private String phone;

    private String city;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


    public User() {
    }

    public User(Long id) {
        super(id);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}