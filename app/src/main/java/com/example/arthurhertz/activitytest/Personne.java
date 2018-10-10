package com.example.arthurhertz.activitytest;

import java.io.Serializable;

public class Personne implements Serializable {
    private String lastName;
    private String firstName;

    public Personne(String lName, String fName){

        lastName = lName;
        firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

