package com.dicoding.picodiploma.submissionsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilm extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvOverview = findViewById(R.id.tv_overview);
        TextView tvBahasa = findViewById(R.id.tv_bahasa);
        TextView tvTahun = findViewById(R.id.tv_tahun);
        ImageView ivPoster = findViewById(R.id.iv_poster);

        Film film = getIntent().getParcelableExtra(EXTRA_PERSON);

        String title = film.getTitle();
        String overview = film.getOverview();
        String bahasa = film.getBahasa();
        String tahun = film.getTahun();
        int poster = film.getPoster();

        tvTitle.setText(title);
        tvOverview.setText(overview);
        tvBahasa.setText(bahasa);
        tvTahun.setText(tahun);
        ivPoster.setImageResource(poster);
    }
}
