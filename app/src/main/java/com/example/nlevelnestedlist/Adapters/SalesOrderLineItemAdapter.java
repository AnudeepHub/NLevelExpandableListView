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

public class SalesOrderLineItemAdapter extends RecyclerView.Adapter<SalesOrderLineItemAdapter.MyViewHolder> {
    private ArrayList<String> dataSet;
    private Context mContext;
    private Boolean isGrid2 = false;

    public SalesOrderLineItemAdapter(ArrayList<String> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView salesOrderLineName;
        public RecyclerView subLineItemRecyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            salesOrderLineName = (TextView)itemView.findViewById(R.id.tv_sales_order_line_name);
            subLineItemRecyclerView = (RecyclerView)itemView.findViewById(R.id.rcv_sales_order_sub_Line);
        }
    }

    @NonNull
    @Override
    public SalesOrderLineItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_order_line_item, parent, false);
        SalesOrderLineItemAdapter.MyViewHolder myViewHolder = new SalesOrderLineItemAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SalesOrderLineItemAdapter.MyViewHolder holder, int position) {
        TextView salesOrderLineName = holder.salesOrderLineName;
        RecyclerView subLineItem = holder.subLineItemRecyclerView;
    }


    @Override
    public int getItemCount() {
        return dataSet!=null?dataSet.size():0;
    }
}


