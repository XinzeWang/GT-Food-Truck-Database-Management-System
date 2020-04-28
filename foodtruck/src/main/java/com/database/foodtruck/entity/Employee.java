package com.database.foodtruck.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee", uniqueConstraints = {@UniqueConstraint(columnNames={"email"})})
public class Employee {
    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private User user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
