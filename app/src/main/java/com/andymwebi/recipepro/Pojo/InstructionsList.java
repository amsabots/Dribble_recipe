package com.andymwebi.recipepro.Pojo;

public class InstructionsList {
    private int id, number, belongsTo;
    private String instructions;

    public InstructionsList(int id, int number, int belongsTo, String instructions) {
        this.id = id;
        this.number = number;
        this.belongsTo = belongsTo;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "InstructionsList{" +
                "id=" + id +
                ", number=" + number +
                ", belongsTo=" + belongsTo +
                ", instructions='" + instructions + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(int belongsTo) {
        this.belongsTo = belongsTo;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
