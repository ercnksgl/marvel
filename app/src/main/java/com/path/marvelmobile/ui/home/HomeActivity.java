package com.path.marvelmobile.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        setToolbarTitle();

        addFragment(HomeFragment.newInstance());
    }

    private void setToolbarTitle(){
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(getText(R.string.title_home));
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