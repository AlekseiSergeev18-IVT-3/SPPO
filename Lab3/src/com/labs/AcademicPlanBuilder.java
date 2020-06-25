package com.labs;

import java.util.HashMap;


public class AcademicPlanBuilder {
    private Subject _currentSubject;
    private HashMap<String, Subject> _subjects;
    private HashMap<String, Skill> _skillMap;

    private AcademicPlanBuilder() {
        _subjects = new HashMap<>();
        _skillMap = new HashMap<>();

    }

    public static AcademicPlanBuilder stream() {
        return new AcademicPlanBuilder();
    }


    public AcademicPlanBuilder ability(String skillName) {
        SkillSourceText source = new SkillSourceText(skillName);
        _skillMap.put(skillName, new SkillAbility(source));
        return this;
    }


    public AcademicPlanBuilder experience(String skillName) {
        SkillSourceText source = new SkillSourceText(skillName);
        _skillMap.put(skillName, new SkillExperience(source));
        return this;
    }


    public AcademicPlanBuilder knowledge(String skillName) {
        SkillSourceText source = new SkillSourceText(skillName);
        _skillMap.put(skillName, new SkillKnowledge(source));
        return this;
    }


    public AcademicPlanBuilder subject(String subjectName) {

        _currentSubject = new Subject(subjectName);
        _subjects.put(subjectName, _currentSubject);
        return this;
    }


    public AcademicPlanBuilder requires(String skillName) {
        _currentSubject.requiredSkills().add(getSkill(skillName));
        return this;
    }


    public AcademicPlanBuilder produces(String skillName) {
        _currentSubject.producedSkills().add(getSkill(skillName));
        return this;
    }


    AcademicPlan build() {
        return new AcademicPlan(_subjects);
    }

    private Skill getSkill(String skillName) {
        return _skillMap.get(skillName);
    }
}
