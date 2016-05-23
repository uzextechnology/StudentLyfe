package uzextechnology.studentlyfe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CourseSeqLetterGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_seq_letter_grade);
        Toast.makeText(getBaseContext(),"We are at LETTERGRADE",Toast.LENGTH_SHORT).show();
    }
}
