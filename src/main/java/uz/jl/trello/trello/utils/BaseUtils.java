package uz.jl.trello.trello.utils;

import org.springframework.stereotype.Component;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/20:57 (Wednesday)
 * trello/IntelliJ IDEA
 */


@Component
public class BaseUtils {
    public static void main(String[] args) {
        StringBuilder stringBuffer = new StringBuilder("Hello");
        stringBuffer.append("beybeybeybeybey");
        System.out.println(stringBuffer.length());
        System.out.println("stringBuffer.capacity() = " + stringBuffer.capacity());

    }

}

