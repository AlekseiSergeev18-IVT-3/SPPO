package com.labs;

public class PlanStructure {

     static Object object = null;

     static AcademicPlan plan = null;

     PlanStructure() {
        object = new Object();
    }


    AcademicPlan getPlan() {
        synchronized (object) {
            return plan;
        }
    }

    void setPlan(AcademicPlan plan) {

        synchronized (object) {

            this.plan = plan;
        }
    }
}
