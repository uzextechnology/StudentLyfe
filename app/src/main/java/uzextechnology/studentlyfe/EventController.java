package uzextechnology.studentlyfe;


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class EventController
{

  Map<Long, Student_Event> studentEventMap = new TreeMap<>();


  public void eventSortByDate(ArrayList<Student_Event> studentEvents)
  {
    for( Student_Event tempevent : studentEvents )
    {

      //add a 0 when it is a single digit on the month and day
      //separate the variables in different lines

      String fulldate = Integer.toString(tempevent.getYear()) + Integer.toString(tempevent.getMonth()) + Integer.toString(tempevent.getDay());
      Long eventdate = Long.parseLong(fulldate);
      studentEventMap.put(eventdate, tempevent);
    }
    studentEvents.clear();
    for( Student_Event studentevent : studentEventMap.values() )
    {
     studentEvents.add(studentevent);
    }


  }




}




