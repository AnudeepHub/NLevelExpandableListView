package com.example.nlevelnestedlist.nLevel;

import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NlevelRecyclerAdapter extends RecyclerView.Adapter<NlevelRecyclerAdapter.ViewHolder> {

    private List<NLevelItem> list;
    private List<NLevelListItem> filtered;

    private void setFiltered(ArrayList<NLevelListItem> filtered) {
        this.filtered = filtered;

    }

    public NlevelRecyclerAdapter(List<NLevelItem> list) {
        this.list = list;
        this.filtered = filterItems();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    public NLevelListItem getItem(int arg0) {
        return filtered.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int arg0, View arg1, ViewGroup arg2) {
        return getItem(arg0).getView();
    }

    @Override
    public int getItemCount() {
        return filtered.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public NLevelFilter getFilter() {
        return new NLevelFilter();
    }

    public class NLevelFilter {

        public void filter() {
            new AsyncFilter().execute();
        }

        class AsyncFilter extends AsyncTask<Void, Void, ArrayList<NLevelListItem>> {

            @Override
            protected ArrayList<NLevelListItem> doInBackground(Void... arg0) {

                return (ArrayList<NLevelListItem>) filterItems();
            }

            @Override
            protected void onPostExecute(ArrayList<NLevelListItem> result) {
                setFiltered(result);
                NlevelRecyclerAdapter.this.notifyDataSetChanged();
            }
        }


    }

    private List<NLevelListItem> filterItems() {
        List<NLevelListItem> tempfiltered = new ArrayList<NLevelListItem>();
        OUTER: for (NLevelListItem item : list) {
            //add expanded items and top level items
            //if parent is null then its a top level item
            if(item.getParent() == null) {
                tempfiltered.add(item);
            } else {
                //go through each ancestor to make sure they are all expanded
                NLevelListItem parent = item;
                while ((parent = parent.getParent())!= null) {
                    if (!parent.isExpanded()){
                        //one parent was not expanded
                        //skip the rest and continue the OUTER for loop
                        continue OUTER;
                    }
                }
                tempfiltered.add(item);
            }
        }

        return tempfiltered;
    }

    public void toggle(int arg2) {
        filtered.get(arg2).toggle();
    }
}
