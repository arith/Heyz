package codetech.my.heyz.Views;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

import codetech.my.heyz.R;

/**
 * Created by kamarulzaman on 6/14/15.
 */
public class RegisterGCMActivity extends ActionBarActivity {
    GoogleCloudMessaging gcm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defaultactivity);
        //getRegId();
    }


}
