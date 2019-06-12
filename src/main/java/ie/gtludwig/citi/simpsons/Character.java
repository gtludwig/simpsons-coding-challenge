package ie.gtludwig.citi.simpsons;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.net.URL;
import java.util.Set;

@Entity
@Table(name = "simpsons_character")
public class Character extends BasePojo{

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private URL picture;

    private int age;

    @OneToMany(mappedBy = "character")
    private Set<Phrase> phraseSet;

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

    public Set<Phrase> getPhraseSet() {
        return phraseSet;
    }

    public void setPhraseSet(Set<Phrase> phraseSet) {
        this.phraseSet = phraseSet;
    }
}
