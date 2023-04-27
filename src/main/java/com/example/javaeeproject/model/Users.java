package com.example.javaeeproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id @Column(name = "id") private int id;
    @Column(name = "email") private String email;
    @Column(name = "password") private String password;
    @Column(name = "full_name") private String full_name;

    public Users() {
    }

    public Users(int id, String email, String password, String full_name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
