package earphone.unithon4th.tripear.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import earphone.unithon4th.tripear.Preview;
import earphone.unithon4th.tripear.R;

/**
 * Created by android on 2017-02-04.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<ItemDatas> values;
    //String[] values;
    Context context;

    public RecyclerViewAdapter(ArrayList<ItemDatas> values, Context context) {
        this.values = values;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.area.setText(values.get(position).area);
        holder.grade.setText(values.get(position).grade);
        holder.linearLayout.setBackgroundResource(values.get(position).background);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String area = holder.area.getText().toString();
                final String grade = holder.grade.getText().toString();
                Intent intent = new Intent(v.getContext(), Preview.class);
                intent.putExtra("area", area);
                intent.putExtra("name", grade);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
