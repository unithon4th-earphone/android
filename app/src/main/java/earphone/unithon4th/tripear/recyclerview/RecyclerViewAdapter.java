package earphone.unithon4th.tripear.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.area.setText(values.get(position).area);
        holder.grade.setText(values.get(position).grade);
        holder.linearLayout.setBackgroundResource(values.get(position).background);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
