package com.example.mybookstore;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView bookName,bookDetails,authorName,priceName;
    ImageView coverImage;
    EditText BookAmount;

    Button AddItem;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        bookName = findViewById(R.id.name);
        bookDetails = findViewById(R.id.details);
        authorName = findViewById(R.id.autoName);
        priceName = findViewById(R.id.price);
        coverImage = findViewById(R.id.coverImg);
        AddItem = findViewById(R.id.addItem);
        BookAmount = findViewById(R.id.ammount);



        String auto = getIntent().getExtras().getString("auto","defaultKey");
        String fictional = getIntent().getExtras().getString("fictional","defaultKey");
        String comics = getIntent().getExtras().getString("comics","defaultKey");
        String history = getIntent().getExtras().getString("history","defaultKey");




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


        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (BookAmount.getText().toString().isEmpty()){
                    Toast.makeText(DetailActivity.this, "Enter Valid Quantity", Toast.LENGTH_SHORT).show();
                }else {
                    int quantity = Integer.parseInt(BookAmount.getText().toString());
                    if ( quantity>0){
                        double bookPrice = Double.parseDouble(price);
                        double totalSameBook = bookPrice * quantity;

                        CartItem item = new CartItem(bookname, quantity, bookPrice,totalSameBook);
                        CartManager.cartItems.add(item);
                    }else {
                        Toast.makeText(DetailActivity.this, "Enter Valid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        DetailActivity.this.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {


                Intent intent = new Intent(DetailActivity.this, BookListActivity.class);
                intent.putExtra(auto, auto);
                intent.putExtra(fictional, fictional);
                intent.putExtra(comics, comics);
                intent.putExtra(history, history);
                startActivity(intent);

                finish();

            }
        });



    }


}