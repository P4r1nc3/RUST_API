package com.battlemetrics.dao.response.bmapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerResponse {
    private PlayerData data;

    @Data
    public static class PlayerData {
        private String type;
        private String id;
        private PlayerAttributes attributes;
    }

    @Data
    public static class PlayerAttributes {
        private String id;
        private String name;
        private boolean isPrivate;
        private boolean positiveMatch;
        private String createdAt;
        private String updatedAt;
    }
}
