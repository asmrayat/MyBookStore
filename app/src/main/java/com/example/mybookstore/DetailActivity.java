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

                if (BookAmount.getText().toString().isEmpty()) {
                    Toast.makeText(DetailActivity.this, "Enter Valid Quantity", Toast.LENGTH_SHORT).show();
                } else {
                    int quantity = Integer.parseInt(BookAmount.getText().toString());
                    if (quantity > 0) {
                        double bookPrice = Double.parseDouble(price);
                        double totalSameBook = bookPrice * quantity;

                        boolean isExistingItem = false;

                        for (CartItem item : CartManager.cartItems) {
                            if (item.getBookName().equals(bookname)) {
                                // Update the quantity and total price of the existing item
                                int newQuantity = item.getQuantity() + quantity;
                                double newtotalSameBook = item.getTotalSameBook() + totalSameBook;
                                double Total = item.getTotalPrice() + (quantity*bookPrice);
                                item.setQuantity(newQuantity);
                                item.setBookPrice(bookPrice);
                                item.setTotalSameBook(newtotalSameBook);
                                item.setTotalPrice(Total);
                                isExistingItem = true;

                                handle(auto,fictional,comics,history);
                                finish();
                                Toast.makeText(DetailActivity.this, "Item added to cart", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }

                        if (!isExistingItem) {
                            CartItem item = new CartItem(bookname, quantity, bookPrice, totalSameBook);
                            CartManager.cartItems.add(item);

                            handle(auto,fictional,comics,history);
                            finish();
                            Toast.makeText(DetailActivity.this, "Item added to cart", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(DetailActivity.this, "Enter Valid Quantity", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


        DetailActivity.this.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                handle(auto,fictional,comics,history);

                finish();

            }
        });



    }

    public void handle(String value1,String value2,String value3,String value4){
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        intent.putExtra(value1, value1);
        intent.putExtra(value2, value2);
        intent.putExtra(value3, value3);
        intent.putExtra(value4, value4);
        startActivity(intent);
    }


}