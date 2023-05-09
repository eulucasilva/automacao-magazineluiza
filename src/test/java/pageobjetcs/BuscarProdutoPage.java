package pageobjetcs;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import static org.junit.Assert.assertEquals;

public class BuscarProdutoPage extends Utils {

    protected WebDriver driver;

    public BuscarProdutoPage(WebDriver driver) {
//		PageFactory é uma classe fornecida pelo Selenium WebDriver para implementar o
//		PageObject. Usando-o, você pode inicializar os objetos de página definidos ou instanciá-los
//		diretamente.
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "input-search")
    private WebElement campoBuscar;

    @FindBy(how = How.CSS, using = "#search-container > div.sc-jrcTuL.bgNHmD.sc-caPbAK.OyJzl > svg")
    private WebElement lupa;

    @FindBy(how = How.CSS, using = "#__next > div > main > section:nth-child(5) > div.sc-eDvSVe.jzcpYb > div > h1")
    private WebElement nomeProduto;

    @FindBy(how = How.CSS, using = "button[data-testid='button-message-box']")
    private WebElement btnFechar;

    @FindBy(how = How.CSS, using = "div[data-testid='close-btn']")
    private WebElement btnFecharEnd;


    public void digitarProduto (String nomeproduto) {
        esperarElemento(campoBuscar);
        campoBuscar.sendKeys(nomeproduto);
        campoBuscar.sendKeys(Keys.ENTER);
    }

    public void fechaJanelaCookies () {
        esperarElemento(btnFechar);
        btnFechar.click();
    }

    public void fechaJanelaEndereco (){
        esperarElemento(btnFecharEnd);
        btnFecharEnd.click();
    }

    public void validaTelaProdutoExistente(String produto) {
        esperarElemento(nomeProduto);
        assertEquals(produto.toLowerCase(), nomeProduto.getText());
    }
}
