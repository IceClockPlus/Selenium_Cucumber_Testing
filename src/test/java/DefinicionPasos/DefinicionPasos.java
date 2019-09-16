package DefinicionPasos;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinicionPasos {
	static String driverPath="./src/test/resources/chrome/chromedriver.exe";
    static String TipoWebdriver="webdriver.chrome.driver";
    static WebDriver driver;
    static String enviado="0";
    @Before
	public void setUp() throws Exception {
		System.setProperty(TipoWebdriver,driverPath);
		//WebDriver driver=new FirefoxDriver();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}

	@After
	public void tearDown() throws Exception {
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  if (driver !=null)
		  	driver.quit();
	}

	@Given("^Navegar hasta la url ruralvia \"([^\"]*)\"$")
    public void navegar_hasta_la_url_ruralvia(String url) throws Throwable {
        driver.get(url);
        //driver.navigate().refresh(); 
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @When("^Indicar el usuario \"([^\"]*)\" como \"([^\"]*)\"$")
    public void indicar_el_usuario_como(String usuario, String valor) throws Throwable {
    	driver.switchTo().frame("demopral");
    	driver.findElement(By.xpath(usuario)).clear();
    	driver.findElement(By.xpath(usuario)).sendKeys(valor);
    }

    @When("^Indicar el password \"([^\"]*)\"  como \"([^\"]*)\"$")
    public void indicar_el_password_como(String clave, String valor) throws Throwable {
    	driver.findElement(By.xpath(clave)).clear();
    	driver.findElement(By.xpath(clave)).sendKeys(valor);
    }

    @When("^Hacer click en Entrar \"([^\"]*)\"$")
    public void hacer_click_en_Entrar(String boton) throws Throwable {
         
        driver.findElement(By.xpath(boton)).click();
    }

    @When("^Seleccionar contrato cuenta \"([^\"]*)\"$")
    public void seleccionar_el_contrato_cuenta(String enlace) throws Throwable {
    	 driver.findElement(By.xpath(enlace)).click();
    	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^Click en el link de transferencia \"([^\"]*)\"$")
    public void click_en_el_link_de_transferencia(String link) throws Throwable {
        driver.findElement(By.linkText(link)).click();
    }

       
    @When("^Indicar la cuenta de cargo \"([^\"]*)\"$")
    public void indica_la_cuenta_de_cargo(String cargo ) throws Throwable {
    	Select Lista= new Select(driver.findElement(By.name(cargo)));
  	    //Lista.selectByIndex(1);
    	Lista.selectByVisibleText("30000001490000222288 | CTA CORRIENTE | Euro");
    }

    @When("^Indica la cuenta beneficiaria \"([^\"]*)\"$")
    public void indica_la_cuenta_beneficiaria(String benefic) throws Throwable {
    	enviado= driver.findElement(By.name("IMPORTR")).getAttribute("value");
    	Select Lista= new Select(driver.findElement(By.xpath(benefic)));
  	    Lista.selectByIndex(1); 
    }
    @When("^Click en el link aceptar \"([^\"]*)\"$")
    public void click_en_el_link_aceptar(String link) throws Throwable {
    	driver.findElement(By.xpath(link)).click();
    }

    @Then("^el importe enviado debe ser al importe recibido$")
    public void el_importe_enviado_debe_ser_igual_al_importe_recibido( ) throws Throwable {
    	String recibido="0";
    	
    	recibido= driver.findElement(By.xpath("//*[@id=\'BODY_DATO\']/table/tbody/tr[7]/td[2]" )).getText();
    	System.out.println("Enviado: "+enviado+ " Recibido: "+recibido);
    	Assert.assertEquals(enviado, recibido);
    }
	
    @Given("^al navegar hasta la url \"([^\"]*)\"$")
    public void al_navegar_hasta_la_url(String url) throws Throwable {
         driver.get(url);
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.manage().deleteAllCookies();
    }
    
    @When("^coloca en el campo usuario \"([^\"]*)\" el texto \"([^\"]*)\"$")
    public void coloca_en_el_campo_usuario_el_texto(String usuario, String valor) throws Throwable {
    	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.switchTo().frame("demopral");
    	driver.findElement(By.xpath(usuario)).clear();
    	driver.findElement(By.xpath(usuario)).sendKeys(valor);
    }

    @When("^coloca en el campo password \"([^\"]*)\" el texto \"([^\"]*)\"$")
    public void coloca_en_el_campo_password_el_texto(String clave, String valor) throws Throwable {
    	 driver.findElement(By.xpath(clave)).clear();  
    	 driver.findElement(By.xpath(clave)).sendKeys(valor);
    }

    @When("^hacer click sobre el boton Entrar \"([^\"]*)\"$")
    public void hacer_click_sobre_el_boton_Entrar(String boton) throws Throwable {
         
        driver.findElement(By.xpath(boton)).click();
    }

    @When("^seleccionar contrato \"([^\"]*)\"$")
    public void seleccionar_contrato(String enlace) throws Throwable {
    	 
    	 driver.findElement(By.xpath(enlace)).click();
    	 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    
    @When("^hacer click en el link de transferencia \"([^\"]*)\"$")
    public void hacer_click_en_el_link_de_transferencia(String link) throws Throwable {
    	 
    	 driver.findElement(By.linkText(link)).click();
    }

    @When("^hacer click en el link aceptar \"([^\"]*)\"$")
    public void hacer_click_en_el_link_aceptar(String link) throws Throwable {
    	driver.findElement(By.xpath(link)).click();
    }

    @Then("^Presenta el mensaje de alerta$")
    public void presenta_el_mensaje_de_alerta() throws Throwable {
        Alert error=driver.switchTo().alert();
        System.out.println(error.getText());
        Assert.assertEquals("Debe de seleccionar una cuenta.",error.getText());
        	         
    }

}
