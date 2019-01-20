package br.com.leonardo.waller.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.leonardo.waller.R;

/**
 * Created by Leonardo de Matos on 18/06/17.
 */

public class TagAdapter extends RecyclerView.Adapter<TagViewHolder> {
    private List<String> mTags;

    public TagAdapter(List<String> tags) {
        this.mTags = tags;
    }

    @Override
    public TagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TagViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, int position) {
        ((TextView) holder.itemView).setText(mTags.get(position));
    }

    @Override
    public int getItemCount() {
        return mTags.size();
    }
}

class TagViewHolder extends RecyclerView.ViewHolder {
    TagViewHolder(View itemView) {
        super(itemView);
    }
}