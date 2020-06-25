package com.labs;

import java.util.Collection;

public interface SkillSet {
    void add(Skill skill);
    boolean contains(Skill skillSet);
    Collection<Skill> view();
}
