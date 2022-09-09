package uz.jl.trello.trello.services.base;

import lombok.NonNull;
import uz.jl.trello.trello.criteria.GenericCriteria;
import uz.jl.trello.trello.dtos.GenericDto;

import java.io.Serializable;
import java.util.List;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:15 (Thursday)
 * trello/IntelliJ IDEA
 */
public interface GenericReadService<ID extends Serializable, C extends GenericCriteria, D extends GenericDto> extends BaseService {
    List<D> getAll(@NonNull C criteria);

    D get(@NonNull ID id);
}
