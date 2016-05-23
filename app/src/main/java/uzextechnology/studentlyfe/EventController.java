package uzextechnology.studentlyfe;


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class EventController
{

  Map<Long, StudentEvent> studentEventMap = new TreeMap<>();


  public void eventSortByDate(ArrayList<StudentEvent> StudentEvents)
  {
    for( StudentEvent tempevent : StudentEvents )
    {

      //add a 0 when it is a single digit on the month and day
      //separate the variables in different lines

      String fulldate = Integer.toString(tempevent.getYear()) + Integer.toString(tempevent.getMonth()) + Integer.toString(tempevent.getDay());
      Long eventdate = Long.parseLong(fulldate);
      studentEventMap.put(eventdate, tempevent);
    }
    StudentEvents.clear();
    for( StudentEvent studentevent : studentEventMap.values() )
    {
     StudentEvents.add(studentevent);
    }


  }




}




