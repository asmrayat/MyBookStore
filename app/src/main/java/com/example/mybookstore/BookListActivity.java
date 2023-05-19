package com.example.mybookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookListActivity extends AppCompatActivity {
    public static LinearLayout list_auto,list_fictional,list_comics,list_history;
    TextView auto_steve;
    Button cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);



        list_auto = findViewById(R.id.list_auto_book);
        list_fictional = findViewById(R.id.list_fictional_book);
        list_comics = findViewById(R.id.list_comics_book);
        list_history = findViewById(R.id.list_history_book);
        auto_steve = findViewById(R.id.auto_steve);
        cart = findViewById(R.id.cart);


        String auto = getIntent().getExtras().getString("auto","defaultKey");
        String fictional = getIntent().getExtras().getString("fictional","defaultKey");
        String comics = getIntent().getExtras().getString("comics","defaultKey");
        String history = getIntent().getExtras().getString("history","defaultKey");


        if (auto.equals("auto")){
            list_auto.setVisibility(View.VISIBLE);

            auto_steve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(BookListActivity.this,DetailActivity.class));
                }
            });

        } else if (fictional.equals("fictional")) {
            list_fictional.setVisibility(View.VISIBLE);
        }
        else if (comics.equals("comics")) {
            list_comics.setVisibility(View.VISIBLE);
        }
        else if (history.equals("history")) {
            list_history.setVisibility(View.VISIBLE);
        }

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookListActivity.this,CartActivity.class));
            }
        });


    }
}