package earphone.unithon4th.tripear;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import java.util.Random;

public class Splash extends AppCompatActivity {

    private static final long LOADING_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.activity_splash);
        Random rand = new Random();

        switch (rand.nextInt()%3){
            case 0:
                linearLayout.setBackgroundResource(R.drawable.splash_background_1);
                break;
            case 1:
                linearLayout.setBackgroundResource(R.drawable.splash_background_2);
                break;
            case 2:
                linearLayout.setBackgroundResource(R.drawable.splash_background_3);
                break;
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
