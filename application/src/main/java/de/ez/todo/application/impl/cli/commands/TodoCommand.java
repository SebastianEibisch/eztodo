package de.ez.todo.application.impl.cli.commands;

import de.ez.todo.application.impl.cli.exceptions.CommandValidationException;

import java.util.Collections;
import java.util.List;

public abstract class TodoCommand {

    List<String> args = Collections.emptyList();

    public void prepare(final List<String> args) {
        this.args = args;
    }

    public abstract void validate() throws CommandValidationException;
    public abstract void execute();

}
