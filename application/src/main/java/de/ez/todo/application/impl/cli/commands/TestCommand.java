package de.ez.todo.application.impl.cli.commands;

import de.ez.todo.application.impl.cli.exceptions.CommandValidationException;

@Command(name= TestCommand.COMMAND_NAME)
public class TestCommand extends TodoCommand {

    public static final String COMMAND_NAME = "test";

    @Override
    public void validate() throws CommandValidationException {

    }

    @Override
    public void execute() {
        System.out.println("Ich teste");
    }
}
