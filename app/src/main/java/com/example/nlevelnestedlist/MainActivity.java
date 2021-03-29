package com.example.nlevelnestedlist;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nlevelnestedlist.nLevel.NLevelAdapter;
import com.example.nlevelnestedlist.nLevel.NLevelItem;
import com.example.nlevelnestedlist.nLevel.NLevelView;
import com.example.nlevelnestedlist.nLevel.SomeObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<NLevelItem> list;
    private ListView listView;
    private View view;

    private int[] colors = {Color.parseColor("#ffffff"),
            Color.parseColor("#DDDDDD"),
            Color.parseColor("#EEEEEE"),
            Color.parseColor("#F7F7F7"),
            Color.parseColor("#FFFFFF")};


    //String jsonStringList = "{\"status\":\"OK\",\"statusCode\":200,\"statusMessage\":\"success\",\"timestamp\":1608787289479,\"payload\":{\"salesOrderDTO\":[{\"salesOrderNumber\":\"320285726\",\"source\":\"SAP\",\"comments\":null,\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"wareHouse\":\"US10\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"dollarValue\":0.00},{\"salesOrderNumber\":\"320285726\",\"source\":\"SAP\",\"comments\":null,\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"wareHouse\":\"US10\",\"lineItemsDTOS\":[],\"dollarValue\":0.00},{\"salesOrderNumber\":\"320285726\",\"source\":\"SAP\",\"comments\":null,\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"wareHouse\":\"US10\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"dollarValue\":0.00}]}}";

    String jsonStringList = "{\"status\":\"OK\",\"statusCode\":200,\"statusMessage\":\"success\",\"timestamp\":1608787289479,\"payload\":{\"salesOrderDTO\":[{\"salesOrderNumber\":\"320285111\",\"source\":\"SAP\",\"comments\":null,\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"wareHouse\":\"US10\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"dollarValue\":0.00},{\"salesOrderNumber\":\"320285222\",\"source\":\"SAP\",\"comments\":null,\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"wareHouse\":\"US10\",\"lineItemsDTOS\":[],\"dollarValue\":0.00},{\"salesOrderNumber\":\"320285333\",\"source\":\"SAP\",\"comments\":null,\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"wareHouse\":\"US10\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},{\"name\":\"X2-SD-CTRL[TR]\",\"psiLineNumber\":\"10\",\"comments\":\"\",\"lineItemsDTOS\":[],\"totalComments\":null,\"legend1\":null,\"legend2\":null,\"legend3\":null,\"legend4\":null,\"commentsCount\":0,\"dollarValue\":0},],\"dollarValue\":0.00}]}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * This method involves initializing the list view and pass the response to the other method to do the iteration.
         * After iteration next to set up to the adapter and implement the up and down toggling effect on click on list items.
         */
        NLevelExpandableListView();

    }

    private void NLevelExpandableListView() {

        listView = (ListView) findViewById(R.id.listView1);
        list = new ArrayList<NLevelItem>();
        final LayoutInflater inflater = LayoutInflater.from(this);
        nestedLoop(jsonStringList, null, inflater, 0);      // Passing the response to the iteration loop to serve the data to individual item.

        NLevelAdapter adapter = new NLevelAdapter(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                ((NLevelAdapter) listView.getAdapter()).toggle(arg2);
                ((NLevelAdapter) listView.getAdapter()).getFilter().filter();
            }
        });

    }

    private void nestedLoop(String levelList, NLevelItem nLevelItem, final LayoutInflater inflater, int level) {

        try {
            int length;
            JSONArray salesOrderDTO = null;
            JSONArray jsonArrayStringList = null;
            if (level == 0) {
                JSONObject jsonObject = new JSONObject(levelList);
                int statusCode = jsonObject.getInt("statusCode");
                String statusMess = jsonObject.getString("statusMessage");
                JSONObject payload = jsonObject.getJSONObject("payload");
                salesOrderDTO = payload.getJSONArray("salesOrderDTO");
                length = salesOrderDTO.length();
            } else {
                jsonArrayStringList = new JSONArray(levelList);
                length = jsonArrayStringList.length();
            }
            for (int i = 0; i < length; i++) {
                JSONObject lineitems;
                if (level == 0) {
                    lineitems = salesOrderDTO.getJSONObject(i);
                } else {
                    lineitems = jsonArrayStringList.getJSONObject(i);
                }
                String salesOrderNumber = null;
                String lineitemName = null;
                if (level == 0) {
                    salesOrderNumber = lineitems.getString("salesOrderNumber");
                    String source = lineitems.getString("source");
                    String warehouse = lineitems.getString("wareHouse");
                } else {
                    lineitemName = lineitems.getString("name");
                    String psiLineNumber = lineitems.getString("psiLineNumber");
                    int commentsCount = lineitems.getInt("commentsCount");
                }
                String comments = lineitems.getString("comments");
                String totalComments = lineitems.getString("totalComments");
                String legend1 = lineitems.getString("legend1");
                String legend2 = lineitems.getString("legend2");
                String legend4 = lineitems.getString("legend4");
                String dollarValue = lineitems.getString("dollarValue");
                int childrenSize = lineitems.getJSONArray("lineItemsDTOS").length();
                NLevelItem parent = itemView(i, length, (salesOrderNumber != null) ? salesOrderNumber : lineitemName, nLevelItem, inflater, level, !(childrenSize > 0));
                list.add(parent);

                if (childrenSize > 0) {
                    nestedLoop(lineitems.getJSONArray("lineItemsDTOS").toString(), parent, inflater, level + 1);
                }
            }
        } catch (Exception e) {

        }
    }

    private NLevelItem itemView(int itemRow, int length, final String Title, NLevelItem nLevelItem, final LayoutInflater inflater, final int level, final boolean isLast) {

        NLevelItem superChild = new NLevelItem(new SomeObject(Title), nLevelItem, new NLevelView() {
            @Override
            public View getView(NLevelItem item) {
                if (level == 0) {
                    view = inflater.inflate(R.layout.parent_list_item, null);
                    TextView tv_parent = (TextView) view.findViewById(R.id.tv_order_number_parent);
                    RelativeLayout parenLevelLayout = (RelativeLayout) view.findViewById(R.id.parent_listItemContainer);
                    String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                    tv_parent.setText(name);

                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) tv_parent.getLayoutParams();
                    mlp.setMargins(level * 50, 5, 5, 5);

                    if (isLast) {
                        //expand_collapse.setText("");
                        tv_parent.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Clicked on: " + Title, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } else {
                    view = inflater.inflate(R.layout.list_item, null);
                    TextView tv = (TextView) view.findViewById(R.id.tv_sub_item_title);
                    TextView divider = (TextView) view.findViewById(R.id.divider_sub_child);
                    ImageView expand_collapse = (ImageView) view.findViewById(R.id.iv_sub_expand_collapse);
                    RelativeLayout childContainer = (RelativeLayout) view.findViewById(R.id.sub_list_container);
                    TextView comment_count = (TextView) view.findViewById(R.id.tv_sub_comment_count);
                    TextView comment_view = (TextView) view.findViewById(R.id.tv_sub_item_comments);
                    TextView NavSalesDetails = (TextView) view.findViewById(R.id.tv_sub_nav_details);
                    String name = (String) ((SomeObject) item.getWrappedObject()).getName();
                    tv.setText(name);

                    if (level < 4) {
                        if (level == 2 && itemRow == 0) {
                            childContainer.setBackgroundResource(R.drawable.sales_order_light_gray_noch_bg);
                        } else if (level == 3 && itemRow == 0) {
                            childContainer.setBackgroundResource(R.drawable.sales_order_gray_noch_bg);
                        } else {
                            childContainer.setBackgroundColor(colors[level]);
                        }
                    } else {
                        childContainer.setBackgroundColor(Color.WHITE);
                    }
                    if (item.isExpanded() == true) {
                        expand_collapse.setImageResource(R.drawable.ic_collapse);
                    } else {
                        expand_collapse.setImageResource(R.drawable.ic_expand);
                    }

                    NavSalesDetails.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "Clicked on: " + Title, Toast.LENGTH_SHORT).show();
                        }
                    });

                    ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) childContainer.getLayoutParams();
                    ViewGroup.MarginLayoutParams div = (ViewGroup.MarginLayoutParams) divider.getLayoutParams();

                    if (level > 1) {
                        mlp.height = 150;
                        comment_count.setVisibility(View.INVISIBLE);
                        comment_view.setVisibility(View.INVISIBLE);
                    }
                    if (level >= 4) {
                        mlp.setMargins(4 * 50, 0, 30, 0);
                        div.setMargins(0, 0, 50, 0);
                    } else {
                        if (level == 1) {
                            mlp.setMargins(level * 50, 0, 30, 10);
                        } else if (level == 2 && itemRow == 0) {
                            mlp.setMargins(level * 37, 0, 30, 0);
                            div.setMargins(level * 50, 0, 50, 0);
                        } else if (level == 3 && itemRow == 0) {
                            mlp.setMargins(level * 41, 10, 30, 0);
                            div.setMargins(level * 40, 10, 50, 0);
                        } else if (length == itemRow + 2) {
                            mlp.setMargins(level * 50, 0, 30, 10);
                            divider.setVisibility(View.GONE);
                        } else {
                            mlp.setMargins(level * 50, 0, 30, 0);
                            div.setMargins(level * 40, 0, 50, 0);
                        }
                    }


                    if (isLast) {
                        expand_collapse.setVisibility(View.INVISIBLE);
                        tv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Clicked on: " + Title, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }


                return view;
            }
        });

        return superChild;
    }

}
