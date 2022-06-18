package ngdc.rajshahi.reunion.anotherHomeActivity.memberList;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import ngdc.rajshahi.reunion.R;

public class AdapterForMemberList extends RecyclerView.Adapter<AdapterForMemberList.viewHolder>{

    private final ArrayList<Model_1_for_final> dataSet;
    private final ArrayList<Model_1_for_final> fullList;

    public AdapterForMemberList(ArrayList<Model_1_for_final> dataSet) {
        this.dataSet = dataSet;
        fullList= new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_member_list,parent,false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Model_1_for_final model_1_for_final= dataSet.get(position);
        holder.name.setText(model_1_for_final.getUsers().getName()+"");
        holder.email.setText(model_1_for_final.getUsers().getEmail()+"");
        holder.number.setText(model_1_for_final.getUsers().getMobile()+"");
        Picasso.get().load(model_1_for_final.getImage()+"").into(holder.profilePicture);
    }

    @Override
    public int getItemCount() {
        if (dataSet.size()==0){
            return 0;
        }
        else {
            return dataSet.size();
        }
    }
    public Filter getFilter(){
        return Searched_Filter;
    }

    private final Filter Searched_Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Model_1_for_final> filteredList= new ArrayList<>();
            if (charSequence==null || charSequence.length()==0){
                filteredList.addAll(fullList);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(Model_1_for_final item: fullList){
                    if (item.getUsers().getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results= new FilterResults();
            results.values= filteredList;
            return results;
        }

        @SuppressWarnings("unchecked")
        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dataSet.clear();
            dataSet.addAll((ArrayList) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView profilePicture;
        TextView name, email, number;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profilePicture =itemView.findViewById(R.id.imageView);
            name =itemView.findViewById(R.id.textView3);
            email =itemView.findViewById(R.id.textView4);
            number =itemView.findViewById(R.id.textView5);
        }
    }
}
