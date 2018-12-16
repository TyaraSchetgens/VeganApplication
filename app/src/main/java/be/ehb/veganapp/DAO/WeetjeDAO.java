package be.ehb.veganapp.DAO;

import java.util.List;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import be.ehb.veganapp.Model.Weetje;

@Dao
public interface WeetjeDAO {

    // GET information -----------------------------------------
    // Laadt alle weetjes
    @Query("SELECT * FROM weetje")
    LiveData<List<Weetje>> getAllWeetjes();

    // Selecteer weetje op id
    @Query("SELECT * FROM weetje WHERE weetje_id = :id")
    public Weetje getWeetjeById(int id);

    @Query("SELECT COUNT(*) FROM weetje")
    LiveData<Integer> getDataCount();

    // SET information -----------------------------------------
    @Insert
    public void insertWeetje(Weetje weetje);

    @Update
    public void updateWeetje(Weetje weetje);

    @Delete
    public void deleteWeetje(Weetje weetje);
}
