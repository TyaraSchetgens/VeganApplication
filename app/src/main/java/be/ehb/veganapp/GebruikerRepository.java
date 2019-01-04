package be.ehb.veganapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import be.ehb.veganapp.DAO.GebruikerDAO;
import be.ehb.veganapp.Model.Gebruiker;
import be.ehb.veganapp.AppDatabase;


public class GebruikerRepository {
    private GebruikerDAO gebruikerDAO;

    public GebruikerRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);

        //Gebruikers
        gebruikerDAO = database.gebruikerDAO();
    }

    // === Alle database operaties:

    // Gebruiker =====================================
    public void insertGebruiker(Gebruiker gebruiker) {
        new InsertGebruikerAsyncTask(gebruikerDAO).execute(gebruiker);
    }

    public void updateGebruiker (Gebruiker gebruiker) {
        new UpdateGebruikerAsyncTask(gebruikerDAO).execute(gebruiker);
    }

    public void deleteGebruiker (Gebruiker gebruiker) {
        new DeleteGebruikerAsyncTask(gebruikerDAO).execute(gebruiker);
    }

    /*public Gebruiker getGebruikerbyId(int id) {
        Gebruiker g; // wordt gereturned door getbyid
        GetGebruikerByIdAsyncTask asyncTask = new GetGebruikerByIdAsyncTask(gebruikerDAO, new GetGebruikerByIdAsyncTask.RecievedGebruiker() {
            @Override
            public void onResponseRecieved(Gebruiker response) {
                super. = response;
                Log.i("GetbyID response", "onResponseRecieved: " + g.getNaam());
            }
        });
        asyncTask.execute(id);
    }*/

    // ASYNCTTASKS =====================================

    // INSERT
    private static class InsertGebruikerAsyncTask extends AsyncTask<Gebruiker, Void, Void> {
        private GebruikerDAO gebruikerDAO;

        InsertGebruikerAsyncTask(GebruikerDAO gebruikerDAO) {
            this.gebruikerDAO = gebruikerDAO;
        }

        @Override
        protected Void doInBackground(final Gebruiker... gebruikers) {
            gebruikerDAO.insertGebruiker(gebruikers[0]);
            return null;
        }
    }

    // UPDATE
    private static class UpdateGebruikerAsyncTask extends AsyncTask<Gebruiker, Void, Void> {
        private GebruikerDAO gebruikerDAO;

        UpdateGebruikerAsyncTask(GebruikerDAO gebruikerDAO) {
            this.gebruikerDAO = gebruikerDAO;
        }

        @Override
        protected Void doInBackground(final Gebruiker... gebruikers) {
            gebruikerDAO.updateGebruiker(gebruikers[0]);
            return null;
        }
    }

    // DELETE
    private static class DeleteGebruikerAsyncTask extends AsyncTask<Gebruiker, Void, Void> {
        private GebruikerDAO gebruikerDAO;

        DeleteGebruikerAsyncTask(GebruikerDAO gebruikerDAO) {
            this.gebruikerDAO = gebruikerDAO;
        }

        @Override
        protected Void doInBackground(final Gebruiker... gebruikers) {
            gebruikerDAO.deleteGebruiker(gebruikers[0]);
            return null;
        }
    }

    // GetGebruikerById
    //----------------------------------------------------------------------------------------
    /*private static class GetGebruikerByIdAsyncTask extends AsyncTask<Integer, Void, Gebruiker> {
        private GebruikerDAO gebruikerDAO;
        private boolean isFinished = false;

        // Interface om gebruiker vanuit getgebruikerbyid te parsen naar de methode
        public interface RecievedGebruiker {
            void onResponseRecieved(Gebruiker response);
        }
        public RecievedGebruiker foundGebruiker = null;

        public GetGebruikerByIdAsyncTask(GebruikerDAO gebruikerDAO, RecievedGebruiker foundGebruiker) {
            this.gebruikerDAO = gebruikerDAO;
            this.foundGebruiker = foundGebruiker;
        }

        @Override
        protected Gebruiker doInBackground(final Integer... params) {
            Gebruiker g;
            g = gebruikerDAO.getGebruikerById(params[0]);
            return  g;
        }

        @Override
        protected void onPostExecute(Gebruiker gebruiker) {
            Log.i("REPO", "onPostExecute: " + gebruiker.getNaam());
            foundGebruiker.onResponseRecieved(gebruiker);
            isFinished = true;
        }

    }*/
    //----------------------------------------------------------------------------------------
}
