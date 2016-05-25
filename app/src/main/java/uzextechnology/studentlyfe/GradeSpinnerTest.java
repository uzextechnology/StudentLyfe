package uzextechnology.studentlyfe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GradeSpinnerTest extends AppCompatActivity
{

  private Map<String,GradeThreshold > PlusMinusMapping= new TreeMap<>();
  private ArrayAdapter<String> letteritems;
  private Spinner letterspinner;
  private EditText inputgradeedittext;
  private Button updateplusminusgradebutton;
  private ArrayAdapter<String> listviewadapter;
  private ListView letterassignmentsLV;;


  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_grade_spinner_test);

    String []letters = {" 1.      A"," 2.      A-"," 3.      B+"," 4.      B"," 5.      B-"," 6.      C+"," 7.      C"," 8.      C-"," 9.      D+","10.     D","11.     F"};
    for(String oneletter: letters)
    {
      GradeThreshold tempgrade = new GradeThreshold(0);
      PlusMinusMapping.put(oneletter,tempgrade);
    }
    letteritems = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,letters);
    letterspinner = (Spinner)findViewById(R.id.letterspinner);
    inputgradeedittext = (EditText)findViewById(R.id.inputgradeplusminus);

    letterassignmentsLV =(ListView)findViewById(R.id.letterassignmentsLV);
    listviewadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());

    letterassignmentsLV.setAdapter(listviewadapter);

    letterspinner.setAdapter(letteritems);



    inputgradeedittext.setOnKeyListener(new View.OnKeyListener() {
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
        {
          //if nothing is selected on the spinner and there is input in the edit text
          if(letterspinner.getSelectedItemPosition() > -1 && !inputgradeedittext.getText().toString().isEmpty())
          {
            if( Double.parseDouble(inputgradeedittext.getText().toString()) > 0 &&  Double.parseDouble(inputgradeedittext.getText().toString()) < 100.1)
            {
              listviewadapter.clear();
              String templetter = letterspinner.getSelectedItem().toString();
              GradeThreshold tempgrade = new GradeThreshold(Double.parseDouble(inputgradeedittext.getText().toString()));

              //putting into tree to allow automatic sorting and allow non duplicates

              PlusMinusMapping.put(templetter, tempgrade);



              for(String putletter: PlusMinusMapping.keySet())
              {


                if(!listviewadapter.equals(putletter))
                {
                  putletter+= ": " + Double.toString(PlusMinusMapping.get(putletter).getGradethreshold()) + "\n";
                  listviewadapter.add(putletter);
                }

              }



            }
            else
            {
              Toast.makeText(getBaseContext(),"One or more fields are invalid!",Toast.LENGTH_SHORT).show();
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
  public void takeThresholds()
  {







  }
}
