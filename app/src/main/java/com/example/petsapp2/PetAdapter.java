package com.example.petsapp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PetAdapter extends RecyclerView.Adapter {

    private List<Pet> petList;
    private PetAdapterListener petAdapterListener;

    public PetAdapter(List<Pet> petList, PetAdapterListener petAdapterListener) {
        this.petList = petList;
        this.petAdapterListener = petAdapterListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflador = LayoutInflater.from(viewGroup.getContext());
        View view = inflador.inflate(R.layout.celda_pet, viewGroup, false);

        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Pet petDeLaLista = this.petList.get(i);
        PetViewHolder petViewHolder = (PetViewHolder) viewHolder;
        petViewHolder.bindPet(petDeLaLista);
    }

    @Override
    public int getItemCount() {
        return this.petList.size();
    }

    private class PetViewHolder extends RecyclerView.ViewHolder {
        private Pet petDeLaCelda;
        private TextView name;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.namePet);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    petAdapterListener.informarSeleccion(petDeLaCelda);
                }
            });
        }

        public void bindPet (Pet petDeLaCelda){
            this.petDeLaCelda = petDeLaCelda;
            this.name.setText(petDeLaCelda.getName());



        }
    }

    public interface PetAdapterListener {
        void informarSeleccion(Pet pet);
    }

    public void setFilter(List<Pet> petList) {
        this.petList = new ArrayList<>();
        this.petList.addAll(petList);
        notifyDataSetChanged();
    }
}
