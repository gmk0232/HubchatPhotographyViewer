package com.mellobit.gmckee.hubchatphotographyviewer.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.mellobit.gmckee.hubchatphotographyviewer.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button view = (Button) findViewById(R.id.button);
        //view.setOnClickListener(e-> Toast.makeText(this,"Hello", Toast.LENGTH_LONG).show());

    }
}
