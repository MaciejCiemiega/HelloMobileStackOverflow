package com.example.hellomobilestackoverflow.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a User from StackOverflow API, supporting {@link Parcelable} interface.
 * @author Maciej
 */
public class User implements Parcelable {

	public int reputation;
	
	@SerializedName("user_id")
	public long userId;
	
	@SerializedName("user_type")
	public String userType;
	
	@SerializedName("profile_image")
	public String profileImage;
	
	@SerializedName("display_name")
	public String displayName;
	
	public String link;
    
	public User() {
	}
	
	protected User(Parcel in) {
        reputation = in.readInt();
        userId = in.readLong();
        userType = in.readString();
        profileImage = in.readString();
        displayName = in.readString();
        link = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(reputation);
        dest.writeLong(userId);
        dest.writeString(userType);
        dest.writeString(profileImage);
        dest.writeString(displayName);
        dest.writeString(link);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result	+ ((profileImage == null) ? 0 : profileImage.hashCode());
		result = prime * result + reputation;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result	+ ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (profileImage == null) {
			if (other.profileImage != null)
				return false;
		} else if (!profileImage.equals(other.profileImage))
			return false;
		if (reputation != other.reputation)
			return false;
		if (userId != other.userId)
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
}
