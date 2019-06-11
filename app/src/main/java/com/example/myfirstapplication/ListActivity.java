package com.example.myfirstapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerList = (RecyclerView) findViewById(R.id.recyclerList);

        TextView title = (TextView) findViewById(R.id.titleUser);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            String titleUser = bundle.getString("User");
            title.setText("Bienvenido " + titleUser);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerList.setLayoutManager(linearLayoutManager);
        recyclerList.setAdapter(new AdapterList(getFakeData()));
    }

    private List<BasicPojo> getFakeData() {
        List<BasicPojo> basicPojos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            basicPojos.add(new BasicPojo("Esteban " + i, "Aragon"));
        }
        return basicPojos;
    }
}
