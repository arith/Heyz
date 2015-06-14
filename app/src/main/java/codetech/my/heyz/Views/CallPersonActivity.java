package codetech.my.heyz.Views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;
import com.twilio.client.Device;
import com.twilio.client.Twilio;

import java.util.HashMap;
import java.util.Map;

import codetech.my.heyz.Factory.CallListenerClient;
import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;

/**
 * Created by kamarulzaman on 6/14/15.
 */
public class CallPersonActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callpersonactivity);
        Intent myintent = getIntent();

        final ImageView mAvatar = (ImageView) findViewById(R.id.mAvatar);
        final TextView mName = (TextView) findViewById(R.id.mName);
        final TextView mTime = (TextView) findViewById(R.id.mTime);

        Picasso.with(getApplicationContext()).load(myintent.getStringExtra("mAvatar")).fit() .transform(DefaultFactory.default_transformation).into(mAvatar);
        mName.setText(myintent.getStringExtra("mName"));


    }

}
