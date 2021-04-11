package com.andymwebi.recipepro;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class ViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<T> list;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return setViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder(holder, list.get(position));
    }

    public ViewAdapter(List<T> list) {
        this.list = list;
    }

    public abstract RecyclerView.ViewHolder setViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, T val);

    public void addItems(List<T> localList){
        this.list = localList;
        notifyDataSetChanged();
    }

    public T getItemAtPosition(int position){
        return this.list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
