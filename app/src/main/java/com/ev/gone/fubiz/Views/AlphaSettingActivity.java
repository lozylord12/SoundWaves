package com.ev.gone.fubiz.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ev.gone.fubiz.Manager.ListViewAdapter;
import com.ev.gone.fubiz.Manager.SongManager;
import com.ev.gone.fubiz.Models.LinkSongs;
import com.ev.gone.fubiz.Models.Songs;
import com.ev.gone.fubiz.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AlphaSettingActivity extends AppCompatActivity {


    String settimes[] = new String[]{"5 mins", "10 mins", "15 mins", "20 mins", "25 mins", "30 mins", "35 mins", "40 mins", "45 mins", "50 mins", "55 mins", "60 mins"};

    View alpha_btn;
    Button backto_alpha_main;
    DatabaseReference mData;

    // data
    ArrayList<String> ListSong;
    ArrayList<String> ListUrl;
    ListViewAdapter data_adapter_test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_setting);

        // mapping with data
        mData = FirebaseDatabase.getInstance().getReference();


        SongManager.getInstance().load();
//z        mSongsName = SongManager.getInstance().getSongName();

        final ListView lvsong = (ListView) findViewById(R.id.listview);

     //   Songs a = new Songs("Noctune op.9 No.2",8,"dfjdhdhf");
     //      mData.child("Song").push().setValue(a);

        ListSong = new ArrayList<String>();
        ListUrl = new ArrayList<String>();

        data_adapter_test = new ListViewAdapter(AlphaSettingActivity.this, ListSong);
        lvsong.setAdapter(data_adapter_test);



        alpha_btn = (View) findViewById(R.id.alpha_setting);
        alpha_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mData.child("Song").addChildEventListener(new ChildEventListener() {

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Songs info = dataSnapshot.getValue(Songs.class);
                        ListSong.add(info.name);
                        ListUrl.add(info.url);
                        data_adapter_test.notifyDataSetChanged();
                    }
                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    }
                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                    }
                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        lvsong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(0).toString());
                    myIntent.putExtra("push_url", ListUrl.get(0));
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(1).toString());
                    myIntent.putExtra("push_url", ListUrl.get(1));
                    startActivityForResult(myIntent, 1);
                }

                if (position == 2){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(2).toString());

                    myIntent.putExtra("push_url", ListUrl.get(2));
                    startActivityForResult(myIntent, 2);
                }

                if (position == 3){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(4).toString());

                    myIntent.putExtra("push_url", ListUrl.get(3));
                    startActivityForResult(myIntent, 3);
                }

                if (position == 4){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(4).toString());

                    myIntent.putExtra("push_url", ListUrl.get(4));
                    startActivityForResult(myIntent, 4);
                }

                if (position == 5){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(5).toString());

                    myIntent.putExtra("push_url", ListUrl.get(5));
                    startActivityForResult(myIntent, 5);
                }

                if (position == 6){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(6).toString());

                    myIntent.putExtra("push_url", ListUrl.get(6));
                    startActivityForResult(myIntent, 6);
                }

                if (position == 7){
                    Intent myIntent = new Intent(view.getContext(), AlphaActivity.class);
                    myIntent.putExtra("push_song", lvsong.getItemAtPosition(7).toString());

                    myIntent.putExtra("push_url", ListUrl.get(7));
                    startActivityForResult(myIntent, 7);
                }

            }
        });

        backto_alpha_main = (Button) findViewById(R.id.backto_alpha_main);
        backto_alpha_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent redirect_one = new Intent(AlphaSettingActivity.this, AlphaActivity.class);
                startActivity(redirect_one);


            }
        });


    }
}
