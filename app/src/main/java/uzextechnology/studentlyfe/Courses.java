package uzextechnology.studentlyfe;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Courses extends AppCompatActivity
{
  private FloatingActionButton courseadd;
  private ListView coursedisplay;
  private ArrayAdapter<String> courseAdapter;
  private ArrayList<StudentCourse> courses;
  private StudentCourse currentprocessedCourse;





  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_courses);
    courses = new ArrayList<>();

    //currentprocessedCourse = (StudentCourse)getIntent().getSerializableExtra("CurrentCourse");
    courseadd = (FloatingActionButton)findViewById(R.id.courseadding);
    coursedisplay = (ListView)findViewById(R.id.lv_courseview);

    courseAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());
    courseAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
    coursedisplay.setAdapter(courseAdapter);






    courseadd.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        Intent coursesequence1 = new Intent(Courses.this,CourseSequence1.class);
        startActivityForResult(coursesequence1,22);
      }
    });



  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    // Check which request we're responding to
    if (requestCode == 22)
    {
      // Make sure the request was successful
      if (resultCode == RESULT_OK) {
        // The user picked a contact.
        // The Intent's data Uri identifies which contact was selected.
        currentprocessedCourse = (StudentCourse)getIntent().getSerializableExtra("currentPlusMinusCoursetoMain");
        courses.add(currentprocessedCourse);
        Toast.makeText(getBaseContext(),currentprocessedCourse.getCoursename(),Toast.LENGTH_SHORT).show();
      }
    }
  }

}
