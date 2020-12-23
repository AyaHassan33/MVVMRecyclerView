package com.example.mvvmrecyclerview.repostories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmrecyclerview.models.Films;

import java.util.ArrayList;

public class FilmsRepository {
    private static FilmsRepository instance;
    private ArrayList<Films> dataSet = new ArrayList<>();
    public static FilmsRepository getInstance(){
        if(instance == null){
            instance=new FilmsRepository();
        }
        return instance;
    }
    //pretend to get data from a webservice or online source
    public MutableLiveData<ArrayList<Films>> getFilms(){
        setFilms();
        MutableLiveData<ArrayList<Films>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;

    }
    private void setFilms(){
        dataSet.add(new Films("Smurfs","https://whatsnxt.com/sites/default/files/field/image/SmurfsLostVillage.jpg"));
        dataSet.add(new Films("Toy Story","https://i.ytimg.com/vi/FC58UhHhKAY/hqdefault.jpg"));
        dataSet.add(new Films("Lion King","https://tvguide1.cbsistatic.com/feed/1/156/thumbs/12006156_1300x1733.jpg"));
        dataSet.add(new Films("Frozen","https://cnet1.cbsistatic.com/img/86V_bltt71A4dI4vEyTKLp3f_gc=/1092x0/2019/11/25/48850c74-c475-4b6d-b580-6667b2293954/frozen2header.jpg"));
        dataSet.add(new Films("Monsters-Inc","https://54disneyreviews.files.wordpress.com/2015/05/monsters-inc-e1432755793204.jpg"));
        dataSet.add(new Films("Cars","https://ohtopten.com/wp-content/uploads/2014/10/Cars.jpg"));
        dataSet.add(new Films("Smurfs","https://whatsnxt.com/sites/default/files/field/image/SmurfsLostVillage.jpg"));
        dataSet.add(new Films("Toy Story","https://i.ytimg.com/vi/FC58UhHhKAY/hqdefault.jpg"));
        dataSet.add(new Films("Lion King","https://tvguide1.cbsistatic.com/feed/1/156/thumbs/12006156_1300x1733.jpg"));
        dataSet.add(new Films("Frozen","https://cnet1.cbsistatic.com/img/86V_bltt71A4dI4vEyTKLp3f_gc=/1092x0/2019/11/25/48850c74-c475-4b6d-b580-6667b2293954/frozen2header.jpg"));
        dataSet.add(new Films("Monsters-Inc","https://54disneyreviews.files.wordpress.com/2015/05/monsters-inc-e1432755793204.jpg"));
        dataSet.add(new Films("Cars","https://ohtopten.com/wp-content/uploads/2014/10/Cars.jpg"));

    }
}
