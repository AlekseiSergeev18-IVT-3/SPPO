package com.labs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;


public class AcademicPlanBuilder {
    private Subject _currentSubject;
    private HashMap<String, Subject> _subjects;
    private HashMap<String, Skill> _skillMap;
    static int AcademicPlanBuilder = 0;
    ClassPathXmlApplicationContext ctx;

    private AcademicPlanBuilder() {
        _subjects = new HashMap<>();
        _skillMap = new HashMap<>();
        ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
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
        AcademicPlanBuilder ++;
       // ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        _currentSubject = ctx.getBean("Subject", Subject.class);
        //_currentSubject = new Subject();
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
