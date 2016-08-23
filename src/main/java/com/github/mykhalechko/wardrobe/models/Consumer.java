package com.github.mykhalechko.wardrobe.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "consumer")
public class Consumer extends Model  {

    @Column(name = "email", length=50, nullable=false)
    private String email;

    @Column(name = "password", length=50, nullable=false)
    private String password;

    @Column(name = "first_name", length=50, nullable=false)
    private String firstName;

    @Column(name = "second_name", length=50)
    private String secondName;


    @Column(name= "birthday")
    @Type(type="date")
    private Date birthday;

    @OneToMany(mappedBy="consumer", fetch = FetchType.LAZY)
    private Set<Item> items = new HashSet<Item>();

    @OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY)
    private Set<Day> days = new HashSet<Day>();


    public Consumer() {
    }

    public Consumer(Long id) {
        super(id);
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}