package codetech.my.heyz.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


import codetech.my.heyz.R;

//import com.huawei.*;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class SignInActivity extends ActionBarActivity {

    private Button mBtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinactivity);

        mBtnSignIn = (Button) findViewById(R.id.BtnsignIn);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DefaultActivity.class));
            }
        });

    }
}
