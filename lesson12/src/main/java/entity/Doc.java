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

    public Doc(String name, String surname, Date birthDate, String phoneNr) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNr = phoneNr;
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
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Doc doc = (Doc) o;

        if (name != null ? !name.equals(doc.name) : doc.name != null)
        {
            return false;
        }
        if (surname != null ? !surname.equals(doc.surname) : doc.surname != null)
        {
            return false;
        }
        return phoneNr != null ? phoneNr.equals(doc.phoneNr) : doc.phoneNr == null;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phoneNr != null ? phoneNr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNr='" + phoneNr + '\'' + "\n" +
                ", petList=" + petList +
                '}' + "\n";
    }
}
