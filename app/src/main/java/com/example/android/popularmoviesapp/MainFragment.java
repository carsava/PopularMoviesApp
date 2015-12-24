package com.example.android.popularmoviesapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maingrid, container, false);
        final Activity activity = getActivity();
        /*BaseAdapter adaptador = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                new ArrayList<String>());*/
        BaseAdapter adaptador = new ImageAdapter(activity);

        activity.setContentView(R.layout.fragment_maingrid);

        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        gridview.setAdapter(adaptador);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                /*String forecast = adaptador.getItem(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, forecast);
                Log.d(LOG_CAT, "----> " + forecast);
                startActivity(intent);*/
                Toast.makeText(activity, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}

