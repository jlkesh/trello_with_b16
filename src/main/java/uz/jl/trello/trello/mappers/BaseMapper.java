package uz.jl.trello.trello.mappers;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:48 (Thursday)
 * trello/IntelliJ IDEA
 */

public interface BaseMapper<E, D, CD, UD> {

    E fromDto(D dto);

    E fromCreateDto(CD dto);

    E fromUpdateDto(UD dto);

    D toDto(E domain);

    List<D> toDto(List<E> domains);
}
