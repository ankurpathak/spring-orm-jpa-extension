package com.github.ankurpathak.springframework.orm.jpa.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(unique = true)
    private String email;
    private String name;





    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User id(BigInteger id) {
        this.id = id;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }
}
