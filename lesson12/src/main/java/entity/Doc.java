package entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Vaio on 17.06.19.
 */
public class Doc {
    private long id;
    private String name;
    private String surname;
    private Date birthDate;
    private String phoneNr;
    private List<Pet> petList;

    public Doc(String name, String surname, Date birthDate, String phoneNr, List<Pet> petList) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNr = phoneNr;
        this.petList = petList;
    }

    public Doc(long id, String name, String surname, Date birthDate, String phoneNr, List<Pet> petList) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNr = phoneNr;
        this.petList = petList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNr='" + phoneNr + '\'' +
                ", petList=" + petList +
                '}' + "\n";
    }
}
