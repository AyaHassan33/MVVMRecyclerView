package com.example.mvvmrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvmrecyclerview.adapters.RecyclerViewAdapter;
import com.example.mvvmrecyclerview.models.Films;
import com.example.mvvmrecyclerview.viewmodels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG="MainActivity";
    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private ProgressBar mProgressBar;
    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab=findViewById(R.id.fab);
        mRecyclerView=findViewById(R.id.recycler_view);
        mProgressBar=findViewById(R.id.progress_bar);
        mMainActivityViewModel= new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MainActivityViewModel.class);
        //mMainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getFilms().observe(this, new Observer<ArrayList<Films>>() {
            @Override
            public void onChanged(ArrayList<Films> films) {
                mAdapter.notifyDataSetChanged();
            }
        });

        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                } else{
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mMainActivityViewModel.getFilms().getValue().size()-1);
                }

            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivityViewModel.addNewValue(new Films("Cinderella","https://i.ytimg.com/vi/fuZi93wb1q8/maxresdefault.jpg"));
            }
        });

        intiRecyclerView();

    }

    private void intiRecyclerView(){
        mAdapter = new RecyclerViewAdapter(mMainActivityViewModel.getFilms().getValue(),this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    private void showProgressBar(){mProgressBar.setVisibility(View.VISIBLE);}
    private void hideProgressBar(){mProgressBar.setVisibility(View.GONE);}

}