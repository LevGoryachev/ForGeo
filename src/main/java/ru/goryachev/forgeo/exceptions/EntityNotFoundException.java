package ru.goryachev.forgeo.exceptions;
/**
 * EntityNotFoundException is an application exception for case if entity not found
 * @author Lev Goryachev
 * @version 3
 */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Long id) {
        super(String.format("Object with ID %d not found in database", id));
    }
}
