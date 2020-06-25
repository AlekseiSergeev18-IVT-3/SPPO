package com.labs;

import java.util.List;

import static com.labs.PlanStructure.plan;

public class Main {

    private static PlanStructure planStructure;

    private static void printQuery(AcademicPlan plan, String subjectName) {
        SubjectQuery q = plan.query(subjectName);
        System.out.println(String.format("%s {", subjectName));


        System.out.println("  INPUTS");
        for (SkillQuery sq: q.requiredSkills()) {
            System.out.print("    ");
            System.out.print(sq.skill().toString());

            List<Subject> subjects = sq.subjects();
            if (!subjects.isEmpty()) {

                System.out.print(" produced by {");
                for (Subject s: subjects) {
                    System.out.print(" ");
                    System.out.print(s.name());
                }
                System.out.print(" }");
            }
            System.out.println();
        }


        System.out.println("  OUTPUTS");
        for (SkillQuery sq: q.producedSkills()) {
            System.out.print("    ");
            System.out.print(sq.skill().toString());

            List<Subject> subjects = sq.subjects();
            if (!subjects.isEmpty()) {

                System.out.print(" required by {");
                for (Subject s: subjects) {
                    System.out.print(" ");
                    System.out.print(s.name());
                }
                System.out.print(" }");
            }
            System.out.println();
        }

        System.out.println("}");
    }
    public static void main(String[] args) throws InterruptedException {


        TaskAddThread myThread = new TaskAddThread();
        myThread.start();
        myThread.join();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Работает поток с выводом данных");
                PlanStructure planStructure = new PlanStructure();
                printQuery( planStructure.getPlan(), "Subject_1");
                printQuery( planStructure.getPlan(), "Subject_2");
                printQuery( planStructure.getPlan(), "Subject_3");
                printQuery( planStructure.getPlan(), "Subject_4");
            }
        }).start();

    }
}
