package uzextechnology.studentlyfe;


import java.io.Serializable;
import java.util.ArrayList;

public class StudentCourse implements Serializable
{
  private String coursename;
  private double coursegrade;
  private ArrayList<GradeItem> gradeitems;
  private String semester;

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
