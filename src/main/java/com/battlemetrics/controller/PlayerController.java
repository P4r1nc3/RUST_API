package com.battlemetrics.controller;

import com.battlemetrics.dao.response.bmapi.PlayerResponse;
import com.battlemetrics.dao.response.PlayerStatusResponse;
import com.battlemetrics.dao.response.bmapi.PlayerSessionResponse;
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
    private final PlayerService playerService;

    @GetMapping("/{playerId}")
    public PlayerResponse getPlayerById(@PathVariable int playerId) {
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/{playerId}/sessions")
    public PlayerSessionResponse getPlayerSessionsById(@PathVariable int playerId) {
        return playerService.getPlayerSessionsById(playerId);
    }

    @GetMapping("/{playerId}/isOnline")
    public PlayerStatusResponse isPlayerOnline(@PathVariable int playerId) {
        PlayerSessionResponse playerSession = playerService.getPlayerSessionsById(playerId);
        return playerService.isPlayerOnline(playerSession);
    }
}