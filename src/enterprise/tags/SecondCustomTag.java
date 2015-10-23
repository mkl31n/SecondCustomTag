package enterprise.tags;

import java.io.IOException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by michaelklein on 10/23/15.
 */
public class SecondCustomTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        GregorianCalendar time = new GregorianCalendar();
        String username = System.getProperty("user.name");

        int hour = time.get(Calendar.HOUR_OF_DAY);
        int min = time.get(Calendar.MINUTE);
        int day = time.get(Calendar.DAY_OF_MONTH);
        int month = time.get(Calendar.MONTH) + 1;
        int year = time.get(Calendar.YEAR);

        out.println("The current time is \t" + hour + ":" + min + "<br />");
        out.println("Today's date is \t" + month + "/" + day + "/"
                + year + "<br />");

        if (hour < 12)
            out.println("Good Morning, " + username);
        else if (hour < 17 && !(hour == 12))
            out.println("Good Afternoon " + username);
        else if (hour == 12)
            out.println("It's Noon " + username);
        else
            out.println("Good Evening " + username);
    }
}
