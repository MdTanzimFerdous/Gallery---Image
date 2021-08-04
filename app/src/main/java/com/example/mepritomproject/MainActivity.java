package com.example.mepritomproject;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button buttonChangePic;
    ImageView sobiDekha;
    Uri uri;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonChangePic = findViewById(R.id.buttonID);
        sobiDekha = findViewById(R.id.imageViewID);
        sobiDekha.setImageResource(R.drawable.alienthepritom);

        buttonChangePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mGetContent.launch("image/*");
            }
        });
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {
            if(result != null)
                sobiDekha.setImageURI(result);
        }
    });
}