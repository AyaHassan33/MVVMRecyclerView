package com.example.mvvmrecyclerview.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmrecyclerview.R;
import com.example.mvvmrecyclerview.models.Films;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Films> mFilms =new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<Films> mFilms, Context mContext) {
        this.mFilms = mFilms;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder vm=new ViewHolder(view);
        return vm;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set the name of the 'Films'
        ((ViewHolder)holder).mName.setText(mFilms.get(position).getTitle());
        //set the image
        RequestOptions defaultOption = new RequestOptions()
                .error(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOption)
                .asBitmap()
                .load(mFilms.get(position).getImageUrl())
                .into(holder.mImage);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, mFilms.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFilms.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView mImage;
        TextView mName;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView){
            super(itemView);
            mImage =itemView.findViewById(R.id.image);
            mName=itemView.findViewById(R.id.image_name);
            parentLayout=itemView.findViewById(R.id.parent_layout);
        }
    }
}

