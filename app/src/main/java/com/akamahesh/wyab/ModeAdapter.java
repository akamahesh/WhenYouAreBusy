package com.akamahesh.wyab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ModeAdapter extends RecyclerView.Adapter<ModeAdapter.ViewHolder> {

    private Context context;
    private List<String> mList;

    public ModeAdapter(Context context,List<String> list){
        this.context = context;
        this.mList  = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_mode_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.bindContent(mList.get(i));
        holder.tvTitle.setText(mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private String item;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(v -> Toast.makeText(context,item,Toast.LENGTH_SHORT).show());
        }

        private void bindContent(String item){
            this.item = item;
        }

    }
}
