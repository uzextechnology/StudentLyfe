package uzextechnology.studentlyfe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CourseSeqPlusMinus extends AppCompatActivity {


    private StudentCourse PlusMinusCourse;
    EditText  letterAMinus;
    EditText  letterA;
    EditText  letterBMinus;
    EditText  letterBPlus;
    EditText  letterB;
    EditText  letterCMinus;
    EditText  letterC;
    EditText  letterCPlus;
    EditText  letterDPlus;
    EditText  letterD;
    EditText  letterF;
    Button UpdatePlusMinusButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_seq_plus_minus);
        letterA =(EditText)findViewById(R.id.InputLetterA);
        letterAMinus =(EditText)findViewById(R.id.InputLetterAMinus);
        letterBPlus =(EditText)findViewById(R.id.InputLetterBPlus);
        letterB =(EditText)findViewById(R.id.InputLetterB);
        letterBMinus =(EditText)findViewById(R.id.InputLetterBMinus);
        letterCPlus =(EditText)findViewById(R.id.InputLetterCPlus);
        letterCMinus =(EditText)findViewById(R.id.InputCMinus);
        letterC =(EditText)findViewById(R.id.InputLetterC);
        letterF =(EditText)findViewById(R.id.InputLetterF);
        letterD =(EditText)findViewById(R.id.InputLetterD);
        letterDPlus =(EditText)findViewById(R.id.InputLetterDPlus);


        UpdatePlusMinusButton= (Button)findViewById(R.id.PlusMInusUPDATE);

        PlusMinusCourse = (StudentCourse)getIntent().getSerializableExtra("currentPlusMinusCourse");
        Toast.makeText(getBaseContext(), PlusMinusCourse.getCoursename(), Toast.LENGTH_SHORT).show();

        UpdatePlusMinusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getBaseContext(), "This is UPDATED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
