package codetech.my.heyz.Views;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import codetech.my.heyz.R;
import codetech.my.heyz.ViewFragments.HomeFragment;
import codetech.my.heyz.ViewFragments.ProfileFragment;
import codetech.my.heyz.ViewFragments.TimeLineFragment;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class DefaultActivity extends ActionBarActivity {

    private Toolbar mToolBar;
    private ActionBar actbar;
    GoogleCloudMessaging gcm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defaultactivity);
        mToolBar = (Toolbar) findViewById(R.id.mToolBar);
        setupActionBar();
        //getRegId();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.menu_home, HomeFragment.class)
                .add(R.string.menu_timeline, TimeLineFragment.class)
                .add(R.string.menu_profile, ProfileFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

    }

    public void setupActionBar(){
        mToolBar.setTitle("");
        //mToolBar.setTitleTextColor(Color.parseColor("#D9000000"));
        setSupportActionBar(mToolBar);
        actbar = getSupportActionBar();

    }

    public void getRegId(){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                    }
                    try{
                        String regid = gcm.register("751989037298");
                        msg = "Device registered, registration ID=" + regid;
                        Log.i("GCM", msg);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                //etRegId.setText(msg + "\n");
            }
        }.execute(null, null, null);
    }
}
