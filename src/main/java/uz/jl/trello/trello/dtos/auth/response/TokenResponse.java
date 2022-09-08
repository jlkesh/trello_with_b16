package uz.jl.trello.trello.dtos.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:32 (Thursday)
 * trello/IntelliJ IDEA
 */
@Data
@Builder
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
    private String username;
}
