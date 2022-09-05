package com.huma.exerciseapp.classes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.leanback.widget.TitleViewAdapter;

import com.huma.exerciseapp.R;

public class CustomTitleView extends RelativeLayout implements TitleViewAdapter.Provider {

    private final TextView mTitleView;
    private final View mLogoView;
    private final View mSearchOrbView;

    private final TitleViewAdapter mTitleViewAdapter = new TitleViewAdapter() {

        @Override
        public View getSearchAffordanceView() {

            return mSearchOrbView;
        }

        @Override
        public void setTitle(CharSequence titleText) {

            CustomTitleView.this.setTitle(titleText);
        }

        @Override
        public void setBadgeDrawable(Drawable drawable) {
        }

        @Override
        public void setOnSearchClickedListener(OnClickListener listener) {

            mSearchOrbView.setOnClickListener(listener);
        }

        @Override
        public void updateComponentsVisibility(int flags) {

            int visibility = (flags & SEARCH_VIEW_VISIBLE) == SEARCH_VIEW_VISIBLE
                    ? View.VISIBLE : View.INVISIBLE;
            mSearchOrbView.setVisibility(visibility);
        }
    };

    public CustomTitleView(Context context) {

        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {

        this(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        View root = LayoutInflater.from(context).inflate(R.layout.custom_titleview, this);
        mTitleView = root.findViewById(R.id.title_tv);
        mLogoView = root.findViewById(R.id.logo);
        mSearchOrbView = root.findViewById(R.id.search_orb);
    }

    public void setTitle(CharSequence title) {

        if (title != null) {

            mTitleView.setText(title);
            mTitleView.setVisibility(View.VISIBLE);
            mLogoView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public TitleViewAdapter getTitleViewAdapter() {

        return mTitleViewAdapter;
    }
}