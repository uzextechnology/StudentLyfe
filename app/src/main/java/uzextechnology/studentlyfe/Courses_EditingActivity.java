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
import android.widget.Toast;

public class Courses_EditingActivity extends AppCompatActivity
{
  private EditText gradeentered;
  private EditText coursenameentered;
  private Button  nextbutton;
  private Button cancelbutton;
  private Button updatebutton;
  private Student_Course currentcourse;

  private int COURSENAMEFLAG= 0, RADIOBUTTONFLAG =0, GRADEENTEREDFLAG= 0;

  private String coursename;
  private double grade;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_course_sequence1);

    initComponents();

    coursenamefieldHandler();
    gradeenteredfieldHandler();

    nextbuttonHandler();
    cancelbuttonHandler();

  }

  public void onRadioButtonClicked(View view)
  {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
      case R.id.radioButton:
        if (checked)
        {
          RADIOBUTTONFLAG = 1;
        }
        break;
      case R.id.radioButton2:
        if (checked)
        {
          RADIOBUTTONFLAG = 2;
        }
        break;
      default:
        RADIOBUTTONFLAG =0;
    }
  }



  public void initComponents()
  {
    coursenameentered = (EditText) findViewById(R.id.coursenameentered);
    gradeentered = (EditText) findViewById(R.id.gradeentered);
    nextbutton = (Button) findViewById(R.id.nextbutton);
    cancelbutton = (Button) findViewById(R.id.CancelButtonCourseSequence1);
    currentcourse = new Student_Course();
  }

  public void coursenamefieldHandler()
  {
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
        COURSENAMEFLAG = 0;
      }

      @Override
      public void afterTextChanged(Editable s)
      {
        if ( s.toString().length() > 0 )
        {
          COURSENAMEFLAG = 1;
          coursename = s.toString();
        }

      }
    });

  }

  public void gradeenteredfieldHandler()
  {
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
  }
  public void nextbuttonHandler()
  {
    nextbutton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        if ( GRADEENTEREDFLAG == 1 && COURSENAMEFLAG == 1 && RADIOBUTTONFLAG == 1 )// this will take us to a plus/minus system
        {
          plusminusgradeSelection();
        } else if ( GRADEENTEREDFLAG == 1 && COURSENAMEFLAG == 1 && RADIOBUTTONFLAG == 2 )
        {
          wholelettergradeSelection();
        } else
        {
          Toast.makeText(getBaseContext(), "One or more fields is invalid. Try again!", Toast.LENGTH_SHORT).show();
        }
      }
    });

}
  public void cancelbuttonHandler()
  {
    cancelbutton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        finish();
      }
    });
  }

  public void wholelettergradeSelection()
  {
    currentcourse.setCoursegrade(grade);
    currentcourse.setCoursename(coursename);
    currentcourse.setPlusMinus(false);

    Intent letterintent = new Intent(Courses_EditingActivity.this,Courses_WholeLetterGradeLimitsActivity.class);
    letterintent.putExtra("currentLetterCourse", currentcourse);
    letterintent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
    startActivity(letterintent);
    finish();
  }

  public void plusminusgradeSelection()
  {
    currentcourse.setCoursegrade(grade);
    currentcourse.setCoursename(coursename);
    currentcourse.setPlusMinus(true);

    Intent plusminusintent = new Intent(Courses_EditingActivity.this,Courses_PlusMinusLetterGradeLimitsActivity.class);
    plusminusintent.putExtra("currentPlusMinusCourse",currentcourse);
    plusminusintent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
    startActivity(plusminusintent);
    finish();
  }
}










