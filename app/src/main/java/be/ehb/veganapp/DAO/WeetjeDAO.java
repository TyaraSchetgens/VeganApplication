package be.ehb.veganapp.DAO;

import java.util.List;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import be.ehb.veganapp.Weetje;

@Dao
public interface WeetjeDAO {

    // GET information -----------------------------------------
    // Laadt alle weetjes
    @Query("SELECT * FROM weetje")
    List<Weetje> loadAllWeetjes();

    // Selecteer weetje op id
    @Query("SELECT * FROM weetje WHERE weetje_id = :id")
    public Weetje findWeetjeById(int id);

    // SET information -----------------------------------------
    @Insert
    public void insertWeetje(Weetje weetje);

    @Update
    public void updateWeetje(Weetje weetje);

    @Delete
    public void deleteWeetje(Weetje weetje);
}
