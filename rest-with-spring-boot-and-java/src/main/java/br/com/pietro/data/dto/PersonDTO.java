package br.com.pietro.data.dto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1l;
    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String gender;

    public PersonDTO() {};

    // getters
    public Long getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAdress(){
        return this.adress;
    }
    public String getGender(){
        return this.gender;
    }

    // setters
    public void setId(Long id){
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTO person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getAdress(), person.getAdress()) && Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAdress(), getGender());
    }
}
