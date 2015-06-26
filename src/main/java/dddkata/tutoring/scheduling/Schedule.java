package dddkata.tutoring.scheduling;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by twer on 6/25/15.
 */
public class Schedule {
    private final String schoolName;
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Course> conflictedCourses = null;

    private Schedule(String schoolName) {
        this.schoolName = schoolName;
    }

    public static Schedule newInstance(String schoolName) {
        return new Schedule(schoolName);
    }

    public void addCourse(Course course) {
        if (this.courses.size() > 0) {
            markTwoConflictedCourses(course);
        }
        this.courses.put(course.getName(), course);
    }

    private void markTwoConflictedCourses(Course courseJustAdded) {
        conflictedCourses = new HashMap<>();
        for(Map.Entry<String, Course> courseWithName : courses.entrySet()) {
            if (courseJustAdded.conflictsWith(courseWithName.getValue())) {
                conflictedCourses.put(courseJustAdded.getName(), courseJustAdded);
                conflictedCourses.put(courseWithName.getKey(), courseWithName.getValue());
                break;
            }
        }
    }

    public Map<String, Course> getConflictedCourses() {
        return conflictedCourses;
    }

    public boolean isOverlapped(String thisCourseName, String thatCourseName) {
        Course thisCourse = this.courses.get(thisCourseName);
        Course thatCourse = this.courses.get(thatCourseName);
        return thisCourse.isOverlappedWith(thatCourse);
    }
}
