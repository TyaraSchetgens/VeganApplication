package be.ehb.veganapp.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Weetje {

    //Unieke id van weetje
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "weetje_id")
    private int weetjeId;

    // Beschrijving, de body van de text over een weetje
    @ColumnInfo(name = "beschrijving")
    private String beschrijving;

    // Categorie waarbinnen een weetje valt.
    @ColumnInfo(name = "categorie")
    private String categorie;

    //Getter, setters
    @NonNull
    public int getWeetjeId() {
        return weetjeId;
    }

    public void setWeetjeId(@NonNull int weetjeId) {
        this.weetjeId = weetjeId;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    // Constructor
    public Weetje(String beschrijving, String categorie) {
        this.beschrijving = beschrijving;
        this.categorie = categorie;
    }
}
