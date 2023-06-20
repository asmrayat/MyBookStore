package com.example.mybookstore;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class bookStore extends Fragment {
    RecyclerView recyclerView;
    ArrayList<String> dataSourse;
    LinearLayoutManager linearLayoutManager;
    myAdapter myAdapter;


    ListView listView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_store, container, false);


        listView = view.findViewById(R.id.list);

        recyclerView  = view.findViewById(R.id.recycle);

        dataSourse = new ArrayList<>();
        dataSourse.add("Autobiography");
        dataSourse.add("Fictional");
        dataSourse.add("Comics");
        dataSourse.add("History");
        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        myAdapter = new myAdapter(dataSourse);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);







        return view;
    }

    public void bookDataPass(String bookName, String bookDetail, String authorName, String price, int cover, String auto){
        Intent intent = new Intent(getActivity(), DetailActivity.class);

        intent.putExtra("bookName", bookName);
        intent.putExtra("bookDetail", bookDetail);
        intent.putExtra("authorName", authorName);
        intent.putExtra("price", price);

        Bitmap bitmap = BitmapFactory.decodeResource
                (getResources(), cover);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        intent.putExtra("byteArray", bs.toByteArray());
        intent.putExtra(auto, auto);

        startActivity(intent);
    }

    public void listItem(String name1, String name2, String name3, String name4){
        List<String> list = new ArrayList<>();
        list.add(name1);
        list.add(name2);
        list.add(name3);
        list.add(name4);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.book_item,list);
        listView.setAdapter(arrayAdapter);
    }


    class myAdapter extends RecyclerView.Adapter<bookStore.myAdapter.myHolder>{

        ArrayList<String> data;
        public myAdapter(ArrayList<String>data) {
            this.data = data;
        }

        @NonNull
        @Override
        public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.rv_item,parent,false);
            return new myHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull myHolder holder, int position) {

            holder.title.setText(data.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    System.out.println("positionNumber"+position);

                    if (position == 0){


                        listItem("Steve Jobs","Autobiography of a Yogi","Long Walk to Freedom","Wings of Fire");
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                if(i == 0){
                                    bookDataPass(
                                            "Steve Jobs",
                                            "Steve Jobs is the authorized self-titled biography of American business magnate and Apple co-founder Steve Jobs. The book was written at the request of Jobs by Walter Isaacson.",
                                            "Walter Isaacson",
                                            "10",
                                            R.drawable.steve_job_book_cover,
                                            "auto");


                                }
                                else if (i == 1) {
                                    bookDataPass(
                                            "Autobiography of a Yogi",
                                            "Autobiography of a Yogi is an autobiography of Paramahansa Yogananda published in 1946.",
                                            "Paramahansa Yogananda",
                                            "15",
                                            R.drawable.yogi_book_cover,
                                            "auto");

                                }
                                else if (i == 2) {
                                    bookDataPass(
                                            "Long Walk to Freedom",
                                            "Long Walk to Freedom is an autobiography credited to South African President Nelson Mandela.",
                                            "Nelson Mandela",
                                            "20",
                                            R.drawable.long_walk_to_freedom_book_cover,
                                            "auto");

                                }
                                else if (i == 3) {
                                    bookDataPass(
                                            "Wings of Fire",
                                            "Wings of Fire, is the autobiography of the Missile Man of India and President of India, Dr. A. P. J. Abdul Kalam.",
                                            "A. P. J. Abdul Kalam",
                                            "22",
                                            R.drawable.wings,
                                            "auto");

                                }
                            }
                        });

                    }
                    //fictional
                    else if (position == 1) {
                        listItem("The Story of Pa Salt","Homecoming","The Maiden","The Love of My Life");

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                if(i == 0){
                                    bookDataPass(
                                            "The Story of Pa Salt",
                                            "Paris, 1928. A boy is found, moments from death, and taken in by a kindly family who gives him a life he could never have dreamed of, but he refuses to tell anyone who he truly is.",
                                            "Lucinda Riley",
                                            "18",
                                            R.drawable.salt,
                                            "fictional");


                                }
                                else if (i == 1) {
                                    bookDataPass(
                                            "Homecoming",
                                            "Adelaide Hills, Christmas Eve, 1959: At the end of a scorching hot day, beside a creek in the grounds of a grand country house",
                                            "Kate Morton",
                                            "22",
                                            R.drawable.home_cover,
                                            "fictional");

                                }
                                else if (i == 2) {
                                    bookDataPass(
                                            "The Maiden",
                                            "Long Walk to Freedom is an autobiography credited to South African President Nelson Mandela.",
                                            "Kate Foster",
                                            "25",
                                            R.drawable.maiden_book_cover,
                                            "fictional");

                                }
                                else if (i == 3) {
                                    bookDataPass(
                                            "The Love of My Life",
                                            "A NEW YORK TIMES BESTSELLER | GOOD MORNING AMERICA BOOK CLUB PICK“Gripping, heartbreaking and impossible to put down",
                                            "Rosie Walsh",
                                            "30",
                                            R.drawable.love_book_cover,
                                            "fictional");

                                }
                            }
                        });

                    }
                    //comics
                    else if (position == 2) {
                        listItem("Watchmen","The Dark Knight Returns","The Sandman","Saga");

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                if(i == 0){
                                    bookDataPass(
                                            "Watchmen",
                                            "A groundbreaking graphic novel that deconstructs the superhero genre, \"Watchmen\" presents a complex and morally ambiguous story set in an alternate version of the United States where masked vigilantes are a part of society",
                                            "Alan Moore and Dave Gibbons",
                                            "38",
                                            R.drawable.watchman_cover,
                                            "comics");


                                }
                                else if (i == 1) {
                                    bookDataPass(
                                            "The Dark Knight Returns",
                                            "In this iconic Batman tale, Frank Miller depicts an aging Bruce Wayne coming out of retirement to reclaim Gotham City from crime, offering a gritty and introspective examination of Batman's character and the city he protects.",
                                            "Frank Miller",
                                            "32",
                                            R.drawable.knight_cover,
                                            "comics");

                                }
                                else if (i == 2) {
                                    bookDataPass(
                                            "The Sandman",
                                            "Neil Gaiman's epic fantasy series follows Morpheus, the Lord of Dreams, and his interactions with various mythological and historical characters. Blending elements of mythology, horror, and dark fantasy",
                                            "Neil Gaiman",
                                            "25",
                                            R.drawable.sand_cover,
                                            "comics");

                                }
                                else if (i == 3) {
                                    bookDataPass(
                                            "Saga",
                                            "An epic space opera that defies genre conventions, \"Saga\" tells the story of star-crossed lovers from warring alien races as they navigate the challenges of parenthood and survival in a vast and violent universe. ",
                                            "Brian K. Vaughan and Fiona Staples",
                                            "30",
                                            R.drawable.saga_coer,
                                            "comics");

                                }
                            }
                        });
                    }
                    //history
                    else if (position == 3) {
                        listItem("Sapiens","The Guns of August","The Diary of a Young Girl","Histories");

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                if(i == 0){
                                    bookDataPass(
                                            "Sapiens",
                                            "Sapiens: A Brief History of Humankind is a book by Yuval Noah Harari, first published in Hebrew in Israel in 2011",
                                            "Yuval Noah Harari",
                                            "18",
                                            R.drawable.sapiens_cover,
                                            "history");


                                }
                                else if (i == 1) {
                                    bookDataPass(
                                            "The Guns of August",
                                            "The Guns of August is a volume of history by Barbara W. Tuchman. It is centered on the first month of World War I. After introductory chapters",
                                            "Barbara W. Tuchman",
                                            "22",
                                            R.drawable.gun_cover,
                                            "history");

                                }
                                else if (i == 2) {
                                    bookDataPass(
                                            "The Diary of a Young Girl",
                                            "The Diary of a Young Girl, often referred to as The Diary of Anne Frank, is a book of the writings from the Dutch-language",
                                            "Anne Frank",
                                            "29",
                                            R.drawable.dairy_cover,
                                            "history");

                                }
                                else if (i == 3) {
                                    bookDataPass(
                                            "Histories",
                                            "The Histories of Herodotus is considered the founding work of history in Western literature. Written around 430 BC in the Ionic dialect of classical Greek",
                                            "Herodotus",
                                            "38",
                                            R.drawable.histories_cover,
                                            "history");

                                }
                            }
                        });
                    }

                }
            });


        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class myHolder extends RecyclerView.ViewHolder{
            TextView title;
            ImageView image;

             public myHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.bookName);
                image = itemView.findViewById(R.id.bookPhoto);

            }
        }
    }
}