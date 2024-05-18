package FinalOOPLab;

import java.util.ArrayList;
import java.util.List;

class Course {
    private String title;
    private String instructor;
    private int durationInWeeks;
    private double enrollmentFee;

    public Course(String title, String instructor, int durationInWeeks, double enrollmentFee) {
        this.title = title;
        this.instructor = instructor;
        this.durationInWeeks = durationInWeeks;
        this.enrollmentFee = enrollmentFee;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public double getEnrollmentFee() {
        return enrollmentFee;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duration (weeks): " + durationInWeeks);
        System.out.println("Enrollment Fee: $" + enrollmentFee);
    }
}

class ProgrammingCourse extends Course {
    private String language;

    public ProgrammingCourse(String title, String instructor, int durationInWeeks, double enrollmentFee, String language) {
        super(title, instructor, durationInWeeks, enrollmentFee);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Language: " + language);
    }
}

class MathematicsCourse extends Course {
    private String topic;

    public MathematicsCourse(String title, String instructor, int durationInWeeks, double enrollmentFee, String topic) {
        super(title, instructor, durationInWeeks, enrollmentFee);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Topic: " + topic);
    }
}

class LiteratureCourse extends Course {
    private String genre;

    public LiteratureCourse(String title, String instructor, int durationInWeeks, double enrollmentFee, String genre) {
        super(title, instructor, durationInWeeks, enrollmentFee);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}
public class CourseManagementSystem {
    public static void main(String[] args) {
        ProgrammingCourse javaCourse = new ProgrammingCourse("Java Programming", "John Doe", 10, 99.99, "Java");
        MathematicsCourse algebraCourse = new MathematicsCourse("Algebra Basics", "Alice Smith", 8, 79.99, "Algebra");
        LiteratureCourse novelCourse = new LiteratureCourse("Introduction to Novels", "Jane Doe", 6, 59.99, "Fiction");

        javaCourse.displayInfo();
        System.out.println();
        algebraCourse.displayInfo();
        System.out.println();
        novelCourse.displayInfo();
    }
}
