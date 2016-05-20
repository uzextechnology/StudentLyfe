package uzextechnology.studentlyfe;

/* All of our imports*/
import android.app.ActionBar;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }

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

    }

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


    }
}

