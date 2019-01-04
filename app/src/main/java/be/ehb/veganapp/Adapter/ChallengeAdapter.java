package be.ehb.veganapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.veganapp.Model.Challenge;
import be.ehb.veganapp.R;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ChallengeHolder> {
    private List<Challenge> challenges = new ArrayList<>();

    // Viewholder voor de individuele challengeItems
    @NonNull
    @Override
    public ChallengeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.challenge_row, viewGroup, false);
        return new ChallengeHolder(itemview);
    }

    // De juiste data in de juiste views steken
    @Override
    public void onBindViewHolder(@NonNull ChallengeHolder challengeHolder, int i) {
        Challenge currentChallenge = challenges.get(i);

        // Alle textviews vullen:
        challengeHolder.tvNaam.setText(currentChallenge.getNaam());
        challengeHolder.tvBeschrijving.setText(currentChallenge.getBeschrijving());
        /*challengeHolder.tvLevel.setText(String.valueOf(currentChallenge.getLevel())); //ToString voor int-waarden
        challengeHolder.tvErvaring.setText(String.valueOf(currentChallenge.getErvaring()));
        challengeHolder.tvCategorie.setText(currentChallenge.getCategorie());
        challengeHolder.tvDag.setText(String.valueOf(currentChallenge.getDag()));
        challengeHolder.tvQuickChallenge.setText(String.valueOf(currentChallenge.isQuickChallenge()));
        challengeHolder.tvHowTo.setText(currentChallenge.getHowTo());*/
    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }

    // Wanneer de Recyclerview geupdated wordt
    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
        notifyDataSetChanged();
    }

    // Bevat de recyclerview items
    class ChallengeHolder extends RecyclerView.ViewHolder {
        private TextView tvNaam;
        private TextView tvBeschrijving;
        private TextView tvLevel;
        private TextView tvErvaring;
        private TextView tvCategorie;
        private TextView tvDag;
        private TextView tvQuickChallenge;
        private TextView tvHowTo;

        // Constructor
        public ChallengeHolder(@NonNull View itemView) {
            super(itemView);

            // Referentie naar alle textviews
            tvNaam = itemView.findViewById(R.id.tv_challenge_naam);
            tvBeschrijving = itemView.findViewById(R.id.tv_challenge_beschrijving);
            /*tvLevel = itemView.findViewById(R.id.tv_challenge_level);
            tvErvaring = itemView.findViewById(R.id.tv_challenge_ervaring);
            tvCategorie = itemView.findViewById(R.id.tv_challenge_categorie);
            tvDag = itemView.findViewById(R.id.tv_challenge_dag);
            tvQuickChallenge = itemView.findViewById(R.id.tv_challenge_quick_challenge);
            tvHowTo = itemView.findViewById(R.id.tv_challenge_how_to);*/
        }
    }
}
