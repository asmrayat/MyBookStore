package com.example.mybookstore;

import java.util.ArrayList;

public class CartManager {
    public static ArrayList<CartItem> cartItems = new ArrayList<>();


    public static double TotalAmount(){
        double totalPriceOfAllBooks = 0.0;

        for (CartItem item : CartManager.cartItems) {
            totalPriceOfAllBooks += item.getTotalPrice();
        }

        return totalPriceOfAllBooks;
    }


}
