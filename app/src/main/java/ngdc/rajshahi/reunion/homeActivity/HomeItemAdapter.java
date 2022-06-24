package ngdc.rajshahi.reunion.homeActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import ngdc.rajshahi.reunion.R;
import ngdc.rajshahi.reunion.anotherHomeActivity.aboutUs.AboutUsActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.contact.ContactActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.donarList.DonarListActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.memberList.MemberListActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.socialMedia.SocialMediaActivity;

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
            switch (arrayList.get(position).getTitle()) {
                case "About NGDCR90":
                    view.getContext().startActivity(new Intent(context, AboutUsActivity.class));
                    break;
                case "Member list":
                    view.getContext().startActivity(new Intent(context, MemberListActivity.class));
                    break;
                case "Donation List":
                    view.getContext().startActivity(new Intent(context, DonarListActivity.class));
                    break;
                case "Contact":
                    view.getContext().startActivity(new Intent(context, ContactActivity.class));
                    break;
                case "Social Media":
                    view.getContext().startActivity(new Intent(context, SocialMediaActivity.class));
                    break;
                default:
                    Toast.makeText(context, arrayList.get(position).getTitle() + " still Working", Toast.LENGTH_SHORT).show();
                    break;
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
