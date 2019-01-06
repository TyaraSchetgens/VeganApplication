package be.ehb.veganapp.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import be.ehb.veganapp.AppDatabase;

import be.ehb.veganapp.GebruikerRepository;
import be.ehb.veganapp.Model.Gebruiker;

public class GebruikerViewModel extends AndroidViewModel {
    private GebruikerRepository repository;
    public Gebruiker gebruiker;

    public GebruikerViewModel(@NonNull Application application) {
        super(application);
        repository = new GebruikerRepository((application));
    }

    // INSERT
    public void insertGebruiker(Gebruiker gebruiker) {
        repository.insertGebruiker(gebruiker);
    }

    // UPDATE
    public void updateGebruiker(Gebruiker gebruiker) {
        repository.updateGebruiker(gebruiker);
    }

    // DELETE
    public void deleteGebruiker(Gebruiker gebruiker) {
        repository.deleteGebruiker(gebruiker);
    }

    // GetbyId
    public Gebruiker getGebruikerById(int gebruikerId) {
        repository.getGebruikerbyId(gebruikerId);
        Log.i("GEBRUIKER_VIEWMODEL", "getGebruikerById: " + gebruiker.getNaam());
        return gebruiker;
    }
}
