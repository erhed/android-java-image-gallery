package se.maj7.imagegallerytwo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.ListItemHolder> {

    //private List<Note> mNoteList;
    private GalleryListActivity mActivity;

    public GalleryListAdapter(GalleryListActivity activity) {

        mActivity = activity;
        //mNoteList = noteList;
    }

    @NonNull
    @Override
    public GalleryListAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new ListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryListAdapter.ListItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
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
