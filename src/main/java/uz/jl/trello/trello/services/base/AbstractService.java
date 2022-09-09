package uz.jl.trello.trello.services.base;

import lombok.RequiredArgsConstructor;
import uz.jl.trello.trello.mappers.BaseMapper;
import uz.jl.trello.trello.mappers.GenericMapper;
import uz.jl.trello.trello.repositories.GenericRepository;
import uz.jl.trello.trello.utils.BaseUtils;

/**
 * @author "Elmurodov Javohir"
 * @since 09/09/22/18:59 (Friday)
 * trello/IntelliJ IDEA
 */
@RequiredArgsConstructor
public abstract class AbstractService<R extends GenericRepository, M extends GenericMapper> {
    protected final R repository;
    protected final M mapper;
    protected final BaseUtils utils;
}
