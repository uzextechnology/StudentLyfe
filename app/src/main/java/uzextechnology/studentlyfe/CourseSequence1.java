package uzextechnology.studentlyfe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CourseSequence1 extends AppCompatActivity
{
  private EditText gradeentered;
  private EditText coursenameentered;
  private Button  nextbutton;
  private Button cancelbutton;
  private Button updatebutton;

  private double gradeVariable;
  private String courseNameVariable;

  private int COURSENAMEFLAG= 0, RADIOBUTTONFLAG =0, GRADEENTEREDFLAG= 0;
  private String coursename;
  private double grade;
  public void onRadioButtonClicked(View view)
  {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
      case R.id.radioButton:
        if (checked) {
          Toast.makeText(getBaseContext(), "this is yes", Toast.LENGTH_SHORT).show();
          RADIOBUTTONFLAG = 1;


        }
          break;
      case R.id.radioButton2:
        if (checked)
        {
          Toast.makeText(getBaseContext(), "this is no", Toast.LENGTH_SHORT).show();
          RADIOBUTTONFLAG = 2;
        }
        break;
      default:
        RADIOBUTTONFLAG =0;
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_course_sequence1);
    coursenameentered = (EditText)findViewById(R.id.coursenameentered);
    gradeentered = (EditText)findViewById(R.id.gradeentered);
    nextbutton = (Button)findViewById(R.id.nextbutton);

    coursenameentered.addTextChangedListener(new TextWatcher()
    {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after)
      {
        COURSENAMEFLAG = 0;
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count)
      {
        COURSENAMEFLAG =0;

      }

      @Override
      public void afterTextChanged(Editable s)
      {
        if(s.toString().length() > 0)
        {
          COURSENAMEFLAG = 1;
          coursename = s.toString();
        }

      }
    });
    gradeentered.addTextChangedListener(new TextWatcher()
    {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after)
      {
        GRADEENTEREDFLAG =0;
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count)
      {
        GRADEENTEREDFLAG=0;
      }

      @Override
      public void afterTextChanged(Editable s)
      {
        if(!s.toString().isEmpty())
        {
          if (Double.parseDouble(s.toString()) > -.0000001 && Double.parseDouble(s.toString()) < 100)
          {
            GRADEENTEREDFLAG = 1;
            grade = Double.parseDouble(s.toString());

          }
        }
        else GRADEENTEREDFLAG = 0;

      }
    });

    nextbutton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        if(GRADEENTEREDFLAG == 1 && COURSENAMEFLAG ==1 && RADIOBUTTONFLAG == 1)// this will take us to a plus/minus system
        {
          Intent plusminusintent = new Intent(CourseSequence1.this,CourseSeqPlusMinus.class);
          //send some stuff here
          gradeVariable = Double.parseDouble(gradeentered.getText().toString());

          plusminusintent.putExtra("GradeVariablePlusMinus", gradeVariable); // Sending grade to the plusminus actvity


          startActivity(plusminusintent);

        }
        else if(GRADEENTEREDFLAG == 1 && COURSENAMEFLAG ==1 && RADIOBUTTONFLAG == 2)
        {
          Intent letterintent = new Intent(CourseSequence1.this,CourseSeqLetterGrade.class);
          //send some stuff here
          StudentCourse currentcourse = new StudentCourse();
          courseNameVariable = coursename;
          gradeVariable = Double.parseDouble(gradeentered.getText().toString());
          currentcourse.setCoursegrade(gradeVariable);
          currentcourse.setCoursename(courseNameVariable);
          letterintent.putExtra("currentCourse", currentcourse );
          startActivity(letterintent);
        }
        else
        {
          Toast.makeText(getBaseContext(),"One or more fields is invalid. Try again!",Toast.LENGTH_SHORT).show();
        }
      }
    });

    }
  }