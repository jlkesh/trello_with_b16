package uz.jl.trello.trello.utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/20:57 (Wednesday)
 * trello/IntelliJ IDEA
 */


@Component
@RequiredArgsConstructor
public class BaseUtils {

//    private final TextEncryptor encryptor;

    public static void main(String[] args) {
        StringBuilder stringBuffer = new StringBuilder("Hello");
        stringBuffer.append("beybeybeybeybey");
        System.out.println(stringBuffer.length());
        System.out.println("stringBuffer.capacity() = " + stringBuffer.capacity());

    }

    public String generateActivationToken(@NonNull Long id) {
        return generateActivationToken(String.valueOf(id));
    }

    public String generateActivationToken(@NonNull String text) {
        return UUID.randomUUID().toString();
    }

    public String decode(@NonNull String text) {
        return "";

    }


}

