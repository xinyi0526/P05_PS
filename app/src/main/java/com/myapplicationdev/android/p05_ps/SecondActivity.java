package com.myapplicationdev.android.p05_ps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    SongArrayAdapter aa;
    Button btn;
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lv);
        btn = (Button) this.findViewById(R.id.btn5stars);

        final DBHelper dbh = new DBHelper(this);
        songs = dbh.getAllSongs();

        aa = new SongArrayAdapter(this,R.layout.row,songs);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song data = songs.get(position);
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                i.putExtra("data",data);
                startActivityForResult(i,8);
            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songs = dbh.getAllSongsByStars();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 8 && resultCode == RESULT_OK){
            DBHelper dbh = new DBHelper(SecondActivity.this);
            songs.clear();
            songs.addAll(dbh.getAllSongs());
            aa.notifyDataSetChanged();
            dbh.close();
        }
    }
}
