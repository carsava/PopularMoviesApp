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
    Activity activity;

    public MainFragment() {
    }

    private Callbacks mCallbacks;

    public interface Callbacks{
        public void onEntrySelected(int position);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity=activity;
        if(!(activity instanceof Callbacks)){
            throw new IllegalStateException("Error: The activity is not implement the callback of the fragment");
        }
        mCallbacks = (Callbacks) activity;
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
                Toast.makeText(activity, "" + position, Toast.LENGTH_SHORT).show();
                mCallbacks.onEntrySelected(position);
            }
        });

        return rootView;
    }
}

