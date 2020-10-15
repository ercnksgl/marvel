package com.path.marvelmobile.ui.home;

import android.os.Bundle;

import com.path.marvelmobile.R;
import com.path.marvelmobile.ui.base.BaseActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.appBar);
        toolbar.setTitle(getString(R.string.title_home));
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        addFragment(HomeFragment.newInstance());

    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(fragment.getClass().getName())
                .add(R.id.container, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }
}