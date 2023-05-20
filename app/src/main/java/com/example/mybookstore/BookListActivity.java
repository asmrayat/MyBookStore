package com.example.mybookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class BookListActivity extends AppCompatActivity {
    public static LinearLayout list_auto,list_fictional,list_comics,list_history;
    TextView auto_steve,auto_yogi,auto_long,auto_wings,
            fic_Salt,fic_Homecoming,fic_Maiden,fic_love,
            com_Watchmen,com_Knight,com_Sandman,com_Saga,
            his_Sapiens,his_Guns, his_Diary,his_Histories;
    Button cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);



        list_auto = findViewById(R.id.list_auto_book);
        list_fictional = findViewById(R.id.list_fictional_book);
        list_comics = findViewById(R.id.list_comics_book);
        list_history = findViewById(R.id.list_history_book);

        //autobiography
        auto_steve = findViewById(R.id.auto_steve);
        auto_yogi = findViewById(R.id.yogi);
        auto_long = findViewById(R.id.long_auto);
        auto_wings = findViewById(R.id.wings);

        //fictional
        fic_Salt = findViewById(R.id.Salt);
        fic_Homecoming = findViewById(R.id.homecoming);
        fic_Maiden = findViewById(R.id.Maiden);
        fic_love = findViewById(R.id.Love);

        //Comics
        com_Watchmen = findViewById(R.id.watchman);
        com_Knight = findViewById(R.id.knight);
        com_Sandman = findViewById(R.id.sandman);
        com_Saga = findViewById(R.id.saga);

        //History
        his_Sapiens = findViewById(R.id.Sapiens);
        his_Guns = findViewById(R.id.Guns);
        his_Diary = findViewById(R.id.Diary);
        his_Histories = findViewById(R.id.Histories);


        cart = findViewById(R.id.cart);


        String auto = getIntent().getExtras().getString("auto","defaultKey");
        String fictional = getIntent().getExtras().getString("fictional","defaultKey");
        String comics = getIntent().getExtras().getString("comics","defaultKey");
        String history = getIntent().getExtras().getString("history","defaultKey");


        //author
        if (auto.equals("auto")){
            list_auto.setVisibility(View.VISIBLE);



            auto_steve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Steve Jobs",
                            "Steve Jobs is the authorized self-titled biography of American business magnate and Apple co-founder Steve Jobs. The book was written at the request of Jobs by Walter Isaacson.",
                            "Walter Isaacson",
                            "10",
                            R.drawable.steve_job_book_cover);
                }
            });
            auto_yogi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Autobiography of a Yogi",
                            "Autobiography of a Yogi is an autobiography of Paramahansa Yogananda published in 1946.",
                            "Paramahansa Yogananda",
                            "15",
                            R.drawable.yogi_book_cover);
                }
            });
            auto_long.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Long Walk to Freedom",
                            "Long Walk to Freedom is an autobiography credited to South African President Nelson Mandela.",
                            "Nelson Mandela",
                            "20",
                            R.drawable.long_walk_to_freedom_book_cover);
                }
            });
            auto_wings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Wings of Fire",
                            "Wings of Fire, is the autobiography of the Missile Man of India and President of India, Dr. A. P. J. Abdul Kalam.",
                            "A. P. J. Abdul Kalam",
                            "22",
                            R.drawable.wings);
                }
            });

        }
        //fictional
        else if (fictional.equals("fictional")) {
            list_fictional.setVisibility(View.VISIBLE);

            fic_Salt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "The Story of Pa Salt",
                            "Paris, 1928. A boy is found, moments from death, and taken in by a kindly family who gives him a life he could never have dreamed of, but he refuses to tell anyone who he truly is.",
                            "Lucinda Riley",
                            "18",
                            R.drawable.salt);
                }
            });
            fic_Homecoming.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Homecoming",
                            "Adelaide Hills, Christmas Eve, 1959: At the end of a scorching hot day, beside a creek in the grounds of a grand country house",
                            "Kate Morton",
                            "22",
                            R.drawable.home_cover);
                }
            });
            fic_Maiden.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "The Maiden",
                            "Long Walk to Freedom is an autobiography credited to South African President Nelson Mandela.",
                            "Kate Foster",
                            "25",
                            R.drawable.maiden_book_cover);
                }
            });
            fic_love.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "The Love of My Life",
                            "A NEW YORK TIMES BESTSELLER | GOOD MORNING AMERICA BOOK CLUB PICK“Gripping, heartbreaking and impossible to put down",
                            "Rosie Walsh",
                            "30",
                            R.drawable.love_book_cover);
                }
            });
        }
        //comics
        else if (comics.equals("comics")) {
            list_comics.setVisibility(View.VISIBLE);
            com_Watchmen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Watchmen",
                            "A groundbreaking graphic novel that deconstructs the superhero genre, \"Watchmen\" presents a complex and morally ambiguous story set in an alternate version of the United States where masked vigilantes are a part of society",
                            "Alan Moore and Dave Gibbons",
                            "38",
                            R.drawable.watchman_cover);
                }
            });
            com_Knight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "The Dark Knight Returns",
                            "In this iconic Batman tale, Frank Miller depicts an aging Bruce Wayne coming out of retirement to reclaim Gotham City from crime, offering a gritty and introspective examination of Batman's character and the city he protects.",
                            "Frank Miller",
                            "32",
                            R.drawable.knight_cover);
                }
            });
            com_Sandman.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "The Sandman",
                            "Neil Gaiman's epic fantasy series follows Morpheus, the Lord of Dreams, and his interactions with various mythological and historical characters. Blending elements of mythology, horror, and dark fantasy",
                            "Neil Gaiman",
                            "25",
                            R.drawable.sand_cover);
                }
            });
            com_Saga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Saga",
                            "An epic space opera that defies genre conventions, \"Saga\" tells the story of star-crossed lovers from warring alien races as they navigate the challenges of parenthood and survival in a vast and violent universe. ",
                            "Brian K. Vaughan and Fiona Staples",
                            "30",
                            R.drawable.saga_coer);
                }
            });


        }
        //history
        else if (history.equals("history")) {
            list_history.setVisibility(View.VISIBLE);
            his_Sapiens.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Sapiens",
                            "Sapiens: A Brief History of Humankind is a book by Yuval Noah Harari, first published in Hebrew in Israel in 2011",
                            "Yuval Noah Harari",
                            "18",
                            R.drawable.sapiens_cover);
                }
            });
            his_Guns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "The Guns of August",
                            "The Guns of August is a volume of history by Barbara W. Tuchman. It is centered on the first month of World War I. After introductory chapters",
                            "Barbara W. Tuchman",
                            "22",
                            R.drawable.gun_cover);
                }
            });
            his_Diary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "The Diary of a Young Girl",
                            "The Diary of a Young Girl, often referred to as The Diary of Anne Frank, is a book of the writings from the Dutch-language",
                            "Anne Frank",
                            "29",
                            R.drawable.dairy_cover);
                }
            });
            his_Histories.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    bookDataPass(
                            "Histories",
                            "The Histories of Herodotus is considered the founding work of history in Western literature. Written around 430 BC in the Ionic dialect of classical Greek",
                            "Herodotus",
                            "38",
                            R.drawable.histories_cover);
                }
            });
        }

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookListActivity.this,CartActivity.class));
            }
        });


    }

    public void bookDataPass(String bookName, String bookDetail, String authorName, String price, int cover){
        Intent intent = new Intent(BookListActivity.this, DetailActivity.class);



        intent.putExtra("bookName", bookName);
        intent.putExtra("bookDetail", bookDetail);
        intent.putExtra("authorName", authorName);
        intent.putExtra("price", price);

        Bitmap bitmap = BitmapFactory.decodeResource
                (getResources(), cover);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        intent.putExtra("byteArray", bs.toByteArray());

        startActivity(intent);
    }




}