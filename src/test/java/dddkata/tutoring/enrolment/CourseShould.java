package dddkata.tutoring.enrolment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/24/15.
 */
public class CourseShould {
    @Test
    public void tellMeTheKidsEnrolled() {
        // Arrange
        dddkata.tutoring.enrolment.Course course = dddkata.tutoring.enrolment.Course.newInstance("美术预科");

        List<Kid> kids = new ArrayList<Kid>();

        Kid tianSiSi = Kid.newInstance("田斯斯", "女", 3);
        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        tianSiSi.setGuardian(tianSiSiMom);
        Fee tianSiSiFee = Fee.newInstance("2015.01.15", 3000);
        tianSiSi.setFee(tianSiSiFee);
        course.addKid(tianSiSi);

        Kid maYiDa = Kid.newInstance("马一达", "男", 3);
        Guardian maYiDaDad = Guardian.newInstance("Dad", "13921223211");
        maYiDa.setGuardian(maYiDaDad);
        Fee maYiDaFee = Fee.newInstance("2015.01.18", 3000);
        maYiDa.setFee(maYiDaFee);
        course.addKid(maYiDa);

        // Act & Assert
        assertEquals("田斯斯_女_3岁 马一达_男_3岁 ", course.getKids());
    }

    // TODO: tellMeTheGuardianForAKid
    // TODO: tellMeTheDateWhenAKidsFeeWasPaid
}
