package codetech.my.heyz.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import codetech.my.heyz.Factory.DefaultFactory;
import codetech.my.heyz.R;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class ProfileTimeLineAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ProfileTimeLineArray> mItems = new ArrayList<ProfileTimeLineArray>();

    public ProfileTimeLineAdapter(Context context, ArrayList<ProfileTimeLineArray> items) {
        this.context = context;
        this.mItems = items;
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try{
            ViewHolder holder;
            try{
                ProfileTimeLineArray item = (ProfileTimeLineArray) this.getItem(position);

                if(convertView == null) {
                    holder = new ViewHolder();
                    LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView  = li.inflate(R.layout.profiletimeline_row, parent, false);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }

                holder.mId = (TextView) convertView.findViewById(R.id.mId);
                holder.mName = (TextView) convertView.findViewById(R.id.mName);
                holder.mStatus = (TextView) convertView.findViewById(R.id.mStatus);
                holder.mAvatar = (ImageView) convertView.findViewById(R.id.mAvatar);
                holder.mDateTime = (TextView) convertView.findViewById(R.id.mDateTime);

                holder.mId.setText(item.getmId());
                holder.mName.setText(item.getName());
                holder.mStatus.setText(item.getStatus());
                holder.mAvatar.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher));
                holder.mDateTime.setText(item.getDateTime());

                if(item.getisArchive()) {

                }

                Picasso.with(context).load(item.getAvatar()).fit() .transform(DefaultFactory.default_transformation).into(holder.mAvatar);

                return convertView;
            } catch(Exception e) {
                e.printStackTrace();
                return convertView;
            }
        } catch(Exception e) {
            return convertView;
        }
    }

    private class ViewHolder{
        TextView mId;
        TextView mName;
        TextView mStatus;
        TextView mDateTime;
        ImageView mAvatar;
    }
}
