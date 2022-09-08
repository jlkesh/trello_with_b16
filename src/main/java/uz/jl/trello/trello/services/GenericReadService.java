package uz.jl.trello.trello.services;

import lombok.NonNull;

import java.util.List;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:15 (Thursday)
 * trello/IntelliJ IDEA
 */
public interface GenericReadService<ID, C, D> extends BaseService {
    List<D> getAll(@NonNull C criteria);

    D get(@NonNull ID id);
}
