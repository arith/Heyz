package codetech.my.heyz.ViewFragments;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import codetech.my.heyz.Adapter.TimelinePersonAdapter;
import codetech.my.heyz.Adapter.TimelinePersonArray;
import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;
import codetech.my.heyz.Views.CreatePostActivity;
import codetech.my.heyz.Views.UserProfileActivity;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class TimeLineFragment extends Fragment {

    ArrayList<TimelinePersonArray> items = new ArrayList<TimelinePersonArray>();
    TimelinePersonAdapter adapter;
    ListView lview;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = (View) inflater.inflate(R.layout.timelinefragmentactivity, container, false);
        lview = (ListView) v.findViewById(R.id.lview);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("auth", "abc123");
        params.add("method", "getmap2");
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
                                items.add(new TimelinePersonArray("1", jobject.getString("fullname"), jobject.getString("status"), jobject.getString("avatar"), jobject.getString("datetime"), jobject.getString("distance"), true));
                            }
                            adapter = new TimelinePersonAdapter(getActivity(), items);
                            lview.setAdapter(adapter);
                            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    startActivity(new Intent(getActivity(), UserProfileActivity.class));
                                }
                            });

                        } else {
                            Toast.makeText(getActivity(), "No interest people found nearby", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "No interest people found nearby", Toast.LENGTH_SHORT).show();
                    }
                } catch(Exception e) {
                    Toast.makeText(getActivity(), "Getting nearby interest failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(getActivity(), "Getting nearby interest failed", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }
}
