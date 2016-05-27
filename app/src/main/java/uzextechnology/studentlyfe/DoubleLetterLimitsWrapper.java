package uzextechnology.studentlyfe;

import java.io.Serializable;

public class DoubleLetterLimitsWrapper implements Serializable
{
  private double gradethreshold;


  DoubleLetterLimitsWrapper(double grade)
  {
    gradethreshold = grade;
  }

  public double getGradethreshold()
  {
    return gradethreshold;
  }

  public void setGradethreshold(double gradethreshold)
  {
    this.gradethreshold = gradethreshold;
  }
}
