package com.battlemetrics.controller;

import com.battlemetrics.model.response.Player;
import com.battlemetrics.model.response.PlayerOnlineStatus;
import com.battlemetrics.model.response.PlayerSession;
import com.battlemetrics.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable String playerId) {
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/{playerId}/sessions")
    public PlayerSession getPlayerSessionsById(@PathVariable String playerId) {
        return playerService.getPlayerSessionsById(playerId);
    }

    @GetMapping("/{playerId}/isOnline")
    public PlayerOnlineStatus isPlayerOnline(@PathVariable String playerId) {
        return playerService.isPlayerOnline(playerId);
    }
}