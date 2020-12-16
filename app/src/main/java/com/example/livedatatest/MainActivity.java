package com.example.livedatatest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private NameViewModel model;
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextTextPersonName);
        button=findViewById(R.id.button);
        model= ViewModelProviders.of(this).get(NameViewModel.class);
        MutableLiveData<String>liveData=model.getCurrentName(editText.getText().toString());
        liveData.observe(this, s -> textView.setText(s));

        button.setOnClickListener(v -> model.createName(editText.getText().toString()));
    }
}