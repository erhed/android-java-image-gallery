package se.maj7.imagegallerytwo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GalleryGridAdapter extends RecyclerView.Adapter<GalleryGridAdapter.ListItemHolder> {

    //private List<Note> mNoteList;
    private GalleryGridActivity mActivity;

    public GalleryGridAdapter(GalleryGridActivity activity) {

        mActivity = activity;
        //mNoteList = noteList;
    }

    @NonNull
    @Override
    public GalleryGridAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grid, parent, false);

        return new ListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryGridAdapter.ListItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class ListItemHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView mTitle;
        TextView mDescription;
        TextView mStatus;

        public ListItemHolder(View view) {
            super(view);

            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //mActivity.showNote(getAdapterPosition());
        }
    }
}
