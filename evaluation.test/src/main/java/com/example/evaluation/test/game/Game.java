package com.example.evaluation.test.game;

import java.util.InputMismatchException;
import java.util.Random;

public class Game {

    private String action;
    private String actionBot;

    public void setAction(String action) {
        if(action == "pierre" || action == "feuille" || action == "ciseaux") {
            this.action = action;
        } else {
            new InputMismatchException();
        }

    }

    public void setActionBot() {

        int randomInt = new Random().nextInt(1,3);
        if(randomInt == 1) {
            actionBot = "pierre";
        } else if (randomInt == 2) {
            actionBot = "feuille";
        } else if (randomInt == 3) {
            actionBot = "ciseaux";
        }
    }

    public String getAction() {
        return action;
    }

    public String getActionBot() {
        return actionBot;
    }

    public String play() {

        if(actionBot == "pierre" && action == "pierre") {
            return "égalité";
        }
        if(actionBot == "feuille" && action == "feuille") {
            return "égalité";
        }
        if(actionBot == "siceaux" && action == "siceaux") {
            return "égalité";
        }

        if(actionBot == "siceaux" && action == "pierre") {
            return "victoire";
        }

        if(actionBot == "siceaux" && action == "feuille") {
            return "défaite";
        }

        if(actionBot == "pierre" && action == "siceaux") {
            return "défaite";
        }

        if(actionBot == "pierre" && action == "feuille") {
            return "victoire";
        }

        if(actionBot == "feuille" && action == "siceaux") {
            return "victoire";
        }

        if(actionBot == "feuille" && action == "pierre") {
            return "défaite";
        }
        return "";
    }
}
