package com.dicoding.picodiploma.submissionsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Parcelable {

    private String [] dataTitle;
    private String [] dataOverview;
    private String [] dataBahasa;
    private String [] dataTahun;
    private TypedArray dataposter;
    private FilmAdapter adapter;
    private ArrayList<Film> films;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, films.get(i).getTitle(), Toast.LENGTH_SHORT).show();

                Film film = new Film();
                film.setTitle(dataTitle[i]);
                film.setOverview(dataOverview[i]);
                film.setBahasa(dataBahasa[i]);
                film.setTahun(dataTahun[i]);
                film.setPoster(dataposter.getResourceId(i,1));

                Intent intent = new Intent(MainActivity.this, DetailFilm.class);
                intent.putExtra(DetailFilm.EXTRA_PERSON, film);
                startActivity(intent);

            }
        });
    }

    private void prepare(){
        dataTitle = getResources().getStringArray(R.array.title_film);
        dataOverview = getResources().getStringArray(R.array.overview_film);
        dataTahun = getResources().getStringArray(R.array.tahun_film);
        dataBahasa = getResources().getStringArray(R.array.bahasa_film);
        dataposter = getResources().obtainTypedArray(R.array.poster_film);
    }

    private void addItem(){
        films = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++){
            Film film = new Film();
            film.setTitle(dataTitle[i]);
            film.setOverview(dataOverview[i]);
            /*film.setBahasa(dataBahasa[i]);
            film.setTahun(dataTahun[i]);*/
            film.setPoster(dataposter.getResourceId(i,-1));
            films.add(film);
        }
        adapter.setFilms(films);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(dataTitle);
        parcel.writeStringArray(dataOverview);
        parcel.writeTypedList(films);
    }

    public MainActivity(){

    }
    protected MainActivity(Parcel in) {
        dataTitle = in.createStringArray();
        dataOverview = in.createStringArray();
        films = in.createTypedArrayList(Film.CREATOR);
    }

    public static final Creator<MainActivity> CREATOR = new Creator<MainActivity>() {
        @Override
        public MainActivity createFromParcel(Parcel in) {
            return new MainActivity(in);
        }

        @Override
        public MainActivity[] newArray(int size) {
            return new MainActivity[size];
        }
    };
}
