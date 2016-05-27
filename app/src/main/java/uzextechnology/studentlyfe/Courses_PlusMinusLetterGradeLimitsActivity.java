package uzextechnology.studentlyfe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Courses_PlusMinusLetterGradeLimitsActivity extends AppCompatActivity
{

  private Map<String,DoubleLetterLimitsWrapper> PlusMinusMapping= new TreeMap<>();
  private ArrayAdapter<String> letterspinnerAdapter;
  private Spinner letterspinner;
  private EditText inputgradeedittext;
  private Button updateplusminusgradebutton;
  private Button finishedButton;
  private Button cancelButton;
  private ArrayAdapter<String> listviewadapter;
  private ListView letterassignmentsLV;;
  private Student_Course currentcourse;
  private GPACalculator gpaCalculator;

  String[] outputLetters = {" 1.      A"," 2.      A-"," 3.      B+"," 4.      B"," 5.      B-"," 6.      C+"," 7.      C"," 8.      C-"," 9.      D+","10.     D","11.     F"};

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_grade_spinner_test);

    initComponents();



    currentcourse = (Student_Course)getIntent().getSerializableExtra("currentPlusMinusCourse");
    donekeypadHandler();

    finishedButton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        Intent FinishedSequence = new Intent();
        currentcourse.setPlusMinusMapping(PlusMinusMapping);
        gpaCalculator = new GPACalculator(currentcourse);
        currentcourse.setScaledgrade(gpaCalculator.GPAPlusMinusCalculator());
        FinishedSequence.putExtra("CoursetoOverview", currentcourse);
        setResult(RESULT_OK, FinishedSequence);
        finish();

      }
    });

    cancelButton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        finish();
      }
    });




  }

  public void initComponents()
  {

    cancelButton = (Button) findViewById(R.id.cancelbuttonplusminus);
    finishedButton = (Button) findViewById(R.id.finalbutton);
    letterspinner = (Spinner)findViewById(R.id.letterspinner);
    inputgradeedittext = (EditText)findViewById(R.id.inputgradeplusminus);
    letterassignmentsLV =(ListView)findViewById(R.id.letterassignmentsLV);


    letterspinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,outputLetters);
    letterspinner.setAdapter(letterspinnerAdapter);

    listviewadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());
    letterassignmentsLV.setAdapter(listviewadapter);

    //fill in the map with default values
    //start from 97, this will changed later from the user
    double defaultgrade = 97;
    for(String oneletter: outputLetters)
    {
      DoubleLetterLimitsWrapper tempgrade = new DoubleLetterLimitsWrapper(defaultgrade);
      PlusMinusMapping.put(oneletter,tempgrade);
      defaultgrade-= 3.5;
    }

  }

  public void donekeypadHandler()
  {
    inputgradeedittext.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View v, int keyCode, KeyEvent event)
      {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
        {
          //if nothing is selected on the spinner and there is input in the edit text
          if(letterspinner.getSelectedItemPosition() > -1 && !inputgradeedittext.getText().toString().isEmpty())
          {
            if( Double.parseDouble(inputgradeedittext.getText().toString()) > 0 &&  Double.parseDouble(inputgradeedittext.getText().toString()) < 100.1)
            {
              listviewadapter.clear();
              String templetter = letterspinner.getSelectedItem().toString();
              DoubleLetterLimitsWrapper tempgrade = new DoubleLetterLimitsWrapper(Double.parseDouble(inputgradeedittext.getText().toString()));
              //putting into tree to allow automatic sorting and allow non duplicates

              PlusMinusMapping.put(templetter, tempgrade);

              for(String putletter: PlusMinusMapping.keySet())
              {
                putletter+= ": " + Double.toString(PlusMinusMapping.get(putletter).getGradethreshold()) + "\n";
                listviewadapter.add(putletter);
              }

            }
            else
            {
              Toast.makeText(getBaseContext(),"Enter a correct grade!",Toast.LENGTH_SHORT).show();
            }
          }
          else
          {
            Toast.makeText(getBaseContext(),"One or more fields are invalid!",Toast.LENGTH_SHORT).show();
          }

          return true;
        }

        return false;
      }
    });






  }

}
