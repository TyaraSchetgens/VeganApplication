package be.ehb.veganapp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Challenge.class,
                parentColumns = "challenge_id",
                childColumns = "gelinkte_challenge_id"
        )
})
public class VoltooideChallenge {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "voltooide_challenge_id")
    private int voltooideChallengeId;

    @ColumnInfo(name = "gelinkte_challenge_id")
    private int gelinkteChallengeId;

    //Getter & setters
    @NonNull
    public int getVoltooideChallengeId() {
        return voltooideChallengeId;
    }
    public void setVoltooideChallengeId(@NonNull int voltooideChallengeId) {
        this.voltooideChallengeId = voltooideChallengeId;
    }
    public int getGelinkteChallengeId() {
        return gelinkteChallengeId;
    }
    public void setGelinkteChallengeId(int gelinkteChallengeId) {
        this.gelinkteChallengeId = gelinkteChallengeId;
    }

    //Constructor
    public VoltooideChallenge(int gelinkteChallengeId) {
        this.gelinkteChallengeId = gelinkteChallengeId;
    }
}

