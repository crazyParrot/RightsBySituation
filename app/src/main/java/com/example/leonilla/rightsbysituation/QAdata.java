package com.example.leonilla.rightsbysituation;

/** Each QAdata object will hold all of the information for on question on the QA page.
 * That info includes the question, answer, and more-info link.
 * An array of these objects will be used to in the Custom adapter(MyListAdapter) in order to adapt
 * the listview
 *
 * Created by Leonilla on 1/13/2015.
 */
public class QAdata {
    String question;
    String answer;
    String linkUrl; // link that the 'moreInfo' text will go to

    QAdata (String question, String answer, String linkUrl) {
        this.question= question;
        this.answer= answer;
        this.linkUrl= linkUrl;
    }

}
