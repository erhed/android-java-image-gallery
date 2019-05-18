package se.maj7.imagegallerytwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class GalleryGridActivity extends AppCompatActivity {

    private GalleryGridAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_grid);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        // RecyclerView

        recyclerView = (RecyclerView)
                findViewById(R.id.recyclerViewGrid);

        mAdapter = new GalleryGridAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);
    }
}
