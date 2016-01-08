package com.example.android.popularmoviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) { // The first entry in this activity
            Log.d("DetailActivity", "----> savedInstanceState == null");
            Bundle arguments = new Bundle();
            arguments.putInt( DetailActivityFragment.ARG_POSITION, getIntent().getIntExtra(DetailActivityFragment.ARG_POSITION,0) );
            DetailActivityFragment fragment = new DetailActivityFragment();
            Log.d("DetailActivity", "----> 1");
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.frm_detail, fragment).commit();
            Log.d("DetailActivity", "----> 2");
        }

        /*if (savedInstanceState == null) { // The first entry in this activity
            Log.d("DetailActivity", "----> savedInstanceState == null");
            Bundle arguments = new Bundle();
            arguments.putInt( DetailActivityFragment.ARG_POSITION, getIntent().getIntExtra(DetailActivityFragment.ARG_POSITION,0) );
            DetailActivityFragment fragment = new DetailActivityFragment();
            Log.d("DetailActivity", "----> 1");
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.frm_container_detail, fragment).commit();
            Log.d("DetailActivity", "----> 2");
        }*/

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/


    }

}
