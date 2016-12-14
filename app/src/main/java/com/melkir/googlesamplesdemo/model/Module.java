package com.melkir.googlesamplesdemo.model;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import com.melkir.googlesamplesdemo.activity.DetailActivity;
import com.melkir.googlesamplesdemo.util.ActivityLauncher;

public class Module implements Parcelable {
    private final String mTitle, mDescription, mLink, mAction;
    private final String[] mCategories;
    private final int mPictureRsc;

    public Module(String title, String description, String link, String action,
                  String[] categories, int pictureRsc) {
        this.mTitle = title;
        this.mDescription = description;
        this.mLink = link;
        this.mAction = action;
        this.mCategories = categories;
        this.mPictureRsc = pictureRsc;
    }

    private Module(Parcel in) {
        mTitle = in.readString();
        mDescription = in.readString();
        mLink = in.readString();
        mAction = in.readString();
        mCategories = in.createStringArray();
        mPictureRsc = in.readInt();
    }

    public static final Creator<Module> CREATOR = new Creator<Module>() {
        @Override
        public Module createFromParcel(Parcel in) {
            return new Module(in);
        }

        @Override
        public Module[] newArray(int size) {
            return new Module[size];
        }
    };

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLink() {
        return mLink;
    }

    public String getAction() {
        return mAction;
    }

    public int getPicture() {
        return mPictureRsc;
    }

    public String[] getCategories() {
        return mCategories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mDescription);
        parcel.writeString(mLink);
        parcel.writeString(mAction);
        parcel.writeStringArray(mCategories);
        parcel.writeInt(mPictureRsc);
    }

    public void onCardClick(View view, Module module) {
        final Context context = view.getContext();
        final Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DetailActivity.MODULE, module);
        context.startActivity(intent);
    }

    public void onLaunchClick(View view, String action) {
        ActivityLauncher.start(view.getContext(), action);
    }

}
