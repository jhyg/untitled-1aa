package untitled.aa.common;


import untitled.aa.BoundedContext366Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BoundedContext366Application.class })
public class CucumberSpingConfiguration {
    
}
