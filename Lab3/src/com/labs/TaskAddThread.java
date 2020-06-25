package com.labs;

public class TaskAddThread extends Thread {
    @Override
    public void run() {
        AcademicPlan plan = AcademicPlanBuilder.stream()
                // ability -> умения
                .ability("a")
                .ability("b")
                .ability("c")
                // experience -> навыки
                .experience("d")
                .experience("e")
                .experience("f")
                // knowledge -> знания
                .knowledge("g")
                .knowledge("h")
                .knowledge("i")
                // Добавляем дисциплины
                .subject("Subject_1")
                .requires("a")
                .requires("b")
                .produces("d")
                .subject("Subject_2")
                .requires("c")
                .requires("g")
                .produces("i")
                .produces("f")
                .subject("Subject_3")
                .requires("c")
                .requires("d")
                .requires("i")
                .produces("h")
                .subject("Subject_4")
                .requires("c")
                .requires("d")
                .requires("i")
                .requires("h")
                .produces("e")
                .build();
        PlanStructure planStructure = new PlanStructure();
        planStructure.setPlan(plan);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
