package ru.goryachev.forgeo.exceptions;
/**
 * EmptyListException is an application exception for empty list cases
 * @author Lev Goryachev
 * @version 3
 */
public class EmptyListException extends Exception {

    public EmptyListException() {
        super(String.format("Requested list is empty. No such objects in ForGeo database."));
    }
}
