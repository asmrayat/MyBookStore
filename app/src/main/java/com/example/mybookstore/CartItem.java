package com.example.mybookstore;

public class CartItem {
    private String bookName;
    private int quantity;
    private double bookPrice;

    private  double totalSameBook;
    private double totalPrice;

    // Constructor
    public CartItem(String bookName, int quantity, double bookPrice, double totalSameBook) {
        this.bookName = bookName;
        this.quantity = quantity;
        this.bookPrice = bookPrice;
        this.totalSameBook = totalSameBook;
        this.totalPrice = quantity * bookPrice;
    }

    public double getTotalSameBook() {
        return totalSameBook;
    }

    public void setTotalSameBook(double totalSameBook) {
        this.totalSameBook = totalSameBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
