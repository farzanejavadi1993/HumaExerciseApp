package com.huma.exerciseapp.view;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.huma.exerciseapp.R;
import com.huma.exerciseapp.classes.TypefaceUtil;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF",
                "IRANSans.ttf");

       //region Call MainFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }
        //endregion Call MainFragment
    }
}