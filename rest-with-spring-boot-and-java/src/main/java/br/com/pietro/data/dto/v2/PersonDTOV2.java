package br.com.pietro.data.dto.v2;

import java.io.Serializable;
import java.util.Date;

public class PersonDTOV2 implements Serializable {

    private static final long serialVersionUID = 1l;
    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String gender;
    private Date birthDay;

    public PersonDTOV2() {};

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
    public Date getBirthDay() { return birthDay; }

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
    public void setBirthDay(Date birthDay) {this.birthDay = birthDay;}



}
