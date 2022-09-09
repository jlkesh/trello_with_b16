package uz.jl.trello.trello.services.base;

import uz.jl.trello.trello.criteria.GenericCriteria;
import uz.jl.trello.trello.dtos.Dto;
import uz.jl.trello.trello.dtos.GenericDto;

import java.io.Serializable;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:19 (Thursday)
 * trello/IntelliJ IDEA
 */
public interface GenericCrudService<ID extends Serializable,
        D extends GenericDto,
        CD extends Dto,
        UD extends GenericDto,
        C extends GenericCriteria> extends GenericService<ID, CD, UD>, GenericReadService<ID, C, D> {
}
