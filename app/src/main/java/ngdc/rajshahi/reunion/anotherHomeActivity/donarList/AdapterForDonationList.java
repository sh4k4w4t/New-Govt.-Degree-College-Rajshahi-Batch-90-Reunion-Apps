package ngdc.rajshahi.reunion.anotherHomeActivity.donarList;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import ngdc.rajshahi.reunion.R;

public class AdapterForDonationList extends RecyclerView.Adapter<AdapterForDonationList.viewHolder>{

    private final ArrayList<ModelForDonarList> dataSet;
//    private final ArrayList<ModelForDonarList> fullList;

    public AdapterForDonationList(ArrayList<ModelForDonarList> dataSet) {
        this.dataSet = dataSet;
//        fullList= new ArrayList<>(dataSet);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_donar_list,parent,false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelForDonarList modelForDonarList= dataSet.get(position);
        holder.name.setText(modelForDonarList.getName()+"");
        holder.email.setText(modelForDonarList.getEmail()+"");
        holder.phone.setText(modelForDonarList.getMobile()+"");
        holder.donationAmount.setText("Donate:  "+modelForDonarList.getAmount()+" BDT");
    }

    @Override
    public int getItemCount() {
        if (dataSet.size()==0){
            return 0;
        }else {
            return dataSet.size();
        }
    }

//    public Filter getFilter(){
//        return Searched_Filter;
//    }
//
//    private final Filter Searched_Filter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence charSequence) {
//            ArrayList<ModelForDonarList> filteredList= new ArrayList<>();
//            if (charSequence==null || charSequence.length()==0){
//                filteredList.addAll(fullList);
//            }else {
//                String filterPattern = charSequence.toString().toLowerCase().trim();
//                for(ModelForDonarList item: fullList){
//                    if (item.getName().toLowerCase().contains(filterPattern)){
//                        filteredList.add(item);
//                    }
//                }
//            }
//            FilterResults results= new FilterResults();
//            results.values= filteredList;
//            return results;
//        }
//
//        @SuppressWarnings("unchecked")
//        @SuppressLint("NotifyDataSetChanged")
//        @Override
//        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//            dataSet.clear();
//            dataSet.addAll((ArrayList) filterResults.values);
//            notifyDataSetChanged();
//        }
//    };

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView name,email,phone,donationAmount;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.textViewName);
            email= itemView.findViewById(R.id.textViewEmail);
            phone= itemView.findViewById(R.id.textViewNumber);
            donationAmount= itemView.findViewById(R.id.textViewDonate);
        }
    }
}
