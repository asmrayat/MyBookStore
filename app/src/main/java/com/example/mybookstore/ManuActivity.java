package com.example.mybookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ManuActivity extends AppCompatActivity {

    CardView auto_book,fictional_book,comics_book,history_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        auto_book = findViewById(R.id.autobiography);
        fictional_book = findViewById(R.id.fictional);
        comics_book = findViewById(R.id.comic);
        history_book = findViewById(R.id.history);

        auto_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datapass("auto","auto");

            }
        });
        fictional_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datapass("fictional","fictional");
            }
        });
        comics_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datapass("comics","comics");
            }
        });
        history_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datapass("history","history");
            }
        });


    }

    public void datapass(String name,String value){
        Intent intent = new Intent(ManuActivity.this, BookListActivity.class);
        intent.putExtra(name, value);
        startActivity(intent);
    }
}