package ngdc.rajshahi.reunion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.MyHolder>{

    Context context;
    ArrayList<HomeItemGridPojo> arrayList;

    public HomeItemAdapter(Context context, ArrayList<HomeItemGridPojo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_item_custom_recycler_grid,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.image.setImageResource(arrayList.get(position).getImage());

        holder.itemView.setOnClickListener(view -> {
            if (arrayList.get(position).getTitle().equals("About NGDC90")){
                Toast.makeText(context, arrayList.get(position).getTitle()+" Still Working...", Toast.LENGTH_SHORT).show();
            }
            if (arrayList.get(position).getTitle().equals("Become a member")){
                Toast.makeText(context, arrayList.get(position).getTitle()+" Still Working...", Toast.LENGTH_SHORT).show();
            }
            if (arrayList.get(position).getTitle().equals("Member list")){
                Toast.makeText(context, arrayList.get(position).getTitle()+" Still Working...", Toast.LENGTH_SHORT).show();
            }
            if (arrayList.get(position).getTitle().equals("Donate")){
                Toast.makeText(context, arrayList.get(position).getTitle()+" Still Working...", Toast.LENGTH_SHORT).show();
            }
            if (arrayList.get(position).getTitle().equals("Gallery")){
                Toast.makeText(context, arrayList.get(position).getTitle()+" Still Working...", Toast.LENGTH_SHORT).show();
            }
            if (arrayList.get(position).getTitle().equals("Contact")){
                Toast.makeText(context, arrayList.get(position).getTitle()+" Still Working...", Toast.LENGTH_SHORT).show();
            }
            if (arrayList.get(position).getTitle().equals("Social Media")){
                Toast.makeText(context, arrayList.get(position).getTitle()+" Still Working...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.home_item_recyclerView_title_id);
            image=itemView.findViewById(R.id.home_item_recyclerView_image_id);
        }
    }

}
