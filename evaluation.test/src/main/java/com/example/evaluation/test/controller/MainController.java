package com.example.evaluation.test.controller;

import com.example.evaluation.test.game.Game;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class MainController {

    int victoire = 0;
    int defaite = 0;
    int nul = 0;
    Game game = new Game();
    @GetMapping("/play/{action}")
    public String playGame(@PathVariable("action") String action) {

        game.setAction(action);
        game.setActionBot();
        game.play();

        if(game.play() == "victoire") {
            victoire++;
        } else if(game.play() == "defaite") {
            defaite++;
        } else if(game.play() == "égalité") {
            nul++;
        }

        return "Vous avez jouer " + action + " l'ordinateur a joué " + game.getActionBot() + "vous avez " + game.play();

    }

    @PostMapping("/restart")
    public void restartGame() {

        victoire = 0;
        defaite = 0;
        nul = 0;
    }

    @GetMapping("/score")
    public String getScore() {

        return "victoire : " + victoire + "| défaite : " + defaite + "| égalité : " + nul;
    }

    @PutMapping("/score/{win}/{lose}/{tie}")
    public void modifieScore(@PathVariable("win") int win, @PathVariable("win") int lose,@PathVariable("tie") int tie ) {

        victoire = win;
        defaite = lose;
        nul = tie;

    }

}
