package be.ehb.veganapp.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import be.ehb.veganapp.AppDatabase;

import java.util.List;

import be.ehb.veganapp.Model.Weetje;
import be.ehb.veganapp.WeetjeRepository;

public class WeetjeViewModel extends AndroidViewModel {
   private WeetjeRepository repository;
   private LiveData<List<Weetje>> allWeetjes;

    public WeetjeViewModel(@NonNull Application application) {
        super(application);
        repository = new WeetjeRepository(application);
        allWeetjes = repository.getAllWeetjes();
    }

    // INSERT
    public void insertWeetje(Weetje weetje) {
        repository.insertWeetje(weetje);
    }

    // UPDATE
    public void updateWeetje(Weetje weetje) {
        repository.updateWeetje(weetje);
    }

    // DELETE
    public void deleteWeetje(Weetje weetje) {
        repository.deleteWeetje(weetje);
    }

    //GET ALL CHALLENGES
    public LiveData<List<Weetje>> getAllWeetjes() {
        return allWeetjes;
    }
}
