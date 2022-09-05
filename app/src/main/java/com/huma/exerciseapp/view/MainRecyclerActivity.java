package com.huma.exerciseapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huma.exerciseapp.adapter.MenuItemsAdapter;
import com.huma.exerciseapp.adapter.MovieAdapter;
import com.huma.exerciseapp.adapter.SerialAdapter;
import com.huma.exerciseapp.classes.MovieList;
import com.huma.exerciseapp.model.MovieSerial;
import com.huma.exerciseapp.R;

import java.util.List;


public class MainRecyclerActivity extends Activity {

    MovieAdapter movieAdapter;
    SerialAdapter serialAdapter;
    MenuItemsAdapter menuItemsAdapter;
    String[] menuItemsDataSet = MovieList.MOVIE_CATEGORY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);

        //recycle menu
        RecyclerView recyclerViewMenu = findViewById(R.id.recyclerViewMenu);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        menuItemsAdapter = new MenuItemsAdapter(menuItemsDataSet);
        recyclerViewMenu.setAdapter(menuItemsAdapter);

        List<List<MovieSerial>> listAll = MovieList.setupMovies();


        List<MovieSerial> listMovies = listAll.get(0);
        RecyclerView recyclerViewMovie = findViewById(R.id.recyclerViewMovie);
        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        movieAdapter = new MovieAdapter(MainRecyclerActivity.this,listMovies);
        recyclerViewMovie.setAdapter(movieAdapter);


        List<MovieSerial> listSerials = listAll.get(1);
        RecyclerView recyclerViewSerial = findViewById(R.id.recyclerViewSerial);
        recyclerViewSerial.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        serialAdapter = new SerialAdapter(MainRecyclerActivity.this,listSerials);
        recyclerViewSerial.setAdapter(serialAdapter);
    }





}