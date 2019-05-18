package se.maj7.imagegallerytwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentMenu extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ImageView listMode = (ImageView) view.findViewById(R.id.imageList);
        listMode.setOnClickListener(this);
        ImageView gridMode = (ImageView) view.findViewById(R.id.imageGrid);
        gridMode.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
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
        }
    }
}
