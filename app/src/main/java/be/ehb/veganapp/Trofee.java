package be.ehb.veganapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Trofee {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "trofee_id")
    private int trofeeId;

    @ColumnInfo(name = "naam")
    private String naam;

    //Getter & setter
    @NonNull
    public int getTrofeeId() {
        return trofeeId;
    }

    public void setTrofeeId(@NonNull int trofeeId) {
        this.trofeeId = trofeeId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    //Constructor
    public Trofee(String naam) {
        this.naam = naam;
    }
}
