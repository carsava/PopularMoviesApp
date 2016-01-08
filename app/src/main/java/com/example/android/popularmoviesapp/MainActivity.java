package com.example.android.popularmoviesapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainFragment.Callbacks{
    String apikey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getKeyApi(view); // Ask the user to APIkey
            }
        });
    }

    private void getKeyApi(View view){
        final View miView = view;
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.AppTheme);
        final EditText edittext = new EditText(MainActivity.this);
        alert.setMessage(getString(R.string.message01));
        alert.setTitle(getString(R.string.apikey));
        alert.setView(edittext);

        alert.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                apikey = edittext.getText().toString();
                Snackbar.make(miView, "APIkey: " + apikey, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        alert.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //Nothing
            }
        });
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEntrySelected(int position) {
        Log.i("MainActivity", "> > > onEntrySelected()");
        Log.d("MainActivity", "----> position: "+position);
        if(findViewById(R.id.frm_container_detail) != null) {
            Log.d("MainActivity", "----> DOS paneles");
            Bundle args = new Bundle();
            args.putInt(DetailActivityFragment.ARG_POSITION, position);
            DetailActivityFragment fragment = new DetailActivityFragment();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction().replace(R.id.frm_container_detail, fragment).commit();
        }else{
            Log.d("MainActivity", "----> UN panel");
            Intent detailIntent = new Intent(this, DetailActivity.class);
            detailIntent.putExtra(DetailActivityFragment.ARG_POSITION, position);
            startActivity(detailIntent);
        }
    }
}
