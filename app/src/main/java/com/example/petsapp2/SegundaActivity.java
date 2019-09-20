package com.example.petsapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity implements DescripcionFragment.DescripcionFragmentInterface, WebViewFragment.WebViewFragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        WebViewFragment webViewFragment = new WebViewFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction unaTransaccion = fragmentManager.beginTransaction();
        webViewFragment.setArguments(bundle);
        unaTransaccion.add(R.id.contenedorDeFragment, webViewFragment);
        unaTransaccion.commit();

        DescripcionFragment descripcionFragment = new DescripcionFragment();
        FragmentTransaction unaTransaccion2 = fragmentManager.beginTransaction();
        descripcionFragment.setArguments(bundle);
        unaTransaccion2.add(R.id.contenedorDeFragment, descripcionFragment);
        unaTransaccion2.commit();
    }
}
