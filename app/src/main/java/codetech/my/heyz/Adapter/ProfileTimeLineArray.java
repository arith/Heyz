package codetech.my.heyz.Adapter;

/**
 * Created by kamarulzaman on 6/13/15.
 */
public class ProfileTimeLineArray {
    private String mId, mName, mStatus, mAvatar, mDateTime;
    private boolean isArchive = false;

    public ProfileTimeLineArray(String mId, String mName, String mStatus, String mAvatar, String mDateTime, boolean isArchive) {
        this.mId = mId;
        this.mName = mName;
        this.mStatus = mStatus;
        this.mAvatar = mAvatar;
        this.mDateTime = mDateTime;
        this.isArchive = isArchive;
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

    public boolean getisArchive(){ return this.isArchive; }


}
