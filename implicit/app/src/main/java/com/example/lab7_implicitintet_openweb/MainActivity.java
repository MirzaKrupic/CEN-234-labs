package com.example.lab7_implicitintet_openweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText link, mapUrl, shareText;
    private Button openLink, openMap, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        link = findViewById(R.id.url_input);
        mapUrl = findViewById(R.id.map_text);
        shareText = findViewById(R.id.share_text);
    }

    public void openUrl(View view){
        String url = link.getText().toString();
        Uri uri = Uri.parse("http://"+url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "no activty", Toast.LENGTH_SHORT).show();
        }
    }

    public void openMap(View view){
        String location = mapUrl.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q="+location);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "no activty", Toast.LENGTH_SHORT).show();
        }
    }

    public void shareText(View view){
        String share = shareText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this).setType(mimeType)
                .setChooserTitle("Choose an app")
                .setText(share).startChooser();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "no activty", Toast.LENGTH_SHORT).show();
        }
    }
}