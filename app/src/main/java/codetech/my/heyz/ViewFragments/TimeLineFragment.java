package codetech.my.heyz.ViewFragments;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

import java.util.ArrayList;

import codetech.my.heyz.Adapter.TimelinePersonAdapter;
import codetech.my.heyz.Adapter.TimelinePersonArray;
import codetech.my.heyz.R;

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

        items.add(new TimelinePersonArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", "10m"));
        items.add(new TimelinePersonArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", "120m"));
        items.add(new TimelinePersonArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", "100km"));
        items.add(new TimelinePersonArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", "22km"));
        items.add(new TimelinePersonArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", "14km"));
        items.add(new TimelinePersonArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", "120m"));

        adapter = new TimelinePersonAdapter(getActivity(), items);
        lview.setAdapter(adapter);

        return v;
    }
}
