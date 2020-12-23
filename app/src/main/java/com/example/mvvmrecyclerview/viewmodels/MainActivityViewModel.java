package com.example.mvvmrecyclerview.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmrecyclerview.models.Films;
import com.example.mvvmrecyclerview.repostories.FilmsRepository;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Films>> mFilms;
    private FilmsRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mFilms != null){
            return;
        }
        mRepo=FilmsRepository.getInstance();
        mFilms=mRepo.getFilms();
    }

    public void addNewValue(final Films films){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayList<Films> currentPlaces = mFilms.getValue();
                currentPlaces.add(films);
                mFilms.postValue(currentPlaces);
                mIsUpdating.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }
    public LiveData<ArrayList<Films>> getFilms(){
        return mFilms;
    }
    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
