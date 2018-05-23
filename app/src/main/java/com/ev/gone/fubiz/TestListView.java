package com.ev.gone.fubiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ev.gone.fubiz.Manager.ListViewAdapter;

/**
 * Created by gone on 2/27/18.
 */

public class TestListView extends Activity {


    // Create ListView Object
    private ListView lvList;
    //Create object of custom adapter
    ListViewAdapter adapter;
    // Defined Array String values
    String[] values = new String[]{"Android List View Item 1",
            "Android List View Item 2",
            "Android List View Item 3",
            "Android List View Item 4",
            "Android List View Item 5",
            "Android List View Item 6",
            "Android List View Item 7",
            "Android List View Item 8",
            "Android List View Item 9",
            "Android List View Item 10",
            "Android List View Item 11",
            "Android List View Item 12",
            "Android List View Item 13",
            "Android List View Item 14",
            "Android List View Item 15",
            "Android List View Item 16",
            "Android List View Item 17",
            "Android List View Item 18"};

    // Defined Array of images id
    Integer[] imgid = {
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
            R.drawable.betal_thirs,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testall);
        //Get ListView object from xml
        lvList = (ListView) findViewById(R.id.lvList);

        //call list view adapter constructor

//        adapter = new ListViewAdapter(TestListView.this, values);



        //Assign Above Array Adapter to ListView
        lvList.setAdapter(adapter);
        //Create ListView Item click listener
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), values[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
