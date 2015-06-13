package codetech.my.heyz.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import codetech.my.heyz.Adapter.ProfileTimeLineAdapter;
import codetech.my.heyz.Adapter.ProfileTimeLineArray;
import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;

/**
 * Created by kamarulzaman on 6/14/15.
 */
public class UserProfileActivity extends ActionBarActivity {

    ArrayList<ProfileTimeLineArray> items = new ArrayList<ProfileTimeLineArray>();
    ProfileTimeLineAdapter adapter;
    ListView lview;
    DefaultFactory mFactory;
    String muserid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofileactivity);
        mFactory = new DefaultFactory(getApplicationContext());
        final ImageView mAvatar = (ImageView) findViewById(R.id.mAvatar);
        Picasso.with(getApplicationContext()).load("http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg").fit() .transform(DefaultFactory.default_transformation).into(mAvatar);
        lview = (ListView) findViewById(R.id.lview);

        Intent myintent = getIntent();
        muserid = myintent.getStringExtra("userid");
        /*
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        */

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("auth", "abc123");
        params.add("method", "getstatus");
        params.add("userid", muserid);
        client.post(DefaultFactory.mApiUrl, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try{
                    if(response.getBoolean("response")) {
                        JSONArray jarray = response.getJSONArray("data");
                        if(jarray.length() > 0) {
                            for(int i = 0; i < jarray.length(); i++)
                            {
                                JSONObject jobject = jarray.getJSONObject(i);
                                items.add(new ProfileTimeLineArray(jobject.getString("userid"), jobject.getString("fullname"), jobject.getString("status"), jobject.getString("avatar"), jobject.getString("posttime"), true));
                            }
                            adapter = new ProfileTimeLineAdapter(getApplicationContext(), items);
                            lview.setAdapter(adapter);
                            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                                }
                            });

                        } else {
                            Toast.makeText(getApplicationContext(), "No interest found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "No interest found", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Getting interest failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getApplicationContext(), "Getting interest failed", Toast.LENGTH_SHORT).show();
            }
        });


        AsyncHttpClient client2 = new AsyncHttpClient();
        RequestParams params2 = new RequestParams();
        params2.add("auth", "abc123");
        params2.add("method", "getuserdata");
        params2.add("userid", muserid);
        client2.post(DefaultFactory.mApiUrl, params2, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try{
                    if(response.getBoolean("response")) {
                        Picasso.with(getApplicationContext()).load(response.getString("avatar")).fit() .transform(DefaultFactory.default_transformation).into(mAvatar);
                        TextView mText = (TextView) findViewById(R.id.mName);
                        mText.setText(response.getString("fullname"));
                        TextView mStatus = (TextView) findViewById(R.id.mStatus);
                        mStatus.setText(response.getString("status"));
                    } else {
                        Toast.makeText(getApplicationContext(), "Getting profile info failed", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Getting profile info failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getApplicationContext(), "Getting profile info failed", Toast.LENGTH_SHORT).show();
            }
        });


        adapter = new ProfileTimeLineAdapter(getApplicationContext(), items);
        lview.setAdapter(adapter);
        Button mButton = (Button) findViewById(R.id.addHeyz);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreatePostActivity.class));
            }
        });
    }
}
