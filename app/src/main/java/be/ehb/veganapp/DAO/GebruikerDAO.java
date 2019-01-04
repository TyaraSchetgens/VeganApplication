package be.ehb.veganapp.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
import be.ehb.veganapp.Model.Gebruiker;

@Dao
public interface GebruikerDAO {

    // GET information -----------------------------------------
    // Laadt alle gebruikers
    @Query("SELECT * FROM gebruiker")
    List<Gebruiker> getAllGebruikers();

    // Selecteer gebruiker op id
    @Query("SELECT * FROM gebruiker WHERE gebruiker_id = :id")
    public Gebruiker getGebruikerById(int id);

    // SET information -----------------------------------------
    @Insert
    public void insertGebruiker(Gebruiker gebruiker);

    @Update
    public void updateGebruiker(Gebruiker gebruiker);

    @Delete
    public void deleteGebruiker(Gebruiker gebruiker);
}
