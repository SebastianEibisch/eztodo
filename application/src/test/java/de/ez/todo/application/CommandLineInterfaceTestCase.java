package de.ez.todo.application;

import de.ez.todo.application.impl.cli.CommandLineInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class CommandLineInterfaceTestCase {

    @Test
    public void cliTest() throws Exception {
        System.out.println("test");
    }

}
