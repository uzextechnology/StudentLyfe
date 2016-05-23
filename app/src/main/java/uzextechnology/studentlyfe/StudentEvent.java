package uzextechnology.studentlyfe;

public class StudentEvent
{
  private String eventname;

  private double graderecieved;

  private int year;
  private int month;
  private int day;
  private String eventtype;
  /*
  The event types are:
   Exam Date
   Project Due
   Assignment Due
   Group Meeting
   Other
  */


  public String getEventname()
  {
    return eventname;
  }

  public void setEventname(String eventname)
  {
    this.eventname = eventname;
  }

  public double getGraderecieved()
  {
    return graderecieved;
  }

  public void setGraderecieved(double graderecieved)
  {
    this.graderecieved = graderecieved;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public String getEventtype()
  {
    return eventtype;
  }

  public void setEventtype(String eventtype)
  {
    this.eventtype = eventtype;
  }
}
