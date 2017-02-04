package earphone.unithon4th.tripear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import earphone.unithon4th.tripear.recyclerview.ItemDatas;
import earphone.unithon4th.tripear.recyclerview.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;

    Animation translateLeftAnim, translateRightAnim;
    LinearLayout slidingPage;
    ListView listView;
    Button menuOpenBtn;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerView_Adapter;
    RecyclerView.LayoutManager recyclerViewLayoutMananger;

    ArrayList<ItemDatas> items;

    String[] menus = {"홈", "로그인", "플랜", "마이페이지"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<ItemDatas>();
        items.add(new ItemDatas(R.drawable.splash_background_1, "Seoul", "5"));
        items.add(new ItemDatas(R.drawable.splash_background_2, "Busan", "3"));
        items.add(new ItemDatas(R.drawable.splash_background_3, "Suwon", "2"));
        items.add(new ItemDatas(R.drawable.splash_background_1, "Jeju", "5"));
        items.add(new ItemDatas(R.drawable.splash_background_2, "Daegu", "4"));
        items.add(new ItemDatas(R.drawable.splash_background_3, "Ulsan", "4"));
        items.add(new ItemDatas(R.drawable.splash_background_1, "Seoul", "5"));
        items.add(new ItemDatas(R.drawable.splash_background_2, "Seoul", "5"));

        menuOpenBtn = (Button)findViewById(R.id.menu_open_btn);
        slidingPage = (LinearLayout)findViewById(R.id.slidingPage);
        listView = (ListView)findViewById(R.id.menu_listView);


        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewLayoutMananger = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(recyclerViewLayoutMananger);
        recyclerView_Adapter = new RecyclerViewAdapter(items, getApplicationContext());
        recyclerView.setAdapter(recyclerView_Adapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, menus);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), Map.class);
                        startActivity(intent);
                        break;
                    case 3:

                }
            }
        });



        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        menuOpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen){
                    slidingPage.startAnimation(translateRightAnim);
                }else{
                    slidingPage.setVisibility(View.VISIBLE);
                    slidingPage.startAnimation(translateLeftAnim);
                }
            }
        });

        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                slidingPage.setVisibility(View.INVISIBLE);
                isPageOpen = false;
            }else{
                isPageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
