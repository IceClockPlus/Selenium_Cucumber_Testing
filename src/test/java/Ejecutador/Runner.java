package Ejecutador;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features= {".src/test/resources/Feature/EscenarioTransferencia.feature"}, glue= {".src/test/java/DefinicionPasos/"})

public class Runner {

}
