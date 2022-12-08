package com.samet.filmleruygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.samet.filmleruygulamasi.databinding.ActivityDetayBinding;

public class DetayActivity extends AppCompatActivity {

    ActivityDetayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Filmler f= (Filmler) getIntent().getSerializableExtra("nesne");

        binding.toolbarDetay.setTitle(f.getAd());
        binding.ivFilm.setImageResource(getResources()
                .getIdentifier(f.getResimAdi(),"drawable",getPackageName()));

        binding.tvYonetmen.setText(f.getYonetmen());
        binding.tvYil.setText(String.valueOf(f.getYil()));
        binding.tvFiyat.setText(f.getFiyat()+"₺");
        binding.buttonSiparis.setOnClickListener(view->{
            Snackbar.make(view,f.getAd()+"Sipariş Verildi",Snackbar.LENGTH_SHORT).show();
        });

    }
}