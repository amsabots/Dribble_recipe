package com.andymwebi.recipepro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andymwebi.recipepro.Pojo.InstructionsList;
import com.andymwebi.recipepro.R;
import com.andymwebi.recipepro.ViewAdapter;

import java.util.List;

public class InstructionsAdapater extends ViewAdapter<InstructionsList> {
    private List<InstructionsList> list;
    private Context context;

    public InstructionsAdapater(List<InstructionsList> list, Context context) {
        super(list);
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder setViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipe_instructions, parent, false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, InstructionsList val) {
     ItemView itemHolder = (ItemView)holder;
     itemHolder.instructions.setText(val.getInstructions());
     itemHolder.number.setText(String.valueOf(val.getNumber()));
    }

    private class ItemView extends RecyclerView.ViewHolder{
     private TextView number, instructions;
        public ItemView(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.instructions_numbering);
            instructions = itemView.findViewById(R.id.instructions_instructions);
        }
    }
}
