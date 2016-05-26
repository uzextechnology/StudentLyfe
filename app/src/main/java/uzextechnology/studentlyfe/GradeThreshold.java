package uzextechnology.studentlyfe;

import java.io.Serializable;

/**
 * Created by Alex on 5/25/16.
 */
public class GradeThreshold implements Serializable
{
  private double gradethreshold;


  GradeThreshold(double grade)
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
