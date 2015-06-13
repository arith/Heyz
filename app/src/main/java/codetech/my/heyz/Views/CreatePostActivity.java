package codetech.my.heyz.Views;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import org.apache.http.Header;
import org.json.JSONObject;

import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class CreatePostActivity extends ActionBarActivity {

    private ActionBar actbar;
    DefaultFactory mFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpostactivity);
        setupMyActionBar();
        mFactory = new DefaultFactory(getApplicationContext());
        final Spinner mCategory = (Spinner) findViewById(R.id.mCategory);
        final EditText mStatus = (EditText) findViewById(R.id.mStatus);
        final Button mSubmit = (Button) findViewById(R.id.btnCreate);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient client2 = new AsyncHttpClient();
                RequestParams params2 = new RequestParams();
                params2.add("auth", "abc123");
                params2.add("method", "postnew");
                params2.add("status", mStatus.getText().toString());
                params2.add("userid", mFactory.getUserId());
                client2.post(DefaultFactory.mApiUrl, params2, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        try{
                            if(response.getBoolean("response")) {
                              Toast.makeText(getApplicationContext(), "Interest posted", Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(getApplicationContext(), DefaultActivity.class));
                              finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Posting status failed", Toast.LENGTH_SHORT).show();
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Posting status failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        Toast.makeText(getApplicationContext(), "Posting status failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


     }

    public void setupMyActionBar() {
        //actbar = getSupportActionBar();
        //actbar.setTitle("Create new post");
        //actbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009688")));
    }


}