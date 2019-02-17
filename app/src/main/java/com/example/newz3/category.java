package com.example.newz3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class category extends AppCompatActivity {


    Button hindiadd;
    Button sportsadd;
    Button politicsadd;
    Button techadd;
    Button worldadd;
    Button weatheradd;

    LottieAnimationView lottie1;
    LottieAnimationView lottie2;
    LottieAnimationView lottie3;
    LottieAnimationView lottie4;
    LottieAnimationView lottie5;
    LottieAnimationView lottie6;
    LottieAnimationView lottie7;

    Button jump;
    Button btownadd;
    FirebaseUser crnt;
    String currentuser;
    String user_token;
    DatabaseReference mdatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        hindiadd = (Button) findViewById(R.id.hindiadd);
        sportsadd = (Button) findViewById(R.id.sportsadd);
        politicsadd = (Button) findViewById(R.id.politicsadd);
        techadd = (Button) findViewById(R.id.techadd);
        weatheradd = (Button) findViewById(R.id.weatheradd);
        btownadd = (Button) findViewById(R.id.btownadd);
        worldadd = (Button) findViewById(R.id.worldadd);

        lottie1 = (LottieAnimationView) findViewById(R.id.lottie1);
        lottie2 = (LottieAnimationView) findViewById(R.id.lottie2);
        lottie3 = (LottieAnimationView) findViewById(R.id.lottie3);
        lottie4 = (LottieAnimationView) findViewById(R.id.lottie4);
        lottie5 = (LottieAnimationView) findViewById(R.id.lottie5);
        lottie6 = (LottieAnimationView) findViewById(R.id.lottie6);
        lottie7 = (LottieAnimationView) findViewById(R.id.lottie7);



        jump = (Button) findViewById(R.id.mainac);
        user_token = FirebaseInstanceId.getInstance().getToken();
        crnt = FirebaseAuth.getInstance().getCurrentUser();
        currentuser = crnt.getUid().toString();

        mdatabse = FirebaseDatabase.getInstance().getReference().child("Users").child(currentuser);


        hindiadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdatabse.child("Hindi").setValue(1);
                hindiadd.setVisibility(View.INVISIBLE);
                lottie1.playAnimation();
            }
        });

        sportsadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdatabse.child("Sports").setValue(1);
                sportsadd.setVisibility(View.INVISIBLE);
                lottie4.playAnimation();
            }
        });

        politicsadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdatabse.child("Politics").setValue(1);
                politicsadd.setVisibility(View.INVISIBLE);
                lottie2.playAnimation();
            }
        });

        worldadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdatabse.child("World").setValue(1);
                worldadd.setVisibility(View.INVISIBLE);
                lottie7.playAnimation();
            }
        });

        techadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdatabse.child("Tech").setValue(1);
                techadd.setVisibility(View.INVISIBLE);
                lottie5.playAnimation();
            }
        });

        weatheradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdatabse.child("Weather").setValue(1);
                weatheradd.setVisibility(View.INVISIBLE);
                lottie3.playAnimation();
            }
        });

        btownadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdatabse.child("Btown").setValue(1);
                btownadd.setVisibility(View.INVISIBLE);
                lottie6.playAnimation();
            }
        });



        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginsucess = new Intent(category.this,MainActivity.class);
                startActivity(loginsucess);
                finish();
            }
        });
    }


}
