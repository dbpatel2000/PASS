package com.devarsh.pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private TextView mainName;
    private ImageView profileImage;
    private Button signOut;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signOut = findViewById(R.id.main_signout);
        mainName = findViewById(R.id.main_name);
        profileImage = findViewById(R.id.main_profile);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        mainName.setText(name);

        Picasso.get()
                .load(image)
                .into(profileImage);

        System.out.println(image);

        mAuth = FirebaseAuth.getInstance();

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
