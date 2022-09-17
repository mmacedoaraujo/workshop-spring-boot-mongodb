package com.mmacedoaraujo.coursespringboot.dto;

import com.mmacedoaraujo.coursespringboot.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO() {

    }

    public AuthorDTO(User userObj) {
        this.id = userObj.getId();
        this.name = userObj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
