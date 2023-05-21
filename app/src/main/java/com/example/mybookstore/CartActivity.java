package com.example.mybookstore;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    TextView TotalAmount;
    ListView listView;
    Button Delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        TotalAmount = findViewById(R.id.total_amount);
        Delete = findViewById(R.id.clearData);
        listView = findViewById(R.id.listView);

        TotalAmount.setText(String.valueOf(CartManager.TotalAmount()));


        String auto = getIntent().getExtras().getString("auto","defaultKey");
        String fictional = getIntent().getExtras().getString("fictional","defaultKey");
        String comics = getIntent().getExtras().getString("comics","defaultKey");
        String history = getIntent().getExtras().getString("history","defaultKey");


        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);


        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.notifyDataSetChanged();
                CartManager.cartItems.clear();
                TotalAmount.setText(String.valueOf(CartManager.TotalAmount()));

            }
        });

        CartActivity.this.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                Intent intent = new Intent(CartActivity.this, BookListActivity.class);
                intent.putExtra(auto, auto);
                intent.putExtra(fictional, fictional);
                intent.putExtra(comics, comics);
                intent.putExtra(history, history);
                startActivity(intent);
                finish();

            }
        });


    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            System.out.println("arraysize: "+CartManager.cartItems.size());
            return CartManager.cartItems.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.card, null);

            TextView textBookName = myView.findViewById(R.id.itemName);
            TextView Quantity = myView.findViewById(R.id.quantity);
            TextView Amount = myView.findViewById(R.id.bookPrice);
            TextView TotalAmount = myView.findViewById(R.id.bookAmount);

            CartItem item = CartManager.cartItems.get(position);

            textBookName.setText(item.getBookName());
            Quantity.setText(String.valueOf(item.getQuantity()));
            Amount.setText(String.valueOf(item.getBookPrice()));
            TotalAmount.setText(String.valueOf(item.getTotalSameBook()));



            return myView;
        }
    }
}