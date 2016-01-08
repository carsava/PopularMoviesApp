package com.example.android.popularmoviesapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    public static String ARG_POSITION = "position";
    Activity activity;

    public DetailActivityFragment() {
        Log.i("DetailActivityFragment", "> > > DetailActivityFragment-constructor()");
    }

    @Override
    public void onAttach(Activity activity){
        Log.i("DetailActivityFragment", "> > > onAttach()");
        super.onAttach(activity);
        this.activity=activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.i("DetailActivityFragment", "> > > onCreateView()");
        View inflatedView = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle args = getArguments();
        if(args != null){
            int position = args.getInt(ARG_POSITION);
            setupMovieInfo(position, inflatedView);
            Log.d("DetailActivityFragment", "----> 5");
        } else {
            setupMovieInfo(0, inflatedView);
            Log.d("DetailActivityFragment", "----> 6");
        }
        return inflatedView;
    }
    private void setupMovieInfo(int position, View view){
        Log.i("DetailActivityFragment", "> > > setupMovieInfo()");
        Log.d("DetailActivityFragment", "----> position: "+position);
        MovieInfo movieInfo = ImageAdapter.movieVector.elementAt(position);
            Log.d("DetailActivityFragment", "----> 1");
        TextView tvAuthor = (TextView) view.findViewById(R.id.tv_author);
        tvAuthor.setText(movieInfo.author);
            Log.d("DetailActivityFragment", "----> 2");
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(movieInfo.name);
            Log.d("DetailActivityFragment", "----> 3");
        ImageView ivCaratula = (ImageView) view.findViewById(R.id.iv_caratula);
        ivCaratula.setImageResource(movieInfo.resourceImage);
             Log.d("DetailActivityFragment", "----> 4");
    }
}
