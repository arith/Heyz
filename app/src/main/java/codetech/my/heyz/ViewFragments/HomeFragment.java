package codetech.my.heyz.ViewFragments;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;
import codetech.my.heyz.Views.DefaultActivity;


/**
 * Created by kamarulzaman on 6/13/15.
 */
public class HomeFragment extends Fragment {
    MapView mview;
    GoogleMap gmap;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = (View) inflater.inflate(R.layout.homefragmentactivity, container, false);
        MapsInitializer.initialize(getActivity());
        mview = (MapView) v.findViewById(R.id.map);
        mview.onCreate(savedInstanceState);
        mview.onResume();
        gmap = mview.getMap();
        gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        gmap.setMyLocationEnabled(true);
        Location loc = gmap.getMyLocation();
        gmap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
               gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 12.0f));
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("auth", "abc123");
        params.add("method", "getmap");
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
                             Marker mker =  gmap.addMarker(new MarkerOptions().position(new LatLng(jobject.getDouble("lat"), jobject.getDouble("long"))).title(jobject.getString("status")).snippet(jobject.getString("fullname")));
                         }
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
