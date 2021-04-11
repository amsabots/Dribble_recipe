package com.andymwebi.recipepro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.andymwebi.recipepro.Adapter.InstructionsAdapater;
import com.andymwebi.recipepro.Pojo.InstructionsList;
import com.andymwebi.recipepro.Pojo.RecipeList;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetails extends AppCompatActivity {
    private static final String TAG = "RecipeDetails";
    private InstructionsAdapater adapater;
    private List<InstructionsList> mainList;
    private RecyclerView recyclerView;
    private ImageView banner, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        Intent intent = getIntent();
        RecipeList recipeList = intent.getParcelableExtra(Constants.RECIPENAME);
        Log.i(TAG, "onCreate: " + recipeList.toString());

        mainList = new ArrayList<>();
        adapater = new InstructionsAdapater(mainList, this);

        recyclerView = findViewById(R.id.instructions_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapater);


        back = findViewById(R.id.recipeDetails_imageView_back);
        banner = findViewById(R.id.recipeDetails_imageView_banner);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeDetails.this, MainActivity.class));
            }
        });

        for (int i = 1; i < 10; i++) {
            InstructionsList list = new InstructionsList(1, i + 1, 1, "Prepare garlic, cut onions and smash them using standard kitchen electric smasher");
            mainList.add(list);
        }
        adapater.addItems(mainList);
    }
}