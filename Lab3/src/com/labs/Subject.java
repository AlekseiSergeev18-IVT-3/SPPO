package com.labs;


public class Subject {
    private SkillSet _requiredSkills;
    private SkillSet _producedSkills;
    private String _name;

    public Subject(String name) {
        _requiredSkills = new SkillSetHashed();
        _producedSkills = new SkillSetHashed();
        _name = name;
    }


    String name() {
        return _name;
    }


    public SkillSet requiredSkills() {
        return _requiredSkills;
    }


    public SkillSet producedSkills() {
        return _producedSkills;
    }
}
