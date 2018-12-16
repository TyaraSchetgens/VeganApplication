package be.ehb.veganapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.veganapp.Model.Weetje;
import be.ehb.veganapp.R;

public class WeetjeAdapter extends RecyclerView.Adapter<WeetjeAdapter.WeetjeHolder> {
    private List<Weetje> weetjes = new ArrayList<>();

    // Viewholder voor de individuele weetjeItems
    @NonNull
    @Override
    public WeetjeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.weetje_row, viewGroup, false);
        return new WeetjeHolder(itemview);
    }

    // De juiste data in de juiste views steken
    @Override
    public void onBindViewHolder(@NonNull WeetjeHolder weetjeHolder, int i) {
        Weetje currentWeetje = weetjes.get(i);

        // Alle textviews vullen:
        //weetjeHolder.weetjeBeschrijving.setText(currentWeetje.getBeschrijving()); NIET IN GEBRUIK
        weetjeHolder.weetjeCategorie.setText(currentWeetje.getCategorie());
    }

    @Override
    public int getItemCount() {
        return weetjes.size();
    }

    // Wanneer de Recyclerview geupdated wordt
    public void setWeetjes(List<Weetje> weetjes) {
        this.weetjes = weetjes;
        notifyDataSetChanged();
    }

    // Bevat de recyclerview items
    class WeetjeHolder extends RecyclerView.ViewHolder {
        public TextView weetjeBeschrijving;
        public TextView weetjeCategorie;

        // Constructor
        public WeetjeHolder(@NonNull View itemView) {
            super(itemView);

            // Referentie naar alle textviews
            weetjeBeschrijving = itemView.findViewById(R.id.weetje_beschrijving);
            weetjeCategorie = itemView.findViewById(R.id.weetje_categorie);
        }
    }
}
