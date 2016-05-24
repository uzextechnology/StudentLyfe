package uzextechnology.studentlyfe;


import android.widget.EditText;

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

  private double actualGrade;


  public void setActualGrade(double actualGrade)
  {
    this.actualGrade = actualGrade;
  }


  GPACalculator(double letterAMinus, double letterA, double letterBMinus, double letterBPlus, double letterB, double letterCMinus, double letterC, double letterCPlus, double letterD, double letterDPlus, double letterF)
  {

    this.letterAMinus  = letterAMinus;
    this.letterA = letterA;
    this.letterBPlus = letterBPlus;
    this.letterB = letterB;
    this.letterBMinus = letterBMinus;
    this.letterCPlus = letterCPlus;
    this.letterC = letterC;
    this.letterCMinus = letterCMinus;
    this.letterDPlus = letterDPlus;
    this.letterD = letterD;
    this.letterF = letterF;

  }

  GPACalculator(double letterA, double letterB, double letterC, double letterD, double letterF)
  {
    this.letterA = letterA;
    this.letterB= letterB;
    this.letterC = letterC;
    this.letterD= letterD;
    this.letterF = letterF;
  }

  public double GPALetterCalculate()
  {
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
    if(actualGrade >= letterA)
    {
      return 4;
    }
    else if(actualGrade >= letterAMinus)
    {
      return 3.67;
    }
    else if(actualGrade >= letterBPlus)
    {
      return 3.33;
    }
    else if(actualGrade >= letterB)
    {
      return 3;
    }
    else if(actualGrade >= letterBMinus)
    {
      return 2.67;
    }
    else if(actualGrade >= letterCPlus)
    {
      return 2.33;
    }
    else if(actualGrade >= letterC)
    {
      return 2;
    }
    else if(actualGrade >= letterCMinus)
    {
      return 1.67;
    }
    else if(actualGrade >= letterDPlus)
    {
      return 1.33;
    }
    else if(actualGrade >= letterD)
    {
      return 1;
    }
    else if( actualGrade < letterD && actualGrade > letterF)
    {
      return .67;
    }
    else
    {
      return 0;
    }
  }



}
