package com.example.evolution;

public class Map {

    public Map(int[][] input) {
        positionData = new int[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                positionData[i][j] = input[i][j];
            }
        }
        dogY = 0;
        dogX = 0;
    }
    public int[][] positionData;

    public int dogX;
    public int dogY;


    public String move(String input) {
        if(input.equals("up")) {
            if(dogY==0){
                return null;
            }
            if (positionData[dogY-1][dogX]==1) {
                return null;
            }
            dogY--;
            return "up";
        }
        if(input.equals("down")) {
            if(dogY==4){
                return null;
            }
            if (positionData[dogY+1][dogX]==1) {
                return null;
            }
            dogY++;
            return "down";
        }
        if(input.equals("left")) {
            if(dogX==0){
                return null;
            }
            if (positionData[dogY][dogX-1]==1) {
                return null;
            }
            dogX--;
            return "left";
        }
        if(input.equals("right")) {
            if(dogX==4){
                return null;
            }
            if (positionData[dogY][dogX+1]==1) {
                return null;
            }
            dogX++;
            return "right";
        }
        return "";
    }
}
