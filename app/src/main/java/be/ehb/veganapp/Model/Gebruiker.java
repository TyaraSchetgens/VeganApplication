package be.ehb.veganapp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = GekozenChallenge.class,
                parentColumns = "gekozen_challenge_id",
                childColumns = "gekozen_challenge_id"
        ),

        @ForeignKey(
                entity = VoltooideChallenge.class,
                parentColumns = "voltooide_challenge_id",
                childColumns = "voltooide_challenge_id"
        ),

        @ForeignKey(
                entity = Trofee.class,
                parentColumns = "trofee_id",
                childColumns = "gewonnen_trofee_id"
        )
})
public class Gebruiker {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "gebruiker_id")
    private int gebruikerId;

    @ColumnInfo(name = "naam")
    private String naam;

    @ColumnInfo(name = "week_streak")
    private int weekStreak;

    @ColumnInfo(name = "level")
    private int level;

    @ColumnInfo(name = "ervaring")
    private int ervaring;

    //FOREIN KEYS
    @ColumnInfo(name = "gekozen_challenge_id")
    private int gekozenChallengeId;

    @ColumnInfo(name = "voltooide_challenge_id")
    private int voltooideChallengeId;

    @ColumnInfo(name = "gewonnen_trofee_id")
    private int gewonnenTrofeeId;

    //Getter & setters
    @NonNull
    public int getGebruikerId() {
        return gebruikerId;
    }

    public void setGebruikerId(@NonNull int gebruikerId) {
        this.gebruikerId = gebruikerId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getWeekStreak() {
        return weekStreak;
    }

    public void setWeekStreak(int weekStreak) {
        this.weekStreak = weekStreak;
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

    public int getGekozenChallengeId() {
        return gekozenChallengeId;
    }

    public void setGekozenChallengeId(int gekozenChallengeId) {
        this.gekozenChallengeId = gekozenChallengeId;
    }

    public int getVoltooideChallengeId() {
        return voltooideChallengeId;
    }

    public void setVoltooideChallengeId(int voltooideChallengeId) {
        this.voltooideChallengeId = voltooideChallengeId;
    }

    public int getGewonnenTrofeeId() {
        return gewonnenTrofeeId;
    }

    public void setGewonnenTrofeeId(int gewonnenTrofeeId) {
        this.gewonnenTrofeeId = gewonnenTrofeeId;
    }

    //Constructor
    public Gebruiker(String naam, int weekStreak, int level, int ervaring) {
        this.naam = naam;
        this.weekStreak = weekStreak;
        this.level = level;
        this.ervaring = ervaring;
    }
}
