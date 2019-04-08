package fr.etudes.kindergarden.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import fr.etudes.kindergarden.R;
import fr.etudes.kindergarden.models.Kindergarten;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //get widget (imageLogo and ok)
        final ImageView imageView = findViewById(R.id.imageLogo);
        Button ok = findViewById(R.id.ok);

        //create button's listener to change activity
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ManagementActivity.class);
                startActivity(intent);

            }
        });

        //create animation rotate
        final Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation);

        //start animation on logo
        imageView.startAnimation(rotate);

        //loop animation (listener onAnimationEnd, restart animation on logo)
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(rotate);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Kindergarten.init();
    }
}
