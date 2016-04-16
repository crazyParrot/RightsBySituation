package com.example.leonilla.rightsbysituation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Leonilla on 1/12/2015.
 */
class MyQAadapter extends ArrayAdapter<QAdata> {

    LayoutInflater inflater; //used later

    // adapter constructor
    // Values -- an array of QAdata objects. Each one holds the individual String versions of the
    // 'question', 'answer', and 'linkURL' for a item
    public  MyQAadapter(Context context, QAdata[] values) {
        super(context,
              R.layout.q_a_sample , // the sample list item
              values);
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /* Gets the individual view from the generic list and puts a version of the sample item inside
    of it.
        position-- index of view clicked
        convertView-- a reference to the previous view that is available for reuse. As
            the user scrolls the information is populated as needed to conserve memory.(-derek banas)
        parent-- the overall layout
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        //Layout inflator put the sample item layout into a view in the big listview
        inflater= LayoutInflater.from(getContext());

        // inflate takes the sample item resource to load, the parent that the resource may be
        // loaded into and true or false if we are loading into a parent view.
        View sampleView = inflater.inflate(R.layout.q_a_sample, parent, false);

        // retrieve a QAdata item from the array
        QAdata qaData= getItem(position);

        // get the textviews that we want to edit
        TextView questText= (TextView) sampleView.findViewById(R.id.questText);
        TextView ansText= (TextView) sampleView.findViewById(R.id.ansText);
        TextView moreInfoLink= (TextView) sampleView.findViewById(R.id.moreInfo);

        // set the text to the wanted info
        questText.setText(qaData.question);
        ansText.setText(qaData.answer);


        // HOW TO KEEP THE MORE INFO LINK??? DO ONCLICK HERE??--
        // Ans: since the QAdata[] is made in the activity, I can draw from the same arr[position] ///////////////////////
        // to set up the diff links


        //must set the generic(null) view to the customized view with
        //the inserted data. Elsewise, you receive a nullPointerException
        if (convertView == null) {
           convertView= sampleView;
        }
        return convertView;

    }
}
