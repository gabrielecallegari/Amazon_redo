package it.itsar.amazon_redo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import it.itsar.amazon_redo.R;
import it.itsar.amazon_redo.http.model.Prodotto;

public class ProfiloAdapter extends RecyclerView.Adapter<ProfiloAdapter.ProfiloViewHolder>{
    private final ArrayList<Prodotto> acquistati;

    public ProfiloAdapter(ArrayList<Prodotto> sconto) {
        this.acquistati = sconto;
    }

    @NonNull
    @Override
    public ProfiloAdapter.ProfiloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carta3_template, parent, false);
        return new ProfiloAdapter.ProfiloViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfiloAdapter.ProfiloViewHolder holder, int position) {
        holder.bindValue(acquistati.get(position));
    }

    @Override
    public int getItemCount() {
        return acquistati.size();
    }

    static class ProfiloViewHolder extends RecyclerView.ViewHolder{
        private final TextView nomeProdotto;
        private final ImageView img;
        public ProfiloViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProdotto = itemView.findViewById(R.id.titoloAcquistati);
            img = itemView.findViewById(R.id.acquistatiImage);

        }

        public void bindValue(Prodotto prodotto){
            nomeProdotto.setText(prodotto.getTitle());
            Picasso.get().load(prodotto.getThumbnail()).into(img);
        }

    }
}
