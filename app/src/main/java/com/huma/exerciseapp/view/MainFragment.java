package com.huma.exerciseapp.view;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.huma.exerciseapp.adapter.CardPresenter;
import com.huma.exerciseapp.classes.MovieList;
import com.huma.exerciseapp.model.MovieSerial;
import com.huma.exerciseapp.R;


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ir.huma.humaleanbacklib.fragments.BaseBrowseFragment2;

public class MainFragment extends BaseBrowseFragment2 {

    private String mBackgroundUri;
    private Timer mBackgroundTimer;
    private DisplayMetrics mMetrics;
    private Drawable mDefaultBackground;
    private BackgroundManager mBackgroundManager;
    private final Handler mHandler = new Handler();
    private static final int BACKGROUND_UPDATE_DELAY = 300;

    @Override
    public void initial() {


        mBackgroundManager = BackgroundManager.getInstance(requireActivity());
        mBackgroundManager.attach(requireActivity().getWindow());
        mDefaultBackground = ContextCompat.getDrawable(requireContext(), R.drawable.default_background);
        mMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(mMetrics);

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(ContextCompat.getColor(requireContext(), R.color.fastlane_background));
        setSearchAffordanceColor(ContextCompat.getColor(requireContext(), R.color.search_opaque));

        setOnSearchClickedListener(view -> {

            Toast.makeText(getActivity(), "With RecyclerView!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(requireContext(), MainRecyclerActivity.class);
            startActivity(intent);
        });

        loadMovies();
    }

    @Override
    public void onItemSelectedListener(View v, Object item, int rowPos, int pos) {

        if (item instanceof MovieSerial) {
            mBackgroundUri = ((MovieSerial) item).getCardImageUrl();

            // Change the background to the photo that is clicked ->(mBackgroundUri)
            startBackgroundTimer();
        }
    }

    @Override
    public void onItemClickListener(View v, Object item, int rowPos, int pos) {

        if (item instanceof MovieSerial) {
            Toast.makeText(getActivity(), ((MovieSerial) item).getTitle(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        if (null != mBackgroundTimer) {
            mBackgroundTimer.cancel();
        }
    }

    private void loadMovies() {

        List<List<MovieSerial>> listAll = MovieList.setupMovies();
        List<MovieSerial> listMovies = listAll.get(0);
        List<MovieSerial> listSerials = listAll.get(1);

        ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());//menu adapter
        CardPresenter cardPresenter = new CardPresenter();

        // Movies
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for (int j = 0; j < listMovies.size(); j++) {
            listRowAdapter.add(listMovies.get(j));
        }

        HeaderItem header = new HeaderItem(0, MovieList.MOVIE_CATEGORY[0]);
        rowsAdapter.add(new ListRow(header, listRowAdapter));//add Movies item to menu




        // Serials
        listRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for (int j = 0; j < listSerials.size(); j++) {

            listRowAdapter.add(listSerials.get(j));
        }

        header = new HeaderItem(1, MovieList.MOVIE_CATEGORY[1]);
        rowsAdapter.add(new ListRow(header, listRowAdapter));//add Serials item to menu

        setAdapter(rowsAdapter);
    }

    private void updateBackground(String uri) {

        int width = mMetrics.widthPixels;
        int height = mMetrics.heightPixels;

        Glide.with(requireActivity())
                .load(uri)
                .centerCrop()
                .error(mDefaultBackground)
                .into(new SimpleTarget<Drawable>(width, height) {

                    @Override
                    public void onResourceReady(@NonNull Drawable drawable,
                                                @Nullable Transition<? super Drawable> transition) {
                        mBackgroundManager.setDrawable(drawable);
                    }
                });



        mBackgroundTimer.cancel();
    }

    private void startBackgroundTimer() {
        if (null != mBackgroundTimer) {
            mBackgroundTimer.cancel();
        }

        mBackgroundTimer = new Timer();
        mBackgroundTimer.schedule(new UpdateBackgroundTask(), BACKGROUND_UPDATE_DELAY);
    }

    private class UpdateBackgroundTask extends TimerTask {

        @Override
        public void run() {
            mHandler.post(() -> updateBackground(mBackgroundUri));
        }
    }
}