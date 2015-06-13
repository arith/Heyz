package codetech.my.heyz.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofileactivity);
        ImageView mAvatar = (ImageView) findViewById(R.id.mAvatar);
        Picasso.with(getApplicationContext()).load("http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg").fit() .transform(DefaultFactory.default_transformation).into(mAvatar);
        lview = (ListView) findViewById(R.id.lview);

        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));
        items.add(new ProfileTimeLineArray("1", "Ahmad Said", "Saya suka makan ayam goreng", "http://images.huffingtonpost.com/2013-06-15-moviesmanofsteelhenrycavillsuperman.jpg", "12:02 PM", false));

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
