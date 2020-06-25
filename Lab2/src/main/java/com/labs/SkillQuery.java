package com.labs;

import java.util.ArrayList;
import java.util.List;


public class SkillQuery {
    private Skill _skill;
    private ArrayList<Subject> _subjects;

    SkillQuery(Skill skill) {
        _skill = skill;
        _subjects = new ArrayList<>();
    }

    void add(Subject subject) {
        _subjects.add(subject);
    }

    Skill skill() {
        return _skill;
    }

    List<Subject> subjects() {
        return _subjects;
    }
}
