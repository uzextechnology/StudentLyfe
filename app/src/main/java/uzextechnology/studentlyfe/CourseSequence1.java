package uzextechnology.studentlyfe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CourseSequence1 extends AppCompatActivity
{
  public void onRadioButtonClicked(View view) {
    // Is the button now checked?
    boolean checked = ((RadioButton) view).isChecked();

    // Check which radio button was clicked
    switch(view.getId()) {
      case R.id.radioButton2:
        if (checked)
          // Pirates are the best

          Toast.makeText(getBaseContext(),"this is no", Toast.LENGTH_SHORT).show();
          break;
      case R.id.radioButton:
        if (checked)
          // Ninjas rule
          Toast.makeText(getBaseContext(),"this is yes", Toast.LENGTH_SHORT).show();

        break;
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_course_sequence1);


  }
}
