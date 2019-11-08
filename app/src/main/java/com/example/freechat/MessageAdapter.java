package com.example.freechat;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<FriendlyMessages> {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    public MessageAdapter(Context context, int resource, List<FriendlyMessages> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        FriendlyMessages message = getItem(position);

        if(TextUtils.equals(message.getSenderid(),
                FirebaseAuth.getInstance().getCurrentUser().getUid())) {
            row = inflater.inflate(R.layout.right, parent, false);
        }
        else {
            row = inflater.inflate(R.layout.left, parent, false);
        }
        ImageView photoImageView =  row.findViewById(R.id.photoImageView);
        TextView messageTextView =  row.findViewById(R.id.messageTextView);
        TextView authorTextView =  row.findViewById(R.id.nameTextView);

        boolean isPhoto = message.getPhotoUrl() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Glide.with(photoImageView.getContext())
                    .load(message.getPhotoUrl())
                    .into(photoImageView);
        } else {
            messageTextView.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());

        return row;
    }

}
