package com.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.Constants;
import com.project.models.User;
import com.project.veggieempiregr5.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AllUserAdapter extends RecyclerView.Adapter<AllUserAdapter.ViewHolder> {

    private ArrayList<User> userList;
    public void setOnItemClick(OnItemClick event) {
        callBack = event;
    }

    private OnItemClick callBack;

    public interface OnItemClick {
        void onItemClick(User data);
    }
    public AllUserAdapter(ArrayList<User> users) {
        userList = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_user_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        if (user.getStatus().equals(Constants.ONLINE)) {
            holder.imgOn.setVisibility(View.VISIBLE);
            holder.imgOff.setVisibility(View.GONE);
        } else {
            holder.imgOn.setVisibility(View.GONE);
            holder.imgOff.setVisibility(View.VISIBLE);
        }

        holder.userName.setText(user.getUserName());
        holder.u = user;

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView avatar;
        public TextView userName;
        public ImageView imgOn;
        public ImageView imgOff;
        public LinearLayout container;
        public User u;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            userName = itemView.findViewById(R.id.user_name);
            imgOn = itemView.findViewById(R.id.img_on);
            imgOff = itemView.findViewById(R.id.img_off);
            container = itemView.findViewById(R.id.user_item_container);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callBack != null){
                        callBack.onItemClick(u);
                    }
                }
            });
        }
    }
}