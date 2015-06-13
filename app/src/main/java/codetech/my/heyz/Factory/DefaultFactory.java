package codetech.my.heyz.Factory;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Transformation;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class DefaultFactory {

    public static final String mMyPhoneNumber = "+601546010184";
    public static final String mMyPassword = "Huawei1234";

    public static final String mApiUrl = "http://sudo.my/gcm/api.php";
    SharedPreferences sharedpref;
    Context context;

    public DefaultFactory(Context context){
        sharedpref = context.getSharedPreferences("hyez", Context.MODE_PRIVATE);
    }

    public static final Transformation default_transformation = new RoundedTransformationBuilder()
            .borderColor(Color.BLACK)
            .borderWidthDp(0)
            .cornerRadiusDp(30)
            .oval(false)
            .build();

    public String getUserId() {
        try{
            return sharedpref.getString("userid", "0");
        } catch(Exception e) {
            return "0";
        }
    }

    public void setUserId(String userId) {
        try{
            SharedPreferences.Editor edit = sharedpref.edit();
            edit.putString("userid", userId);
            edit.commit();
        } catch(Exception e) {
            //do nothing
        }
    }
}
