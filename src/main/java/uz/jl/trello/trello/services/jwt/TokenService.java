package uz.jl.trello.trello.services.jwt;


import uz.jl.trello.trello.config.security.SecurityUserDetails;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 11:11 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public interface TokenService {

    String generateToken(SecurityUserDetails userDetails);

    Boolean isValid(String token);


}
