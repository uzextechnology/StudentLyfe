package uzextechnology.studentlyfe;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Courses extends AppCompatActivity
{
  private FloatingActionButton courseadd;
  private ListView coursedisplay;
  private ArrayAdapter<String> courseAdapter;
  private ArrayList<StudentCourse> courses;
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_courses);
    courseadd = (FloatingActionButton)findViewById(R.id.courseadding);
    coursedisplay = (ListView)findViewById(R.id.courseview);

    courseAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());
    courseAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
    coursedisplay.setAdapter(courseAdapter);

    courseadd.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
        Intent coursesequence1 = new Intent(Courses.this,CourseSequence1.class);
        startActivity(coursesequence1);
      }
    });



  }

}
