package boardGame.Characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import boardGame.Artifact;
import boardGame.Skill;

public abstract class Figure {  
    private String name;
    private int lifepoints = 20, xPosition, yPosition;
    private Map<String, Skill> skills;
    private List<Artifact> artifacts;

    public Figure(String name, int intelligence, int strength, int constitution, int agility) {
        this.name = name;

        artifacts = new ArrayList<>();
        skills = new HashMap<>();

        skills.put("intelligence", new Skill(intelligence));
        skills.put("strength", new Skill(strength));
        skills.put("constitution", new Skill(constitution));
        skills.put("agility", new Skill(agility));
    }

    public abstract void move();
    public abstract void attack();
    public abstract void defend();

    public void addArtifact(Artifact artifact) {
        artifacts.add(artifact);
    }

    public void removeArtifact(Artifact artifact) {
        artifacts.remove(artifact);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public void setXPosition(int x) {
        this.xPosition = x;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(int y) {
        this.yPosition = y;
    }

    public int getLifepoints() {
        return this.lifepoints;
    }

    public void increaseLifepoints(int dLifepoints) {
        // Max 20
        this.lifepoints = Math.min(20, this.lifepoints + dLifepoints);
    }

    public void decreaseLifepoints(int dLifepoints) {
        // Min 0
        this.lifepoints = Math.max(0, this.lifepoints - dLifepoints);
    }
}