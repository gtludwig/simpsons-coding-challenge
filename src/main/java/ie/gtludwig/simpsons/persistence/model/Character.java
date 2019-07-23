package ie.gtludwig.simpsons.persistence.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.net.URL;
import java.util.List;

@Entity
@Table(name = "character")
public class Character extends BasePojo{

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private URL picture;

    private int age;

    @OneToMany(mappedBy = "character", fetch = FetchType.EAGER)
    private List<Phrase> phraseList ;

    public Character() {
    }

    public Character(String firstName, String lastName, URL picture, int age, List<Phrase> phraseList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.age = age;
        this.phraseList = phraseList;
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

    public URL getPicture() {
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Phrase> getPhraseList() {
        return phraseList;
    }

    public void setPhraseList(List<Phrase> phraseList) {
        this.phraseList = phraseList;
    }
}
