package com.labs;


public class SkillAbility implements Skill {
    private SkillSource _source;

    public SkillAbility(SkillSource source) {
        _source = source;
    }

    @Override
    public void visit(SkillVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("A{%s}",  _source.name());
    }
}
