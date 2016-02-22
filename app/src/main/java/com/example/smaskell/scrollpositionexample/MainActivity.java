package com.example.smaskell.scrollpositionexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list = (ListView) findViewById(R.id.list_view);
        final int numItems = 20;
        String[] items = new String[numItems];
        for (int i = 0; i < numItems; i++) {
            items[i] = "Item " + i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, items);
        list.setAdapter(adapter);
        findViewById(R.id.set_selection_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.setSelectionFromTop(5, 0);
                // This will still return the old top value because setSelectionFromTop is not done
                // updating the view yet. There is no good way to tell when it finishes
                Toast.makeText(MainActivity.this, "getFirstVisiblePosition: " + list.getFirstVisiblePosition(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
