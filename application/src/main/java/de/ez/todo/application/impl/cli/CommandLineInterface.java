package de.ez.todo.application.impl.cli;

import de.ez.todo.application.impl.cli.commands.Command;
import de.ez.todo.application.impl.cli.commands.TodoCommand;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Profile("!test")
@Component
public class CommandLineInterface implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Scanner s = new Scanner(System.in);

        while(true) {
            String line = s.nextLine();

            List<String> input = Arrays.asList(line.split(" "));

            if( input.isEmpty() )
                return;

            ClassPathScanningCandidateComponentProvider componentProvider = new ClassPathScanningCandidateComponentProvider(true);
            componentProvider.addIncludeFilter( new AnnotationTypeFilter(Command.class) );

            for (BeanDefinition bd : componentProvider.findCandidateComponents("de.ez.todo.application.impl.cli.commands")) {
                Class<?> clazz = Class.forName(bd.getBeanClassName());

                TodoCommand command = (TodoCommand) clazz.newInstance();
                String commandName =  command.getClass().getAnnotation(Command.class).name();

                if(commandName.equals( input.get(0) )) {
                    command.prepare( input );
                    command.validate();
                    command.execute();
                }

            }
        }

    }
}
