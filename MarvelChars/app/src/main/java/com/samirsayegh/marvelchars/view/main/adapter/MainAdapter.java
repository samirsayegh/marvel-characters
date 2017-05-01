package com.samirsayegh.marvelchars.view.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samirsayegh.marvelchars.R;
import com.samirsayegh.marvelchars.domain.entities.Hero;
import com.samirsayegh.marvelchars.domain.entities.Thumbnail;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private MainAdapterListener mainAdapterListener;
    private List<Hero> list;

    public void setNewList(List<Hero> list) {
        this.list = list;
    }

    public void setAddToList(List<Hero> heroList) {
        list.addAll(heroList);
    }

    public void setMainAdapterListener(MainAdapterListener mainAdapterListener) {
        this.mainAdapterListener = mainAdapterListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_picture_name_description, parent, false);
        view.setOnClickListener(mainAdapterListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hero hero = list.get(position);
        if (hero != null) {
            holder.textViewName.setText(hero.getName());
            holder.textViewDescription.setText(hero.getDescription());
            Picasso.with(holder.imageView.getContext())
                    .load(hero.getThumbnail(Thumbnail.LANDSCAPE_MEDIUM))
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public Hero getHero(int position) {
        return list != null && list.size() > position ? list.get(position) : null;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageViewPictureNameDescription)
        ImageView imageView;
        @BindView(R.id.textViewPictureNameDescriptionName)
        TextView textViewName;
        @BindView(R.id.textViewPictureNameDescriptionDescription)
        TextView textViewDescription;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
