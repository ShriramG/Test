package com.example.shriram.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {



            ArrayList<String> weatherData = new ArrayList<String>() {{
              add("Today - Sunny -88/63");
              add("Tomorrow - Foggy -88/63");
              add("Weds - Rainy - 80/58");
              add("Thurs - Rainy - 78,57");
              add("Fri - Rainy - 78,57");
              add("Sat - Cloudy - 80,60");
            }};

            ArrayAdapter<String> weatherAdapter =
                    new ArrayAdapter<String>(
                            getActivity(), //Context
                            R.layout.list_item_forecast, //ID of list view Layout
                            R.id.list_item_forecast_textview, //ID of text in list View
                            weatherData); //Sample Data to populate list view

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ListView myList = (ListView) rootView.findViewbyId(R.id.listview_forecast);
            myList.setAdapter(weatherAdapter);


            return rootView;
        }
    }
}
