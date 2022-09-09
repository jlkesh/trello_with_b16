package uz.jl.trello.trello.services;

import lombok.RequiredArgsConstructor;
import uz.jl.trello.trello.utils.BaseUtils;

/**
 * @author "Elmurodov Javohir"
 * @since 09/09/22/18:59 (Friday)
 * trello/IntelliJ IDEA
 */
@RequiredArgsConstructor
public abstract class AbstractService<R, M> {
    protected final R repository;
    protected final M mapper;
    private final BaseUtils utils;
}
