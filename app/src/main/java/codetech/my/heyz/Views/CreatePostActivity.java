package codetech.my.heyz.Views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import codetech.my.heyz.R;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class CreatePostActivity extends ActionBarActivity {

    private ActionBar actbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpostactivity);
        setupMyActionBar();
    }

    public void setupMyActionBar() {
        //actbar = getSupportActionBar();
        //actbar.setTitle("Create new post");
        //actbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009688")));
    }


}
