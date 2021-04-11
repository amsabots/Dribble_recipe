package com.andymwebi.recipepro.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class RecipeList implements Parcelable {
    private String imageUri, recipeName, cookTime;
    private int id;

    public RecipeList(String imageUri, String recipeName, String cookTime, int id) {
        this.imageUri = imageUri;
        this.recipeName = recipeName;
        this.cookTime = cookTime;
        this.id = id;
    }

    protected RecipeList(Parcel in) {
        imageUri = in.readString();
        recipeName = in.readString();
        cookTime = in.readString();
        id = in.readInt();
    }

    public static final Creator<RecipeList> CREATOR = new Creator<RecipeList>() {
        @Override
        public RecipeList createFromParcel(Parcel in) {
            return new RecipeList(in);
        }

        @Override
        public RecipeList[] newArray(int size) {
            return new RecipeList[size];
        }
    };

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeList that = (RecipeList) o;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "RecipeList{" +
                "imageUri='" + imageUri + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUri);
        dest.writeString(recipeName);
        dest.writeString(cookTime);
        dest.writeInt(id);
    }
}
