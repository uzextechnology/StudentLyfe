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

public class CourseSequence1 extends AppCompatActivity
{
  private EditText gradeentered;
  private EditText coursenameentered;
  private Button  nextbutton;
  private Button cancelbutton;
  private Button updatebutton;
  private StudentCourse currentcourse;



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
    cancelbutton = (Button) findViewById(R.id.CancelButtonCourseSequence1);

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

          currentcourse = new StudentCourse();
          courseNameVariable = coursename;
          gradeVariable = Double.parseDouble(gradeentered.getText().toString());
          currentcourse.setCoursegrade(gradeVariable);
          currentcourse.setCoursename(courseNameVariable);
          currentcourse.setPlusMinus(true);
          plusminusintent.putExtra("currentPlusMinusCourse",currentcourse);
          startActivityForResult(plusminusintent, 23);







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
          currentcourse.setPlusMinus(false);
          letterintent.putExtra("currentLetterCourse", currentcourse );
          startActivityForResult(letterintent, 23);
        }
        else
        {
          Toast.makeText(getBaseContext(),"One or more fields is invalid. Try again!",Toast.LENGTH_SHORT).show();
        }
      }
    });


    cancelbutton.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        finish();
      }
    });
    }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // Check which request we're responding to
    if (requestCode == 23) {
      // Make sure the request was successful
      if (resultCode == RESULT_OK)
      {
        // The user picked a contact.
        // The Intent's data Uri identifies which contact was selected.
        currentcourse = (StudentCourse)getIntent().getSerializableExtra("CourseToSeq1");
        Intent sendingCoursefromCourseSequence1 = new Intent();
        sendingCoursefromCourseSequence1.putExtra("currentPlusMinusCoursetoMain",currentcourse);
        setResult(RESULT_OK, sendingCoursefromCourseSequence1);
        finish();
        // Do something with the contact here (bigger example below)
      }
    }
  }


  }