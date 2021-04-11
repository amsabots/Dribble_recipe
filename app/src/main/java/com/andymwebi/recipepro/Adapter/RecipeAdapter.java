package com.andymwebi.recipepro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andymwebi.recipepro.Pojo.RecipeList;
import com.andymwebi.recipepro.R;
import com.andymwebi.recipepro.ViewAdapter;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecipeAdapter extends ViewAdapter<RecipeList> {
    private List<RecipeList> list;
    private final Context context;
    private OnRecipeItemClickListener listener;

    public RecipeAdapter(Context context, List<RecipeList> list) {
        super(list);
        this.list = list;
        this.context = context;
    }

    public void setOnRecipeItemClickListiner(OnRecipeItemClickListener listiner) {
        this.listener = listiner;
    }

    @Override
    public RecyclerView.ViewHolder setViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.card_cook_viewer, parent, false);
        return new ViewItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, RecipeList val) {
        ViewItem viewItem = (ViewItem) holder;
        viewItem.recipeName.setText(val.getRecipeName());
        viewItem.cookTime.setText(val.getCookTime());
        viewItem.imageView.setImageResource(R.drawable.food_recipe);
    }


    private class ViewItem extends RecyclerView.ViewHolder {
        TextView recipeName, cookTime;
        CircleImageView imageView;

        public ViewItem(@NonNull View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipeName);
            cookTime = itemView.findViewById(R.id.cookTime);
            imageView = itemView.findViewById(R.id.recipes_images);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) if (getAdapterPosition() != RecyclerView.NO_POSITION)
                        listener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }


    public interface OnRecipeItemClickListener {
        void OnItemClick(int position);
    }

}
