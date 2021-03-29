package com.example.nlevelnestedlist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nlevelnestedlist.R;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class SalesOrderSubLineItemAdapter extends RecyclerView.Adapter<SalesOrderSubLineItemAdapter.MyViewHolder> {
private ArrayList<String> dataSet;
private Context mContext;
private Boolean isGrid2 = false;

public SalesOrderSubLineItemAdapter(ArrayList<String> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView salesOrderSubName;
    public RecyclerView subSubLineItems;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        salesOrderSubName = (TextView)itemView.findViewById(R.id.tv_sub_item);
        subSubLineItems = (RecyclerView)itemView.findViewById(R.id.rcv_sales_order_sub_sub_line_items);
    }
}

    @NonNull
    @Override
    public SalesOrderSubLineItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_order_sub_line_items, parent, false);
        SalesOrderSubLineItemAdapter.MyViewHolder myViewHolder = new SalesOrderSubLineItemAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView salesOrderSubName = holder.salesOrderSubName;
        RecyclerView subSubLineItems = holder.subSubLineItems;
    }


    @Override
    public int getItemCount() {
        return dataSet!=null?dataSet.size():0;
    }
}
