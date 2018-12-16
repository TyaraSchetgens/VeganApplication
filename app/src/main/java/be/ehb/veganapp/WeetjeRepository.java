package be.ehb.veganapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import be.ehb.veganapp.DAO.WeetjeDAO;
import be.ehb.veganapp.Model.Weetje;

public class WeetjeRepository {
    private WeetjeDAO weetjeDAO;
    private LiveData<List<Weetje>> allWeetjes;        // Used to return all Weetjes

    public WeetjeRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);

        //Weetjes
        weetjeDAO = database.WeetjeDAO();
        allWeetjes = weetjeDAO.getAllWeetjes();
    }

    // === Alle database operaties:
    // Weetje =====================================
    public void insertWeetje(Weetje weetje) {
        new InsertWeetjeAsyncTask(weetjeDAO).execute(weetje);
    }

    public void updateWeetje (Weetje weetje) {
        new UpdateWeetjeAsyncTask(weetjeDAO).execute(weetje);
    }

    public void deleteWeetje (Weetje weetje) {
        new DeleteWeetjeAsyncTask(weetjeDAO).execute(weetje);
    }

    public LiveData<List<Weetje>> getAllWeetjes() {
        return allWeetjes;
    }

    // Async tasks om de data uit de database te halen
    // INSERT
    private static class InsertWeetjeAsyncTask extends AsyncTask<Weetje, Void, Void> {
        private WeetjeDAO weetjeDAO;

        InsertWeetjeAsyncTask(WeetjeDAO weetjeDAOo) {
            this.weetjeDAO = weetjeDAOo;
        }

        @Override
        protected Void doInBackground(final Weetje... weetjes) {
            weetjeDAO.insertWeetje(weetjes[0]);
            return null;
        }
    }

    // UPDATE
    private static class UpdateWeetjeAsyncTask extends AsyncTask<Weetje, Void, Void> {
        private WeetjeDAO weetjeDAO;

        UpdateWeetjeAsyncTask(WeetjeDAO weetjeDAOo) {
            this.weetjeDAO = weetjeDAOo;
        }

        @Override
        protected Void doInBackground(final Weetje... weetjes) {
            weetjeDAO.updateWeetje(weetjes[0]);
            return null;
        }
    }

    // DELETE
    private static class DeleteWeetjeAsyncTask extends AsyncTask<Weetje, Void, Void> {
        private WeetjeDAO weetjeDAO;

        DeleteWeetjeAsyncTask(WeetjeDAO weetjeDAOo) {
            this.weetjeDAO = weetjeDAOo;
        }

        @Override
        protected Void doInBackground(final Weetje... weetjes) {
            weetjeDAO.deleteWeetje(weetjes[0]);
            return null;
        }
    }
}
