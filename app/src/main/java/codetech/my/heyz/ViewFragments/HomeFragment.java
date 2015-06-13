package codetech.my.heyz.ViewFragments;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import codetech.my.heyz.R;

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

        return v;
    }
}
