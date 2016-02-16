package com.csc.lesson1;

import android.net.Uri;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    final String ADDRESS_TO_MY_IMAGE = "https://pp.vk.me/c625827/v625827693/13487/q4ALHbxcvME.jpg";
    private MainActivity ptrOnMainActivity = this; //internal hack

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ImageView myPhotoImageView = (ImageView) findViewById(R.id.my_photo_image_view);
        Picasso.with(this)
                .load(ADDRESS_TO_MY_IMAGE)
                .placeholder(R.drawable.error_load_image)
                .error(R.drawable.error_load_image)
                .fit()
                .into(myPhotoImageView);

        myPhotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(ptrOnMainActivity)
                        .load(ADDRESS_TO_MY_IMAGE)
                        .placeholder(R.drawable.error_load_image)
                        .error(R.drawable.error_load_image)
                        .fit()
                        .into(myPhotoImageView);
            }
        });

        Log.d("BaseEvent", "onCreate call");
    }
}
