package com.adrian.camara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btButton;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btButton = findViewById(R.id.btnCamara);
        imageView = findViewById(R.id.imageView5);

        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirCamara();


            }
        });
    }
    private  void abrirCamara(){
        Intent intet = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       // if (intet.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intet, 1);
      //  }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1 && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imBitmap);
        }
    }
}