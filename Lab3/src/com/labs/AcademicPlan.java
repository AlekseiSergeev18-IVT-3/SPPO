package com.labs;

import java.util.Map;


public class AcademicPlan {
    private Map<String, Subject> _subjects;

    public AcademicPlan(Map<String, Subject> subjects) {
        _subjects = subjects;
    }


    SubjectQuery query(String subjectName) {
        Subject subject = _subjects.get(subjectName);
        SubjectQuery subjectQuery = new SubjectQuery(subject);
        for (Skill x: subject.requiredSkills().view()) {
            SkillQuery sq = new SkillQuery(x);
            for (Subject sub: _subjects.values()) {
                for (Skill y: sub.producedSkills().view()) {
                    if (x == y) {
                        sq.add(sub);
                    }
                }
            }
            subjectQuery.addRequired(sq);
        }
        for (Skill x: subject.producedSkills().view()) {
            SkillQuery sq = new SkillQuery(x);
            for (Subject sub: _subjects.values()) {
                for (Skill y: sub.requiredSkills().view()) {
                    if (x == y) {
                        sq.add(sub);
                    }
                }
            }
            subjectQuery.addProduced(sq);
        }
        return subjectQuery;
    }
}
