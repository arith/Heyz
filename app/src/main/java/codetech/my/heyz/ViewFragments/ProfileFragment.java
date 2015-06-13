package codetech.my.heyz.ViewFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import codetech.my.heyz.Adapter.TimelinePersonAdapter;
import codetech.my.heyz.Adapter.TimelinePersonArray;
import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;
import codetech.my.heyz.Views.CreatePostActivity;
import codetech.my.heyz.Views.DefaultActivity;
import codetech.my.heyz.Views.UserProfileActivity;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class ProfileFragment extends Fragment {

    ArrayList<ProfileTimeLineArray> items = new ArrayList<ProfileTimeLineArray>();
    ProfileTimeLineAdapter adapter;
    ListView lview;
    DefaultFactory mFactory;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFactory = new DefaultFactory(getActivity());
        final View v = (View) inflater.inflate(R.layout.profilefragmentactivity, container, false);
        final ImageView mAvatar = (ImageView) v.findViewById(R.id.mAvatar);
        Picasso.with(getActivity()).load("http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg").fit() .transform(DefaultFactory.default_transformation).into(mAvatar);
        lview = (ListView) v.findViewById(R.id.lview);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("auth", "abc123");
        params.add("method", "getstatus");
        params.add("userid", mFactory.getUserId());
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
                                items.add(new ProfileTimeLineArray("1", jobject.getString("fullname"), jobject.getString("status"), jobject.getString("avatar"), jobject.getString("posttime"), true));
                            }
                            adapter = new ProfileTimeLineAdapter(getActivity(), items);
                            lview.setAdapter(adapter);
                            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    startActivity(new Intent(getActivity(), UserProfileActivity.class));
                                }
                            });

                        } else {
                            Toast.makeText(getActivity(), "No interest found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "No interest found", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Getting interest failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getActivity(), "Getting interest failed", Toast.LENGTH_SHORT).show();
            }
        });


        AsyncHttpClient client2 = new AsyncHttpClient();
        RequestParams params2 = new RequestParams();
        params2.add("auth", "abc123");
        params2.add("method", "getuserdata");
        params2.add("userid", mFactory.getUserId());
        client2.post(DefaultFactory.mApiUrl, params2, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try{
                    if(response.getBoolean("response")) {
                        Picasso.with(getActivity()).load(response.getString("avatar")).fit() .transform(DefaultFactory.default_transformation).into(mAvatar);
                        TextView mText = (TextView) v.findViewById(R.id.mName);
                        mText.setText(response.getString("fullname"));
                        TextView mStatus = (TextView) v.findViewById(R.id.mStatus);
                        mStatus.setText(response.getString("status"));
                    } else {
                        Toast.makeText(getActivity(), "Getting profile info failed", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Getting profile info failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getActivity(), "Getting profile info failed", Toast.LENGTH_SHORT).show();
            }
        });

        Button addHeyz = (Button) v.findViewById(R.id.addHeyz);
        addHeyz.setText("Account Settings");

        adapter = new ProfileTimeLineAdapter(getActivity(), items);
        lview.setAdapter(adapter);
        Button mButton = (Button) v.findViewById(R.id.addHeyz);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CreatePostActivity.class));
            }
        });

        return v;
    }
}
