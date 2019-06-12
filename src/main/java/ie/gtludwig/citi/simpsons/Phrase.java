package ie.gtludwig.citi.simpsons;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "simpsons_phrase")
public class Phrase extends BasePojo {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "character", nullable = false)
    private Character character;

    private String phrase;

    public Phrase() {}

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
