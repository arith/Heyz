package codetech.my.heyz.Adapter;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class TimelinePersonArray {
    private String mId, mName, mStatus, mAvatar, mDateTime, mDistance;
    private boolean isSelf;

    public TimelinePersonArray(String mId, String mName, String mStatus, String mAvatar, String mDateTime, String mDistance, boolean isSelf) {
        this.mId = mId;
        this.mName = mName;
        this.mStatus = mStatus;
        this.mAvatar = mAvatar;
        this.mDateTime = mDateTime;
        this.mDistance = mDistance;
        this.isSelf = isSelf;
    }

    public String getmId(){
        return this.mId;
    }

    public String getName(){
        return this.mName;
    }

    public String getStatus(){
        return this.mStatus;
    }

    public String getAvatar(){
        return this.mAvatar;
    }

    public String getDateTime(){ return this.mDateTime;  }

    public String getDistance(){ return this.mDistance; }

    public boolean getisSelf() { return this.isSelf; }


}
