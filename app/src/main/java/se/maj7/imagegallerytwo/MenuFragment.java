package se.maj7.imagegallerytwo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MenuFragment extends Fragment implements View.OnClickListener {

    private static final int IMAGE_FROM_GALLERY = 1;
    private static final int IMAGE_FROM_CAMERA = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ImageView viewList = (ImageView) view.findViewById(R.id.imageList);
        viewList.setOnClickListener(this);
        ImageView viewGrid = (ImageView) view.findViewById(R.id.imageGrid);
        viewGrid.setOnClickListener(this);
        ImageView getImageCamera = (ImageView) view.findViewById(R.id.imageCamera);
        getImageCamera.setOnClickListener(this);
        ImageView getImageGallery = (ImageView) view.findViewById(R.id.imageGallery);
        getImageGallery.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageList:
                Intent toList = new Intent(getContext(), GalleryListActivity.class);
                startActivity(toList);
                getActivity().overridePendingTransition(0, 0);
                break;
            case R.id.imageGrid:
                Intent toGrid = new Intent(getContext(), GalleryGridActivity.class);
                startActivity(toGrid);
                getActivity().overridePendingTransition(0, 0);
                break;
            case R.id.imageCamera:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, IMAGE_FROM_CAMERA);
                break;
            case R.id.imageGallery:
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");
                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                startActivityForResult(chooserIntent, IMAGE_FROM_GALLERY);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        requestCode = requestCode & 0x0000ffff;
        Log.i("UNMASKED", String.valueOf(requestCode));

        // Image from gallery
        if (requestCode == IMAGE_FROM_GALLERY) {
            if (resultCode == getActivity().RESULT_OK) {
                if (intent != null) {
                    final Uri uri = intent.getData();
                    useImage(uri);
                }
            }
            super.onActivityResult(requestCode, resultCode, intent);
        }

        // Image from camera
        if (requestCode == IMAGE_FROM_CAMERA) {
            if (resultCode == getActivity().RESULT_OK) {
                if (intent != null) {
                    final Uri uri = intent.getData();
                    useImage(uri);
                }
            }
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }

    void useImage(Uri uri) {
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
        //use the bitmap as you like
        //imageView.setImageBitmap(bitmap);
        Log.i("IMAGE PICKED FROM GALLERY", "YEAH");
    }
}
