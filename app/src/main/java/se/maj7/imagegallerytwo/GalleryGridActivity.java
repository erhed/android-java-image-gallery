package se.maj7.imagegallerytwo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import se.maj7.imagegallerytwo.helper.GridSpacingItemDecoration;

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

        int spanCount = 2;
        int spacing = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        boolean includeEdge = true;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentMenuGrid);
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}
