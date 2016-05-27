package uzextechnology.studentlyfe;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Courses_OverviewActivity extends AppCompatActivity
{
  private FloatingActionButton courseadd;
  private ListView coursedisplay;
  private ArrayAdapter<String> courseAdapter;
  private ArrayList<Student_Course> courses;
  private Student_Course currentprocessedCourse;
  private TextView overallgpaoutput;
  private GPACalculator overallgpacalculator;
  float historicX = Float.NaN, historicY = Float.NaN;
  static final int DELTA = 50;
  enum Direction {LEFT, RIGHT;}

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_courses);

    //kick off all the components of our page
    initComponents();
    //handle when the floating action button is clicked
    floatingactionbuttonHandling();
    courseitemTouch();

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    // Check which request we're responding to
    if (requestCode == 22)
    {
      // Make sure the request was successful
      if (resultCode == RESULT_OK)
      {
        currentprocessedCourse = (Student_Course)data.getSerializableExtra("CoursetoOverview");
        courses.add(currentprocessedCourse);
        updateCourseView();


      }
    }
  }

  public void floatingactionbuttonHandling()
  {
    courseadd.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        Intent coursesequence1 = new Intent(Courses_OverviewActivity.this,Courses_EditingActivity.class);
        startActivityForResult(coursesequence1,22);

      }
    });


  }

  public void initComponents()
  {
    //contains all the courses
    courses = new ArrayList<>();

    //initializing the xml components
    courseadd = (FloatingActionButton)findViewById(R.id.courseadding);
    coursedisplay = (ListView)findViewById(R.id.lv_courseview);
    overallgpaoutput =(TextView)findViewById(R.id.overallgpaoutput);

    //setting up the adapter for the listview
    courseAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());
    courseAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
    coursedisplay.setAdapter(courseAdapter);

  }

  public void updateCourseView()
  {
    courseAdapter.clear();
    for(Student_Course tempcourse: courses)
    {
      String displayString = tempcourse.getCoursename() + ": "+ Double.toString(tempcourse.getCoursegrade()) + " (" + Double.toString(tempcourse.getScaledgrade())+ ")\n";
      courseAdapter.add(displayString);
    }
    overallgpacalculator = new GPACalculator(courses);

    overallgpaoutput.setText(Double.toString(overallgpacalculator.getOverallGPA()));




  }
  public void courseitemTouch()
  {

    coursedisplay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
      {
        String item = courseAdapter.getItem(position).toString();
        Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent)
      {

      }
    });


  }
}
