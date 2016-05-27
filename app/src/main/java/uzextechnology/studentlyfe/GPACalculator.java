package uzextechnology.studentlyfe;


import java.util.ArrayList;

public class GPACalculator
{

  private double   letterAMinus;
  private double   letterA;
  private double   letterBMinus;
  private double   letterBPlus;
  private double   letterB;
  private double   letterCMinus;
  private double   letterC;
  private double   letterCPlus;
  private double   letterDPlus;
  private double   letterD;
  private double   letterF;
  private double   []letterGradeArray;
  private ArrayList<Student_Course> studentCourses;
  private Student_Course CurrentCourse;
  private double actualGrade;


  public GPACalculator(Student_Course CurrentCourse)
  {
    this.CurrentCourse = CurrentCourse;
  }
  public GPACalculator(ArrayList<Student_Course> courses)
  {
    this.studentCourses = courses;
  }

  public ArrayList<Student_Course> getStudentCourses()
  {
    return studentCourses;
  }

  public void setStudentCourses(ArrayList<Student_Course> studentCourses)
  {
    this.studentCourses = studentCourses;
  }

  public void setActualGrade(double actualGrade)
  {
    this.actualGrade = actualGrade;
  }


  public double GPALetterCalculate()
  {
    int i = 0;
    for(DoubleLetterLimitsWrapper tempgrade: CurrentCourse.getPlusMinusMapping().values())
    {
       letterGradeArray[i] = tempgrade.getGradethreshold(); //putting all doubles into array
      i++;
    }


    if(actualGrade >= letterA)
    {
      return 4;
    }
    else if(actualGrade >= letterB)
    {
      return 3;
    }
    else if(actualGrade >= letterC)
    {
      return 2;
    }
    else if(actualGrade >= letterD)
    {
      return 1;
    }
    else
    {
      return 0;
    }

  }


  public double GPAPlusMinusCalculator()
  {

    int i = 0;
    letterGradeArray = new double[CurrentCourse.getPlusMinusMapping().size()];
    for(DoubleLetterLimitsWrapper tempgrade: CurrentCourse.getPlusMinusMapping().values())
    {
      letterGradeArray[i] = tempgrade.getGradethreshold(); //putting all doubles into array
      i++;
    }
    actualGrade = CurrentCourse.getCoursegrade();

    if(actualGrade >= letterGradeArray[0])
    {
      return 4;
    }
    else if(actualGrade >= letterGradeArray[1])
    {
      return 3.67;
    }
    else if(actualGrade >= letterGradeArray[2])
    {
      return 3.33;
    }
    else if(actualGrade >= letterGradeArray[3])
    {
      return 3;
    }
    else if(actualGrade >= letterGradeArray[4])
    {
      return 2.67;
    }
    else if(actualGrade >= letterGradeArray[5])
    {
      return 2.33;
    }
    else if(actualGrade >= letterGradeArray[6])
    {
      return 2;
    }
    else if(actualGrade >= letterGradeArray[7])
    {
      return 1.67;
    }
    else if(actualGrade >= letterGradeArray[8])
    {
      return 1.33;
    }
    else if(actualGrade >= letterGradeArray[9])
    {
      return 1;
    }
    else if( actualGrade < letterGradeArray[9] && actualGrade > letterGradeArray[10])
    {
      return .67;
    }
    else
    {
      return 0;
    }
  }
  public double getOverallGPA()
  {
    double numberofcourses = studentCourses.size();
    double total = 0;
    for( Student_Course tempcourse: studentCourses)
    {
      total += tempcourse.getScaledgrade();
    }

    return (total/numberofcourses);

  }





}
