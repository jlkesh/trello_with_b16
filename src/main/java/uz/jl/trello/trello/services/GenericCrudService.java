package uz.jl.trello.trello.services;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:19 (Thursday)
 * trello/IntelliJ IDEA
 */
public interface GenericCrudService<ID, D, CD, UD, C> extends GenericService<ID, CD, UD>, GenericReadService<ID, C, D> {
}
