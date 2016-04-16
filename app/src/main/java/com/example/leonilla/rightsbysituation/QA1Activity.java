package com.example.leonilla.rightsbysituation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**This Activity is the first Question and Answer page. It contains a
 * header(situation icon and sub-situation title) as well as an UNclickable q-a listview that will
 * be populated by a custom arrayAdapter. The 'more info' text link within each list item takes the
 * user to a website through a new intent.
 *
 * Created by Ogue on 1/8/2015.
 */
public class QA1Activity extends Activity {

    QAdata[] qaList; //array of qaData objects that will fill the information for this specific page

    // Constructor. This allows me to use the same java Activity for many QA pages
    // with different data\
    QA1Activity(QAdata[] qaList) {
        this.qaList= qaList;
    }

    //Activity MUST have this method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //gets info from Super
        setContentView(R.layout.q_a_layout); //sets the screen to the generic listview xml-layout I made




        //**** Adds text to the listview  ********//

        //array of text items that I want to add to the sub-situation listview
       // String[] items= {"qa 1", "qa 2", "qa 3", "qa 4"};

        // list of all of the (questions, answers, links) needed for this page
        QAdata[] allQuests = {
                new QAdata("Is this a question?", "Yes, it just may be.", "http//www.link.com"),

                new QAdata("Another question?",

                        "Yup, get used to it. What else can you expect from " +
                        "super long people. I mean, did that make sense? Huh, I'm not sure. But," +
                        "I wanted this answer to be really long so here it is. TA DAH!",

                        "http//www.google.com"),
                new QAdata("What is this place??!!", "Narnia.", "narnia.com")};


        populateListView(qaList); //creates a list view with the series of text that we want //////////////////remem to change back to 'allQuests'

        //registerClickCallback();


    }

    // inserts the individual sample view items into the mainView
    /**
     * @param
     */
    private void populateListView(QAdata[] qaList) {

        // (1) make an instance of my Custom array adapter for the QA pages

        MyQAadapter adapter= new MyQAadapter(this,qaList);

        // (2) Configure the listview

        //this gets the generic listview from the xml file
        ListView list= (ListView) findViewById(R.id.q_a_listView);
        list.setAdapter(adapter); //sets the adapter onto the generic listview
    }

    // Registers a click on a listview item and gives a Toast message
    private void registerClickCallback() {

        //gets the main listview that is now filled with custom items
        ListView list= (ListView) findViewById(R.id.q_a_listView);

        // create an object (an "adapterview") that will "listen" for clicks
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // Parent: of item , view: the item clicked, position: item position in list, id: its id
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                // SHOWS A TOAST SO THAT YOU KNOW THE CLICK WAS REGISTERED
                makeToast((TextView) viewClicked); //why is this JUST a Textview? will this work?
            }

        });

    }

    // makes a popup message from a textview (usually when clicked)
    private void makeToast(TextView textview) {
        //TextView textview= (TextView) viewClicked; //don't need this anymore
        String message= "Your" + textview.getText().toString()+ "click was registered";
        Toast.makeText(QA1Activity.this, message, Toast.LENGTH_SHORT).show(); //always remem SHOW()!!
    }
}
