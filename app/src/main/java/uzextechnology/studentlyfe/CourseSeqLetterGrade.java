package uzextechnology.studentlyfe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View;



public class CourseSeqLetterGrade extends AppCompatActivity {

    private StudentCourse LetterCourse;
    private StudentCourse NumberCourse;
    private Double receiveGradeVariable;
    private String letterVariable;
    EditText  letterA;
    EditText  letterB;
    EditText  letterC;
    EditText  letterD;
    Button    UpdateLetterButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_seq_letter_grade);

        letterA =(EditText)findViewById(R.id.et_inputALetter);
        letterB =(EditText)findViewById(R.id.et_inputBLetter);
        letterC =(EditText)findViewById(R.id.et_inputCLetter);
        letterD =(EditText)findViewById(R.id.et_inputDLetter);
        UpdateLetterButton= (Button)findViewById(R.id.LetterSequenceButton);

        LetterCourse = (StudentCourse)getIntent().getSerializableExtra("currentLetterCourse");
        Toast.makeText(getBaseContext(), LetterCourse.getCoursename(), Toast.LENGTH_SHORT).show();


        UpdateLetterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              // if(letterA.getText().toString().length() > 1)
            }
        });
    }


}
