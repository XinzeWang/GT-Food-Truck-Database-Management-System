package com.database.foodtruck.entity;

import com.database.foodtruck.vo.LoginResult;

import javax.persistence.*;

/* query 1*/
@NamedStoredProcedureQuery(
        name = "login",
        procedureName = "login",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "userName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "password")
        }
)

@NamedNativeQuery(
        name = "select_login_result",
        query = "SELECT * FROM cs4400spring2020.login_result",
        resultSetMapping = "LoginResultMapping"
)

@SqlResultSetMapping(
        name= "LoginResultMapping",
        classes={
                @ConstructorResult(
                        targetClass= LoginResult.class,
                        columns={
                                @ColumnResult(name="userName", type=String.class),
                                @ColumnResult(name="userType", type=String.class)
                        })})

/* query 2 */
@NamedStoredProcedureQuery(
        name = "register",
        procedureName = "register",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "username"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "email"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "firstname"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "lastname"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "password"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "balance"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "type"),
        }
)

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames={"firstName","lastName"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    private String password;

    public User() {

    }

    public User(String userName, String firstName, String lastName, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
                + password + "]";
    }


}
