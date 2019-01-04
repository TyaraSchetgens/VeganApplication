/*
package be.ehb.veganapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.veganapp.Viewmodel.GebruikerViewModel;
import be.ehb.veganapp.Model.Gebruiker;
import be.ehb.veganapp.R;


public class GebruikerAdapter extends LinearLayout.A<GebruikerAdapter.GebruikerHolder> {
    private List<Gebruiker> gebruikers = new ArrayList<>();

    // Viewholder voor de individuele gebruikerItems
    @NonNull
    @Override
    public GebruikerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gebruiker_row, viewGroup, false);

        return new GebruikerHolder(itemview);
    }

    // De juiste data in de juiste views steken
    @Override
    public void onBindViewHolder(@NonNull GebruikerHolder gebruikerHolder, int i) {
        Gebruiker currentGebruiker = gebruikers.get(i);

        // Alle textviews vullen:
        gebruikerHolder.gebruikerNaamTextView.setText(currentGebruiker.getNaam());
        gebruikerHolder.gebruikerWeekstreakTextView.setText(toString().valueOf(currentGebruiker.getWeekStreak()));
        gebruikerHolder.gebruikerLevelTextView.setText(toString().valueOf(currentGebruiker.getLevel()));
        gebruikerHolder.gebruikerErvaringProgressBar.setProgress(currentGebruiker.getErvaring());
    }

    @Override
    public int getItemCount() {
        return 1; // Altijd maar 1 gebruiker per keer ingelogd
    }

    // Wanneer de Recyclerview geupdated wordt
    public void setGebruiker(List<Gebruiker> gebruiker) {
        this.gebruikers = gebruiker;
        notifyDataSetChanged();
    }

    // Bevat de recyclerview items
    class GebruikerHolder extends RecyclerView.ViewHolder {
        private TextView gebruikerNaamTextView;
        private TextView gebruikerWeekstreakTextView;
        private TextView gebruikerLevelTextView;
        private ProgressBar gebruikerErvaringProgressBar;

        // Constructor
        public GebruikerHolder(@NonNull View itemView) {
            super(itemView);

            // Referentie naar alle textviews
            gebruikerNaamTextView = (TextView) itemView.findViewById(R.id.tv_gebruiker_naam);
            gebruikerWeekstreakTextView = (TextView) itemView.findViewById(R.id.tv_gebruiker_weekstreak);
            gebruikerLevelTextView = (TextView) itemView.findViewById(R.id.tv_gebruiker_level);
            gebruikerErvaringProgressBar = (ProgressBar) itemView.findViewById(R.id.pb_gebruiker_ervaring);
        }
    }
}
*/
