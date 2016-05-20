package uzextechnology.studentlyfe;

/* All of our imports*/

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<String> quotes; //stores quotes
    private TextView quoteOutput; //quote that's outputted
    private CalendarView studentcalendar; //calendar used
    private EditText dialoginput;
    private AlertDialog.Builder builder;
    private ArrayList<StudentEvent> StudentEvents;
    private LinearLayout eventdialoglayout;
    private Spinner eventtypespinner;
    private ArrayAdapter<String> eventtypeadapter;
    private String[] eventtypes = {"Exam","Project","Assignment","Group Meeting","Other"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      StudentEvents = new ArrayList<>();

      initCalendar(); //this function shows the calendar
      initQuotes(); // this function shows the bottom quotes
    }

    //The init Calendar points the XML id
    //to the variable/attribute "studentcalendar"
    //sets the background of the calendar
    public void initCalendar()
    {

      studentcalendar = (CalendarView) findViewById(R.id.calendarView); // find the calendar in the ID
      studentcalendar.setFirstDayOfWeek(1); //adjust to show the month by the 1st of that month
      studentcalendar.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.calendarColor)); //set the color of the calendar

      //preparing for when a new event occurs
      //handles everything from dialog to listeners
      newEvent();

    }//end of initcalendar


    //The init quotes function loads the quotes from the file into the ArrayList
    //Produces a random integer and uses that as the index of the ArrayList
    //Uses that random quote to display on the bottom of the screen
    public void initQuotes()
    {
        Random random = new Random(); // this generates the quote randomness
        String tempshow;
        quotes = new ArrayList<>(); // this arraylist has all our quotes

        try
        {
            loadQuotes(); // load the quote file into the arraylist
        }
        catch (IOException e)
        {
            e.printStackTrace(); // whoops something wrong happened here
        }

        quoteOutput = (TextView) findViewById(R.id.outputQuote); //assigning the textview to the variable

        tempshow = quotes.get(random.nextInt(9)); // this is the quote we wanna see, based on a randomnumber

        quoteOutput.setTypeface(null, Typeface.ITALIC); // make it italic
        quoteOutput.setText(tempshow); // set the text to be that quote we initalized

    }//end of initquotes

    //The load quotes function loads quotes from the file contain the quotes and places them in
    //a string ArrayList called quotes. This function returns nothing.
    public void loadQuotes() throws IOException
    {
        int i = 0; // will be used for the index in the quotes ArrayList
        AssetManager am = getBaseContext().getAssets(); // we need to get the elements in the assets folder
        InputStream quotesInput = am.open("quotes.txt"); // the assets folder has the quotes text file we need

        Scanner lineinput = new Scanner(quotesInput); // use the InputStream of the file and hook up a scanner to it

        while (lineinput.hasNextLine()) // staying alive as long as we have a line to work with
        {

            String newquote = lineinput.nextLine(); // grab the next line and store it in a string
            quotes.add(i, newquote); // stick the string in the ArrayList
            i++; // increment to advance position in the ArrayList

        }


    }//end of loadquotes

    //The newEvent method sets up a listener for when event occurs
    //makes a call to all the initialization of the dialog
    //puts the event in the StudentEvents ArrayList
    // and shows the dialog itself
    public void newEvent()
    {
      // we are listening for a new event in the case that the user pressed a date
      studentcalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
      {
        //Handling for what happens with the user DOES press a date
        //must override on the listener to modify functionality
        @Override
        public void onSelectedDayChange(CalendarView view, final int year, final int month, final int dayOfMonth)
        {

          //this function is going to initialize all the components of the event dialog
          initEventDialog();

          // Set up the buttons and listeners for the dialog
          //the ok button will be in the case when the event does want to be created
          builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
          {

            //override what happens on an OK press
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
              //create a new temp event to place in the StudentEvent ArrayList
              StudentEvent tempEvent = new StudentEvent();

              //setting all the attributes that are inputted from the user
              //also setting the date that was pressed into the temp event
              tempEvent.setEventname(dialoginput.getText().toString());
              tempEvent.setYear(year);
              tempEvent.setMonth(month);
              tempEvent.setDay(dayOfMonth);

              //add the temp event into the student ArrayList
              StudentEvents.add(tempEvent);
              //remove all the view in the layout
              eventdialoglayout.removeAllViewsInLayout();

            }
          });
          //setup the cancel button
          builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
          {
            @Override
            // handling for what happens when user pressed cancel
            public void onClick(DialogInterface dialog, int which)
            {
              //do away with all the layout views
              eventdialoglayout.removeAllViewsInLayout();
              //close the dialog
              dialog.cancel();
            }
          });

          //finally show the dialog
          builder.show();
        }
      });
    }//end of newEvent

  //The initEventDialog function creates memory for the dialog
  //it also sets some of the settings for each of the individual
  //components of the layout and the layout itself
  // it also adds the layout itself to the dialog
  //it DOES NOT show the alertdialog, just sets it up
  public void initEventDialog()
  {

    //Here we are initializing all the memory for:
    //the dialog itself, the LinearLayout of the dialog
    //the TextView that the user uses to input
    //the adapter that contains all of the elements used by
    //the spinner, and the spinner itself to show all the possible
    //types of events
    builder = new AlertDialog.Builder(MainActivity.this);
    eventdialoglayout = new LinearLayout(MainActivity.this);
    dialoginput = new EditText(MainActivity.this);
    eventtypeadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, eventtypes);
    eventtypespinner = new Spinner(MainActivity.this);

    //setting the input for the user to name the event
    dialoginput.setSingleLine(true);
    dialoginput.setHint("Event Name");

    // setting the adapter based on the 5 possible types of events
    // add the adapter to the spinner
    // and adds redundate padding to the spinner
    eventtypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    eventtypespinner.setAdapter(eventtypeadapter);
    eventtypespinner.setPadding(0, 0, 0, 0);


    //setting all the settings for the LinearLayout
    //of the dialog, including the padding
    //orientation and adds the different components
    eventdialoglayout.setPadding(70, 15, 200, 0);
    eventdialoglayout.setOrientation(LinearLayout.VERTICAL);
    eventdialoglayout.setGravity(Gravity.CENTER_HORIZONTAL);
    eventdialoglayout.addView(dialoginput);
    eventdialoglayout.addView(eventtypespinner);

    //sets the layout to the dialog and places the titles
    builder.setView(eventdialoglayout);
    builder.setTitle("                New Event");

  }//end of initeventdialog


}//end of class

