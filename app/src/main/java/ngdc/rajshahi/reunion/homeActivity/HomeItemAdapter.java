package ngdc.rajshahi.reunion.homeActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import ngdc.rajshahi.reunion.anotherHomeActivity.becomeAmember.Become_a_member_activity;
import ngdc.rajshahi.reunion.anotherHomeActivity.contact.ContactActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.donarList.DonarListActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.memberList.MemberListActivity;
import ngdc.rajshahi.reunion.anotherHomeActivity.socialMedia.SocialMediaActivity;
import ngdc.rajshahi.reunion.payment.PaymentActivity;
import ngdc.rajshahi.reunion.webview.WebView_1;

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
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.home_item_custom_recycler_grid,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.image.setImageResource(arrayList.get(position).getImage());

        holder.itemView.setOnClickListener(view -> {
            switch (arrayList.get(position).getTitle()) {
                case "About us":
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
                case "Payment":
                    String full_address_for_payment= "https://www.ngdcr90.org/get-user-payment";
                    String title_for_payment = "Gallery";
                    String whereFrom_for_payment = "HomePage";
                    goToWebView(full_address_for_payment,title_for_payment,whereFrom_for_payment,view.getContext(), new WebView_1());
                    break;
                case "Gallery":
                    String full_address_for_gallery= "https://www.ngdcr90.org/gallery";
                    String title_for_gallery = "Gallery";
                    String whereFrom_for_gallery = "HomePage";
                    goToWebView(full_address_for_gallery,title_for_gallery,whereFrom_for_gallery,view.getContext(), new WebView_1());
                    break;
                case "Become a member":
                    String full_address_for_become_member= "https://www.ngdcr90.org/member-register";
                    String title_for_become_member = "Become a Member";
                    String whereFrom_for_become_member = "HomePage";
                    goToWebView(full_address_for_become_member,title_for_become_member,whereFrom_for_become_member,view.getContext(), new WebView_1());
                    break;
                default:
                    Toast.makeText(context, arrayList.get(position).getTitle() + " still Working", Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }

    public void goToWebView(String url,String title,String whereFrom,Context mainActivity, Activity targetActivity){
        Intent intent = new Intent(mainActivity, targetActivity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(context.getResources().getString(R.string.send_url), url);
        intent.putExtra(context.getResources().getString(R.string.send_title), title);
        intent.putExtra(context.getResources().getString(R.string.where_from), whereFrom);
        context.startActivity(intent);
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
