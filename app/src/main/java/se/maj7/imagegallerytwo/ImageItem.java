package se.maj7.imagegallerytwo;

import android.graphics.Bitmap;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageItem {

    private String mTitle;
    private Bitmap mImage;
    private Date mDateCreated;

    public void ImageItem(String title, Bitmap image) {
        mTitle = title;
        mImage = image;
        mDateCreated = new Date();
    }

    // GET

    public String getTitle() {
        return mTitle;
    }

    public Bitmap getImage() {
        return mImage;
    }

    public Date getDate() {
        return mDateCreated;
    }

    public String getDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(mDateCreated);
    }

    // SET

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setImage(Bitmap image) {
        mImage = image;
    }
}
