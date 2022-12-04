package com.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.models.Photo;
import com.project.veggieempiregr5.R;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{

    private List<Photo> photoList;

    public PhotoAdapter(List<Photo> photoList) {
        this.photoList = photoList;

    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = photoList.get(position);
        if (photo == null) {
            return;
        }
        holder.imvPhoto.setImageResource(photo.getResourceId());
    }

    @Override
    public int getItemCount() {
        if (photoList != null){
            return photoList.size();
        }
        return 0;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imvPhoto;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imvPhoto = itemView.findViewById(R.id.imv_Photo);
        }
    }
}
