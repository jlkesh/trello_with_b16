package uz.jl.trello.trello.controllers;

import lombok.RequiredArgsConstructor;
import uz.jl.trello.trello.services.BaseService;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:08 (Thursday)
 * trello/IntelliJ IDEA
 */
@RequiredArgsConstructor
public abstract class ApiController<S extends BaseService> {
    protected final S service;
    protected final String API = "/api";
    protected final String V1 = "/v1";
}
