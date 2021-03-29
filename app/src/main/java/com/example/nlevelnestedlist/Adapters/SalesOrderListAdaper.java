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

public class SalesOrderListAdaper extends RecyclerView.Adapter<SalesOrderListAdaper.MyViewHolder> {
    private ArrayList<String> dataSet;
    private Context mContext;
    private Boolean isGrid2 = false;

    public SalesOrderListAdaper(ArrayList<String> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView salesOrderNumber;
        public RecyclerView listItemRecyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            salesOrderNumber = (TextView)itemView.findViewById(R.id.tv_sales_order_number);
            listItemRecyclerView = (RecyclerView)itemView.findViewById(R.id.rcv_sales_order_line);
        }
    }

    @NonNull
    @Override
    public SalesOrderListAdaper.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_order_list_item, parent, false);
        SalesOrderListAdaper.MyViewHolder myViewHolder = new SalesOrderListAdaper.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SalesOrderListAdaper.MyViewHolder holder, int position) {
        TextView salesOrderNumber = holder.salesOrderNumber;
        RecyclerView salesOrderLine = holder.listItemRecyclerView;

        salesOrderNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //check the child available or not
                //if is avaiable create sales order adapter object
                //assign that on salesOrderListAdapter
                // Put condition for visibility
                //mItemClickListener.onItemClick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataSet!=null?dataSet.size():0;
    }


}

