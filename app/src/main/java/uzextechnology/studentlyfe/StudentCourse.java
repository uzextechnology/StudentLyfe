package uzextechnology.studentlyfe;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class StudentCourse implements Serializable
{
  private String coursename;
  private double coursegrade;
  private double scaledgrade;
  private ArrayList<GradeItem> gradeitems;
  private String semester;
  private boolean isPlusMinus;
  private Map<String,GradeThreshold > PlusMinusMapping;

  public double getScaledgrade()
  {
    return scaledgrade;
  }

  public void setScaledgrade(double scaledgrade)
  {
    this.scaledgrade = scaledgrade;
  }

  public boolean isPlusMinus()
  {
    return isPlusMinus;

  }
  public void setPlusMinus(boolean plusMinus)
  {
    isPlusMinus = plusMinus;
  }

  public Map<String, GradeThreshold> getPlusMinusMapping()
  {
    return PlusMinusMapping;
  }

  public void setPlusMinusMapping(Map<String, GradeThreshold> plusMinusMapping)
  {
    PlusMinusMapping = plusMinusMapping;
  }

  public String getCoursename()
  {
    return coursename;
  }

  public void setCoursename(String coursename)
  {
    this.coursename = coursename;
  }

  public double getCoursegrade()
  {
    return coursegrade;
  }

  public void setCoursegrade(double coursegrade)
  {
    this.coursegrade = coursegrade;
  }

  public ArrayList<GradeItem> getGradeitems()
  {
    return gradeitems;
  }

  public void setGradeitems(ArrayList<GradeItem> gradeitems)
  {
    this.gradeitems = gradeitems;
  }

  public String getSemester()
  {
    return semester;
  }

  public void setSemester(String semester)
  {
    this.semester = semester;
  }
}
