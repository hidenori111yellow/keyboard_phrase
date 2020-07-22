package com.example.keyboard_phrase;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class KeyboardActivity extends AppCompatActivity {

    private List<String> texts = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard);

        GridView gridView = (GridView) findViewById(R.id.fixedPhraseArea);

        texts.add("here");
        texts.add("is");
        texts.add("this");

        GridAdapter adapter = new GridAdapter(this, R.layout.grid_item, texts);

        gridView.setAdapter(adapter);
    }


}
