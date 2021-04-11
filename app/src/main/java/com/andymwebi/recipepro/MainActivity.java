package com.andymwebi.recipepro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.andymwebi.recipepro.Adapter.RecipeAdapter;
import com.andymwebi.recipepro.Pojo.RecipeList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeItemClickListener{

    private RecipeAdapter adapter;
    private List<RecipeList> mainList;
    private RecyclerView recyclerView;
    private RecipeAdapter.OnRecipeItemClickListener recipeItemClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mainList = new ArrayList<>();
       adapter = new RecipeAdapter(this, mainList);
       recipeItemClickListener = this;

       recyclerView = findViewById(R.id.main_recipe_recyclerView);
       recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
       recyclerView.setHasFixedSize(true);
       recyclerView.setAdapter(adapter);

       adapter.setOnRecipeItemClickListiner(recipeItemClickListener);

        for (int i = 0; i<10; i++){
            RecipeList list = new RecipeList("", "Fried rice", "30 Minutes | Easy Meal", i);
            mainList.add(list);
        }
        adapter.addItems(mainList);
    }


    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(this, RecipeDetails.class);
        intent.putExtra(Constants.RECIPENAME, mainList.get(position));
        startActivity(intent);
    }
}