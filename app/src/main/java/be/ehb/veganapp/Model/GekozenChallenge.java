package be.ehb.veganapp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (foreignKeys = {
        @ForeignKey(
                entity = Challenge.class,
                parentColumns = "challenge_id",
                childColumns = "gelinkte_challenge_id"
        )
})
public class GekozenChallenge {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "gekozen_challenge_id")
    private int gekozenChallengeId;

    @ColumnInfo(name = "gelinkte_challenge_id")
    private int gelinkteChallengeId;

    //Getter & setters
    @NonNull
    public int getGekozenChallengeId() {
        return gekozenChallengeId;
    }

    public void setGekozenChallengeId(@NonNull int gekozenChallengeId) {
        this.gekozenChallengeId = gekozenChallengeId;
    }

    public int getGelinkteChallengeId() {
        return gelinkteChallengeId;
    }

    public void setGelinkteChallengeId(int gelinkteChallengeId) {
        this.gelinkteChallengeId = gelinkteChallengeId;
    }

    //Constructor
    public GekozenChallenge(int gelinkteChallengeId) {
        this.gelinkteChallengeId = gelinkteChallengeId;
    }
}
