package com.example.mybookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView bookName,bookDetails,authorName,priceName;
    ImageView coverImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        bookName = findViewById(R.id.name);
        bookDetails = findViewById(R.id.details);
        authorName = findViewById(R.id.autoName);
        priceName = findViewById(R.id.price);
        coverImage = findViewById(R.id.coverImg);


        String bookname = getIntent().getExtras().getString("bookName","defaultKey");
        String bookdetails = getIntent().getExtras().getString("bookDetail","defaultKey");
        String authorname = getIntent().getExtras().getString("authorName","defaultKey");
        String price = getIntent().getExtras().getString("price","defaultKey");


        bookName.setText(bookname);
        bookDetails.setText(bookdetails);
        authorName.setText(authorname);
        priceName.setText("$"+price);
        if(getIntent().hasExtra("byteArray")) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            coverImage.setImageBitmap(bitmap);
        }







    }
}