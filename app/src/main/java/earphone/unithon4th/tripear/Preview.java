package earphone.unithon4th.tripear;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import earphone.unithon4th.tripear.recyclerview.Map_Fragment;

public class Preview extends AppCompatActivity {


    TextView guide_area, guide_name;
    Button route_selectBtn, route_cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        guide_area = (TextView)findViewById(R.id.guide_area);
        guide_name = (TextView)findViewById(R.id.guide_name);

        guide_area.setText(getIntent().getStringExtra("area"));
        guide_name.setText(getIntent().getStringExtra("name"));

        route_selectBtn = (Button)findViewById(R.id.route_selectBtn);
        route_cancelBtn = (Button)findViewById(R.id.route_cancelBtn);


        Map_Fragment fragment1 = new Map_Fragment();
        fragment1.setArguments(new Bundle());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.preview_Map, fragment1);
        fragmentTransaction.commit();

        route_selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Preview.this, guide_area.getText().toString() + "님을 가이드로 결정하셨습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        route_cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
