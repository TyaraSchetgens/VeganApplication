package be.ehb.veganapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

class AppAdapter extends RecyclerView.Adapter<AppAdapter.Viewholder> {

    //Adapter vor weetjes
    List<Weetje> weetjes;

    // Adapter ontvangt de data hier
    public AppAdapter(List<Weetje> weetje) {
        this.weetjes = weetje;
    }

    @NonNull
    @Override
    public AppAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.challenge_name_row, parent, false);
        return new Viewholder(view);
    }

    // Voeg de informatie vanuit de database toe aan de Views
    // i stelt de verschillende items voor die worden meegegeven aan de onBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull AppAdapter.Viewholder viewholder, int i) {
        viewholder.challengeName.setText(weetjes.get(i).getBeschrijving());
        viewholder.challengeCategorie.setText(weetjes.get(i).getCategorie());
    }

    // Hoe groot de data is die de adapter moet verwerken
    @Override
    public int getItemCount() {
        return weetjes.size();
    }

    // Alle Views in de XML
    public class Viewholder extends RecyclerView.ViewHolder {
        public TextView challengeName;
        public TextView challengeCategorie;

        // Store View in variabele
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            challengeName = itemView.findViewById(R.id.challenge_name);
            challengeCategorie = itemView.findViewById(R.id.challenge_categorie);
        }
    }
}
