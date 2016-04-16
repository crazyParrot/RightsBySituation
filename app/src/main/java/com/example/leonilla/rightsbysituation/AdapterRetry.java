package com.example.leonilla.rightsbysituation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Leonilla on 1/13/2015.
 */
public class AdapterRetry extends BaseAdapter{
    Context context;
    QAdata[] qaList;

    //constructor
    AdapterRetry(Context context, QAdata[] qaList) {
        this.context= context;
        this.qaList= qaList;
    }


    //tells the listview how many rows it will need
    @Override
    public int getCount() {
        return qaList.length;
    }

    // Returns the data(QAdata object) for the current position in the list
    @Override
    public QAdata getItem(int position) {
        return qaList[position];
    }

    //returns the current list position
    @Override
    public long getItemId(int position) {
        return position;
    }

    // This is the most imp method. It binds the data to the custom sample view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //need to inflate the existing main layout so that we can add a new layout(the sample) to it
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View view = convertView; //the current view from the generic list

//        if(convertView==null)
//
//            view = inflater.inflate(R.layout.notification_list_item, null);
//
//        ImageView compleatImageView=(ImageView)view.findViewById(R.id.complet_image);
//        TextView name = (TextView)view.findViewById(R.id.game_name); // name
//        TextView email_id = (TextView)view.findViewById(R.id.e_mail_id); // email ID
//        TextView notification_message = (TextView)view.findViewById(R.id.notification_message); // notification message
//
//
//
//        compleatImageView.setBackgroundResource(R.id.address_book);
//        name.setText(data.getIndex(position));
//        email_id.setText(data.getIndex(position));
//        notification_message.setTextdata.getIndex(position));
//
//        return view;

        return null;
    }
}
