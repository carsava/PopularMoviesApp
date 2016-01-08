package com.example.android.popularmoviesapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Vector;

/**
 * Created by asus on 24/12/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public static Vector<MovieInfo> movieVector;

    public ImageAdapter(Context c) {
        mContext = c;
        inicializeVector();
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };

    public static void inicializeVector(){
        movieVector=new Vector<MovieInfo>();
        movieVector.add(new MovieInfo("Kappa", "Akutagawa", R.drawable.sample_0,
                "http://www.leemp3.com/leemp3/1/Kappa_akutagawa.mp3"));
        movieVector.add(new MovieInfo("Avecilla", "Alas Clarín, Leopoldo",
                R.drawable.sample_1,
                "http://www.leemp3.com/leemp3/Avecilla_alas.mp3"));
        movieVector.add(new MovieInfo("Divina Comedia", "Dante",
                R.drawable.sample_2,
                "http://www.leemp3.com/leemp3/8/Divina%20Comedia_alighier.mp3"));
        movieVector.add(new MovieInfo("Viejo Pancho, El",
                "Alonso y Trelles, José", R.drawable.sample_3,
                "http://www.leemp3.com/leemp3/1/viejo_pancho_trelles.mp3"));
        movieVector.add(new MovieInfo("Canción de Rolando", "Anónimo",
                R.drawable.sample_4,
                "http://www.leemp3.com/leemp3/1/Cancion%20de%20Rolando_ anonimo.mp3"));
        movieVector.add(new MovieInfo("Matrimonio de sabuesos","Agata Christie",
                R.drawable.sample_5, "http://www.dcomg.upv.es/~jtomas/android/audiolibros/ 01.%20Matrimonio%20De%20Sabuesos.mp3"));
        movieVector.add(new MovieInfo("La iliada","Homero",
                R.drawable.sample_6,
                "http://www.dcomg.upv.es/~jtomas/android/audiolibros/la-iliada- homero184950.mp3"));
        movieVector.add(new MovieInfo("Kappa", "Akutagawa", R.drawable.sample_0,
                "http://www.leemp3.com/leemp3/1/Kappa_akutagawa.mp3"));
        movieVector.add(new MovieInfo("Avecilla", "Alas Clarín, Leopoldo",
                R.drawable.sample_1,
                "http://www.leemp3.com/leemp3/Avecilla_alas.mp3"));
        movieVector.add(new MovieInfo("Divina Comedia", "Dante",
                R.drawable.sample_2,
                "http://www.leemp3.com/leemp3/8/Divina%20Comedia_alighier.mp3"));
        movieVector.add(new MovieInfo("Viejo Pancho, El",
                "Alonso y Trelles, José", R.drawable.sample_3,
                "http://www.leemp3.com/leemp3/1/viejo_pancho_trelles.mp3"));
        movieVector.add(new MovieInfo("Canción de Rolando", "Anónimo",
                R.drawable.sample_4,
                "http://www.leemp3.com/leemp3/1/Cancion%20de%20Rolando_ anonimo.mp3"));
        movieVector.add(new MovieInfo("Matrimonio de sabuesos","Agata Christie",
                R.drawable.sample_5, "http://www.dcomg.upv.es/~jtomas/android/audiolibros/ 01.%20Matrimonio%20De%20Sabuesos.mp3"));
        movieVector.add(new MovieInfo("La iliada","Homero",
                R.drawable.sample_6,
                "http://www.dcomg.upv.es/~jtomas/android/audiolibros/la-iliada- homero184950.mp3"));
    }
}
