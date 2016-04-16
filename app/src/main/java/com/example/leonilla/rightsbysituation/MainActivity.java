package com.example.leonilla.rightsbysituation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    // I could hold all of the questions(QAdata[]s) as static variables in ONE CLASS
    // that class will have ONE VARIBLE which will hold a double HASH-MAP
    //      (key:"situation", value:
    //                          HashMap(key:subsituation, value(QAdata[]))

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //array of text items that I want to add to the sub-situation listview
        String[] items= {"ex 1", "ex 2", "ex 3", "ex 4"};
        populateListView(items); //creates a list view with the series of text that we want

        registerClickCallback();
        //finish(); ////How to end activity?

    }


    // inserts the individual sample view items into the mainView
    /**
     * @param
     */
    private void populateListView(String[] items) {

        // (1) make an array adapter (it adapts the Listview for you, like Iterator)

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                this,                                // Context--(the current activity)
                android.R.layout.simple_list_item_1, // Layout-- sample item provided by Android
                items);                              // Array of text to add


        // (2) Configure the listview

                                  //this gets the listview from the xml file
        ListView list= (ListView) findViewById(R.id.listView_subsituation);
        list.setAdapter(adapter); //sets the adapter to the main listview
    }


    // Registers a click on a listview item and gives a Toast message
    private void registerClickCallback() {
        //get the main listview
        ListView list= (ListView) findViewById(R.id.listView_subsituation);

        // create an object (see the "adapterview" param below) that will "listen" for clicks
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            // Parent: of item , view: the item clicked, position: item position in list, id: it's id
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                //Layout layoutItem= (Layout) viewClicked; //////////////////////////////////////////////////

                // SHOWS A TOAST SO THAT YOU KNOW THE CLICK WAS REGISTERED
                TextView textview= (TextView) viewClicked;
                makeToast(textview);

                //sends the user to a different q-a page depending on which page they click
                Class[] qaActivities= {QA1Activity.class, MainActivity.class}; //list of possible screens////////////////////////
                Intent newQAactivity; //the intent will be held by this var

                newQAactivity = new Intent(MainActivity.this,          // current Context
                                            qaActivities[position]);   //java Activty to go to
                startActivity(newQAactivity); //does the 'intent'

//                switch( position ) //switch-cases determine which screen to go to
//                {
//                    //remem to do MAINACTIVTITY.this (just 'this' won't work bc you are inside of
//                    // an anonymous class)
//                    case 0:
//
//                    case 1:
//                        newQAactivity = new Intent(MainActivity.this,qaActivities[position]);
//                        startActivity(newQAactivity);
//                        break;
//
//                }
            }
        }); // END anon inner class

//        Intent name= new Intent(this, QA1Activity.class);
    }

    // makes a popup message from a textview (usually when clicked)
    private void makeToast(TextView textview) {

        String message= "Your " + textview.getText().toString() + " click was registered";

        //makes the toast. Remember to SHOW()
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }


    ////// Creates an Option Menu. NOT NEEDED ///////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
