package uz.jl.trello.trello.services;

import lombok.NonNull;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:18 (Thursday)
 * trello/IntelliJ IDEA
 */
public interface GenericService<ID, CD, UD> extends BaseService {

    ID create(@NonNull CD dto);

    void delete(@NonNull ID id);

    void update(@NonNull UD dto);

}
