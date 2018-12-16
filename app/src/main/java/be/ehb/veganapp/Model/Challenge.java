package be.ehb.veganapp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Challenge {

    // ID die de challenge onderscheid van de rest
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "challenge_id")
    private int challengeId;

    // Beschrijvende NAAM van de challenge
    @ColumnInfo(name = "naam")
    private String naam;

    // Korte BESCHRIJVING die de gebruiker een inleiding geeft
    @ColumnInfo(name = "beschrijving")
    private String beschrijving;

    // Welk LEVEL/moeilijkheidsgraad hoort deze challenge bij?
    @ColumnInfo(name = "level")
    private int level;

    // Hoeveel ERVARING/EXPERIENCE punten de speler krijgt wanneer de uitdaging voltooid is
    @ColumnInfo(name = "ervaring")
    private int ervaring;

    // De verschillende CATEGORIE zijn: milieu, beweging, voeiding
    @ColumnInfo(name = "categorie")
    private String categorie;

    // DAG waarop de challenge ingepland is
    @ColumnInfo(name = "dag")
    private int dag;

    // boolean die aangeeft of het een quickChallenge is, of een "normale" challenge
    @ColumnInfo(name = "is_quick_challenge")
    private boolean isQuickChallenge;

    // De informatie die de gebruiker nodig heeft om effectief aan de slag te gaan met de challenge
    @ColumnInfo(name = "how_to")
    private String howTo;

    //Getter, Setter
    @NonNull
    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(@NonNull int challengeId) {
        this.challengeId = challengeId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getErvaring() {
        return ervaring;
    }

    public void setErvaring(int ervaring) {
        this.ervaring = ervaring;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getDag() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }

    public boolean isQuickChallenge() {
        return isQuickChallenge;
    }

    public void setQuickChallenge(boolean quickChallenge) {
        isQuickChallenge = quickChallenge;
    }

    public String getHowTo() {
        return howTo;
    }

    public void setHowTo(String howTo) {
        this.howTo = howTo;
    }

    // Constructor
    public Challenge(String naam, String beschrijving, int level, int ervaring, String categorie, int dag, boolean isQuickChallenge, String howTo) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.level = level;
        this.ervaring = ervaring;
        this.categorie = categorie;
        this.dag = dag;
        this.isQuickChallenge = isQuickChallenge;
        this.howTo = howTo;
    }
}
