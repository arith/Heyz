package codetech.my.heyz.ViewFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import codetech.my.heyz.Adapter.ProfileTimeLineAdapter;
import codetech.my.heyz.Adapter.ProfileTimeLineArray;
import codetech.my.heyz.Adapter.TimelinePersonAdapter;
import codetech.my.heyz.Adapter.TimelinePersonArray;
import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class ProfileFragment extends Fragment {

    ArrayList<ProfileTimeLineArray> items = new ArrayList<ProfileTimeLineArray>();
    ProfileTimeLineAdapter adapter;
    ListView lview;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = (View) inflater.inflate(R.layout.profilefragmentactivity, container, false);
        ImageView mAvatar = (ImageView) v.findViewById(R.id.mAvatar);
        Picasso.with(getActivity()).load("http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg").fit() .transform(DefaultFactory.default_transformation).into(mAvatar);
        lview = (ListView) v.findViewById(R.id.lview);

        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));

        adapter = new ProfileTimeLineAdapter(getActivity(), items);
        lview.setAdapter(adapter);

        return v;
    }
}
