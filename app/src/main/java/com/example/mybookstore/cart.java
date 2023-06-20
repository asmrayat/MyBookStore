package com.example.mybookstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;


public class cart extends Fragment {

    TextView TotalAmount;
    ListView listView;
    Button Delete;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        TotalAmount = view.findViewById(R.id.total_amount);
        Delete = view.findViewById(R.id.clearData);
        listView = view.findViewById(R.id.listView);

        TotalAmount.setText(String.valueOf(CartManager.TotalAmount()));

        String auto = getActivity().getIntent().getExtras().getString("auto","defaultKey");
        String fictional = getActivity().getIntent().getExtras().getString("fictional","defaultKey");
        String comics = getActivity().getIntent().getExtras().getString("comics","defaultKey");
        String history = getActivity().getIntent().getExtras().getString("history","defaultKey");


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

        getActivity().getOnBackPressedDispatcher().addCallback(getActivity(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                Intent intent = new Intent(getActivity(), BookListActivity.class);
                intent.putExtra(auto, auto);
                intent.putExtra(fictional, fictional);
                intent.putExtra(comics, comics);
                intent.putExtra(history, history);
                startActivity(intent);


            }
        });



        return view;



    }

    private class MyAdapter extends BaseAdapter {

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