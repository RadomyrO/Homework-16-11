package part3_grades;

import java.util.ArrayList;
import java.util.Collections;

// Part 3. StudentGrades
public class StudentGrades {

    private ArrayList<Double> grades = new ArrayList<>();

    // Part 3.1 addGrade
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // Part 3.2 getGradesAbove
    public ArrayList<Double> getGradesAbove(double threshold) {
        ArrayList<Double> res = new ArrayList<>();
        for (double g : grades) {
            if (g > threshold) res.add(g);
        }
        return res;
    }

    // Part 3.3 getAverageGrade
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    // Part 3.4 removeLowestGrade
    public void removeLowestGrade() {
        if (grades.isEmpty()) return;
        Double min = Collections.min(grades);
        grades.remove(min); // удаляет только одну
        System.out.println("Removed lowest: " + min);
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    // Part 3.5 Demo
    public static void main(String[] args) {
        StudentGrades sg = new StudentGrades();
        sg.addGrade(85.5);
        sg.addGrade(92.0);
        sg.addGrade(67.0);
        sg.addGrade(74.5);
        sg.addGrade(98.0);
        sg.addGrade(55.0);

        System.out.println("All grades: " + sg.getGrades());

        double avg = sg.getAverageGrade();
        System.out.printf("Average grade: %.2f%n", avg);

        System.out.println("Grades above average: " + sg.getGradesAbove(avg));

        sg.removeLowestGrade();
        System.out.println("Updated list: " + sg.getGrades());
    }
}
