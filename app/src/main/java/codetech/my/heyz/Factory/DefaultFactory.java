package codetech.my.heyz.Factory;

import android.graphics.Color;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Transformation;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class DefaultFactory {

    public static final String mMyPhoneNumber = "+601546010184";
    public static final String mMyPassword = "Huawei1234";

    public static final Transformation default_transformation = new RoundedTransformationBuilder()
            .borderColor(Color.BLACK)
            .borderWidthDp(0)
            .cornerRadiusDp(30)
            .oval(false)
            .build();
}
