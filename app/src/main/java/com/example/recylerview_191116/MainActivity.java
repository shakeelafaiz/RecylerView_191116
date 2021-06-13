package com.example.recylerview_191116;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements RecylerViewAdapter.OnButtonClickListener {

    RecyclerView recyclerView;
    RecylerViewAdapter recylerViewAdapter;

   int[] images = {R.drawable.dp8, R.drawable.dp2, R.drawable.dp3, R.drawable.dp4,
                   R.drawable.dp2, R.drawable.dp, R.drawable.dp4, R.drawable.dp3,
                   R.drawable.dp5, R.drawable.dp6, R.drawable.dp7, R.drawable.dp8,
                   R.drawable.dp3, R.drawable.dp, R.drawable.dp2, R.drawable.dp7,
                   R.drawable.dp, R.drawable.dp4, R.drawable.dp8, R.drawable.dp2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.MainRecylerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recylerViewAdapter = new RecylerViewAdapter(images, this);
        recyclerView.setAdapter(recylerViewAdapter);

    }

    @Override
    public void OnDeleteButtonClick(int position){
        recylerViewAdapter.notifyItemRemoved(position);
     }
}