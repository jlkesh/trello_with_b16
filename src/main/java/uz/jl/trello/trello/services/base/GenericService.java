package uz.jl.trello.trello.services.base;

import lombok.NonNull;
import uz.jl.trello.trello.dtos.Dto;
import uz.jl.trello.trello.dtos.GenericDto;

import java.io.Serializable;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:18 (Thursday)
 * trello/IntelliJ IDEA
 */
public interface GenericService<ID extends Serializable, CD extends Dto, UD extends GenericDto> extends BaseService {

    ID create(@NonNull CD dto);

    void delete(@NonNull ID id);

    void update(@NonNull UD dto);

}
