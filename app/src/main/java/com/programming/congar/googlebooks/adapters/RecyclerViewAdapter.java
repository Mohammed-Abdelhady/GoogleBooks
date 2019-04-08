package com.programming.congar.googlebooks.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.programming.congar.googlebooks.R;
import com.programming.congar.googlebooks.activities.BookActivity;
import com.programming.congar.googlebooks.model.Book;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Book> mData;
    private RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide
        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.book_raw_item , parent , false);
        final MyViewHolder viewHolder =  new MyViewHolder(view);
        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext , BookActivity.class);
                int pos = viewHolder.getAdapterPosition();
                i.putExtra("book_title" ,mData.get(pos).getTitle());
                i.putExtra("book_author" ,mData.get(pos).getAuthors());
                i.putExtra("book_desc" ,mData.get(pos).getDescription());
                i.putExtra("book_categories" ,mData.get(pos).getCategories());
                i.putExtra("book_publish_date" ,mData.get(pos).getPublishedDate());
                i.putExtra("book_info" ,mData.get(pos).getmUrl());
                i.putExtra("book_buy" ,mData.get(pos).getBuy());
                i.putExtra("book_preview" ,mData.get(pos).getPerview());
                i.putExtra("book_thumbnail" ,mData.get(pos).getThumbnail());


                mContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        Book book = mData.get(i);
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthors());
        holder.tvPrice.setText(book.getPrice());
        holder.tvCategory.setText(book.getCategories());

        //load image from internet and set it into imageView using Glide
        Glide.with(mContext).load(book.getThumbnail()).apply(options).into(holder.ivThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivThumbnail ;
        TextView tvTitle , tvCategory , tvPrice , tvAuthor;
        LinearLayout container ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivThumbnail = itemView.findViewById(R.id.thumbnail);
            tvTitle = itemView.findViewById(R.id.title);
            tvAuthor = itemView.findViewById(R.id.author);
            tvCategory = itemView.findViewById(R.id.category);
            tvPrice = itemView.findViewById(R.id.price);
            container = itemView.findViewById(R.id.container);


        }
    }
}
