package codetech.my.heyz.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;

import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;

//import com.huawei.*;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class SignInActivity extends ActionBarActivity {

    private Button mBtnSignIn;
    DefaultFactory mFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinactivity);
        mFactory = new DefaultFactory(getApplicationContext());
        mFactory.setUserId("0");
        mFactory.setUserAvatar("0");
        mFactory.setUserName("0");


        final EditText mUsername = (EditText) findViewById(R.id.inputUsername);
        final EditText mPassword = (EditText) findViewById(R.id.inputPassword);

        mBtnSignIn = (Button) findViewById(R.id.BtnsignIn);
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams params = new RequestParams();
                params.add("auth", "abc123");
                params.add("method", "login");
                params.add("username", mUsername.getText().toString());
                params.add("password", mPassword.getText().toString());
                client.post(DefaultFactory.mApiUrl, params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        try{
                            if(response.getBoolean("response")) {
                                mFactory.setUserId(response.getString("userid"));
                                mFactory.setUserName(response.getString("fullname"));
                                mFactory.setUserAvatar(response.getString("avatar"));
                                startActivity(new Intent(getApplicationContext(), DefaultActivity.class));
                            } else {
                                Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
                            }
                        } catch(Exception e) {
                            Toast.makeText(getApplicationContext(), "Sign in failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(getApplicationContext(), "Sign in failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
