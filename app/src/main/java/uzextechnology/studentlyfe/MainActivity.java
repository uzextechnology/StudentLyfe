package uzextechnology.studentlyfe;

import android.app.ActionBar;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> quotes;
    private TextView quoteOutput;
    private CalendarView studentcalendar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        studentcalendar = (CalendarView) findViewById(R.id.calendarView);
        studentcalendar.setFirstDayOfWeek(1);

        studentcalendar.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.calendarColor));

        quotes = new ArrayList<>();
        try {
            loadQuotes();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Random random = new Random();
        quoteOutput = (TextView) findViewById(R.id.outputQuote);


        String tempshow = quotes.get(random.nextInt(9));
        quoteOutput.setTypeface(null, Typeface.ITALIC);
        quoteOutput.setText(tempshow);
    }


    public void loadQuotes() throws IOException {
        int i = 0;
        AssetManager am = getBaseContext().getAssets();
        InputStream quotesInput = am.open("quotes.txt");

        Scanner lineinput = new Scanner(quotesInput);

        while (lineinput.hasNextLine()) {

            String newquote = lineinput.nextLine();
            quotes.add(i, newquote);
            i++;

        }


    }
}

