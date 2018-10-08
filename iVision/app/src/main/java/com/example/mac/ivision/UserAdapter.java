package com.example.mac.ivision;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class UserAdapter extends FirestoreRecyclerAdapter<User, UserAdapter.UserHolder> {


    public UserAdapter(@NonNull FirestoreRecyclerOptions<User> options, Context context) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull UserHolder holder, int position, @NonNull User model) {
        holder.textViewName.setText(model.getName());
        holder.phoneNumber.setText(model.getPhone());

    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);

        return new UserHolder(v);
    }

    class UserHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView phoneNumber;
        FloatingActionButton phoneCall;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.user_name);
            phoneNumber = itemView.findViewById(R.id.phone_number);
            phoneCall = itemView.findViewById(R.id.call_button);

            phoneCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }
}
