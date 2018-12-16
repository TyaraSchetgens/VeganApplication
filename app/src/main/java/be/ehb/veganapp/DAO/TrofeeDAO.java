package be.ehb.veganapp.DAO;

import android.arch.lifecycle.LiveData;

import java.util.List;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import be.ehb.veganapp.Model.Trofee;

@Dao
public interface TrofeeDAO {

    // GET information -----------------------------------------

    // Laadt alle trofees
    @Query("SELECT * FROM trofee")
    LiveData<List<Trofee>> loadAllTrofees();

    // Selecteer trofee op id
    @Query("SELECT * FROM trofee WHERE trofee_id = :id")
    public Trofee findTrofeeById(int id);

    // SET information -----------------------------------------

    @Insert
    public void insertTrofee(Trofee trofee);

    @Update
    public void updateTrofee(Trofee trofee);

    @Delete
    public void deleteTrofee(Trofee trofee);
}
