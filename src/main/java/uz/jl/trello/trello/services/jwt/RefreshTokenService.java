package uz.jl.trello.trello.services.jwt;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.jl.trello.trello.config.security.SecurityUserDetails;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:13 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Service
public class RefreshTokenService extends AbstractTokenService implements TokenService {

    @Value("${jwt.refresh.token.secret}")
    private String refreshTokenSecret;

    @Value("${jwt.refresh.token.expiry.adding.amount}")
    private Integer amountToAdd;

    @Value("${jwt.refresh.token.expiry.time.unit}")
    private String unit;


    @Override
    public String generateToken(SecurityUserDetails userDetails) {
        return jwt(userDetails.getUsername());
    }

    @Override
    public Boolean isValid(String token) {
        return super.isTokenValid(token, refreshTokenSecret);
    }


    public String getSubject(String token) {
        return super.getSubject(token, refreshTokenSecret);
    }



    public String jwt(@NonNull String subject) {
        return super.jwt(subject, this.refreshTokenSecret, this.amountToAdd,  ChronoUnit.valueOf(this.unit));
    }
}
