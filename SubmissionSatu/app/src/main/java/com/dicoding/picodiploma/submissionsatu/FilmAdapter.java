package com.dicoding.picodiploma.submissionsatu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Film> films = new ArrayList<>();

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public FilmAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_film, viewGroup, false);
        }
            ViewHolder viewHolder = new ViewHolder(view);

            Film film = (Film) getItem(i);
            viewHolder.bind(film);
            return view;
        }
        private class ViewHolder{
            private TextView txtName;
            private TextView txtOverview;
            private TextView txtTahun;
            private TextView txtBahasa;
            private ImageView imgPoster;


            ViewHolder(View view) {
                txtName = view.findViewById(R.id.tv_title);
                txtOverview = view.findViewById(R.id.tv_overview);
                imgPoster = view.findViewById(R.id.iv_poster);
              /*  txtBahasa = view.findViewById(R.id.tv_bahasa);
                txtTahun = view.findViewById(R.id.tv_tahun);*/
            }
            void bind(Film film) {
                txtName.setText(film.getTitle());
                txtOverview.setText(film.getOverview());
             /*   txtBahasa.setText(film.getBahasa());
                txtTahun.setText(film.getTahun());*/
                imgPoster.setImageResource(film.getPoster());
            }
        }

}
