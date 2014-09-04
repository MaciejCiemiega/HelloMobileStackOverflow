package com.example.hellomobilestackoverflow.model;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a Question from StackOverflow API, supporting {@link Parcelable} interface.
 * @author Maciej
 */
public class Question implements Parcelable {

	public List<String> tags;

	public User owner;

	@SerializedName("is_answered")
	public boolean isAnswered;

	@SerializedName("view_count")
	public int viewCount;

	@SerializedName("answer_count")
	public int answerCount;

	public int score;

	@SerializedName("last_activity_date")
	public long lastActivityDate;

	@SerializedName("creation_date")
	public long creationDate;

	@SerializedName("last_edit_date")
	public long lastEditDate;

	@SerializedName("question_id")
	public long questionId;

	public String link;

	public String title;
	
	public Question() {
	}
	
    protected Question(Parcel in) {
        if (in.readByte() == 0x01) {
            tags = new ArrayList<String>();
            in.readList(tags, String.class.getClassLoader());
        } else {
            tags = null;
        }
        owner = (User) in.readValue(User.class.getClassLoader());
        isAnswered = in.readByte() != 0x00;
        viewCount = in.readInt();
        answerCount = in.readInt();
        score = in.readInt();
        lastActivityDate = in.readLong();
        creationDate = in.readLong();
        lastEditDate = in.readLong();
        questionId = in.readLong();
        link = in.readString();
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (tags == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(tags);
        }
        dest.writeValue(owner);
        dest.writeByte((byte) (isAnswered ? 0x01 : 0x00));
        dest.writeInt(viewCount);
        dest.writeInt(answerCount);
        dest.writeInt(score);
        dest.writeLong(lastActivityDate);
        dest.writeLong(creationDate);
        dest.writeLong(lastEditDate);
        dest.writeLong(questionId);
        dest.writeString(link);
        dest.writeString(title);
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
