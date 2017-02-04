package earphone.unithon4th.tripear.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import earphone.unithon4th.tripear.R;

/**
 * Created by android on 2017-02-04.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView area, grade;
    LinearLayout linearLayout;
    public MyViewHolder(View itemView) {
        super(itemView);
        linearLayout = (LinearLayout)itemView.findViewById(R.id.recyclerView);
        area = (TextView)itemView.findViewById(R.id.area_description);
        grade = (TextView)itemView.findViewById(R.id.area_grade);
    }
}
