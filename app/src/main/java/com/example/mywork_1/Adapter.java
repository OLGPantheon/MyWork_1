package com.example.mywork_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder>{
    private View view;
    private Context context;
    private ArrayList<Data> list2;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.simplelist,parent,false);
        MyHolder myHolder= new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        holder.name.setText(list2.get(position).getName());
        holder.msg.setText(list2.get(position).getMsg());
        holder.date.setText(list2.get(position).getDate());
  
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("name",list2.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView msg;
        TextView date;
        ImageView imageView;//点击
        LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_name);
            msg = itemView.findViewById(R.id.textView_msg);
            date = itemView.findViewById(R.id.textView_date);
            imageView = itemView.findViewById(R.id.imageView);//点击
            linearLayout = itemView.findViewById(R.id.list_root);
        }
    }

    public Adapter(Context context, ArrayList list2) {
        this.context = context;
        this.list2 = list2;
    }

    public Adapter() {

    }
}
