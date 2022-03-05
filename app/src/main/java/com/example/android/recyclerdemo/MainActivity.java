package com.example.android.recyclerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BooksAdapter myAdapter;
    List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.myRecycler);

        myAdapter = new BooksAdapter(bookList);
        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL ));
        recyclerView.setAdapter(myAdapter);
        prepareBooksData();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
                getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Book book = bookList.get(position);
                Toast.makeText(getApplicationContext(), "Item selected is : " + book.getTitle(), Toast.LENGTH_LONG).show();

            }//end onClick()

            @Override
            public void onLongClick(View view, int position) {

            }//end onLongClick()
        }
        ));
    }//end onCreate()

    void  prepareBooksData(){

        Book book= new Book("First Book", "First Author", "First year") ;
        bookList.add(book);

        book= new Book("Second Book", "Second Author", "Second year") ;
        bookList.add(book);

        book= new Book("Third Book", "Third Author", "Third year") ;
        bookList.add(book);

        book= new Book("Fourth Book", "Fourth Author", "Fourth year") ;
        bookList.add(book);

        book= new Book("Fifth Book", "Fifth Author", "Fifth year") ;
        bookList.add(book);

        myAdapter.notifyDataSetChanged();

    }
}//end class