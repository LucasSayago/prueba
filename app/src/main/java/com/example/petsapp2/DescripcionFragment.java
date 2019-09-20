package com.example.petsapp2;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescripcionFragment extends Fragment {

    private TextView name;
    private ImageView photo;
    private TextView status;
    private DescripcionFragmentInterface descripcionFragmentInterface;



    public DescripcionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
         descripcionFragmentInterface= (DescripcionFragmentInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_descripcion, container, false);

        name = view.findViewById(R.id.namePetDescripcion);
        photo = view.findViewById(R.id.imageViewPetDescripcion);
        status = view.findViewById(R.id.statusPetDescipcion);

        Bundle bundle = getArguments();

        String nameAImprimir = bundle.getString("Name");
        String photoAImprimir = bundle.getString("Photo");
        String statusAImprimir = bundle.getString("Status");


        Glide.with(this)
                .load(photoAImprimir)
                .into(photo);

        name.setText(nameAImprimir);
        status.setText("Status: " + statusAImprimir);


        return view;
    }

    public interface DescripcionFragmentInterface{
    }

}
