package com.example.android.recyclerdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {
    public List<Book> bookList;
    public BooksAdapter(List<Book> booksList)
    {
        this.bookList = booksList;

    }//end const.

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row, parent,false);


        return new MyViewHolder(itemView);
    }//end onCreateViewHolder()

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.year.setText(book.getYear());
    }//end onBindViewHolder()

    @Override
    public int getItemCount() {
        return bookList.size();
    }//end getItemCount()

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        public TextView title, author, year;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            author = itemView.findViewById(R.id.authorTxt);
            year = itemView.findViewById(R.id.yearTxt);

        }//end const.
    }//end class MyViewHolder
}//end class
