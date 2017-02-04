package earphone.unithon4th.tripear;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import earphone.unithon4th.tripear.recyclerview.Map_Fragment;

public class Map extends FragmentActivity {

    EditText searchEdit;
    Button add_listBtn, delete_listBtn;
    ListView listView;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        searchEdit = (EditText)findViewById(R.id.searchEdit);
        add_listBtn = (Button)findViewById(R.id.add_listBtn);
        delete_listBtn = (Button)findViewById(R.id.delete_listBtn);
        listView = (ListView)findViewById(R.id.addedAreaList);


        Map_Fragment fragment1 = new Map_Fragment();
        fragment1.setArguments(new Bundle());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHere, fragment1);
        fragmentTransaction.commit();

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list);
        listView.setAdapter(adapter);

        add_listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = list.size();
                if(searchEdit.getText().length() == 0){
                    Toast.makeText(Map.this, "원하는 곳을 입력하세요", Toast.LENGTH_LONG).show();
                }else{
                    list.add(searchEdit.getText().toString());
                    adapter.notifyDataSetChanged();
                    searchEdit.setText("");
                }
            }
        });

        delete_listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedItems = listView.getCheckedItemPositions();
                int count = adapter.getCount();

                for(int i = count - 1; i >= 0; i--){
                    if(checkedItems.get(i)) list.remove(i);
                }
                listView.clearChoices();
                adapter.notifyDataSetChanged();
            }

        });
    }
}
