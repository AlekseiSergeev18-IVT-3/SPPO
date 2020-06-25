package com.labs;


public class SkillSourceText implements SkillSource {
    private String _name;

    public SkillSourceText(String name) {
        _name = name;
    }

    @Override
    public String name() {
        return _name;
    }
}
