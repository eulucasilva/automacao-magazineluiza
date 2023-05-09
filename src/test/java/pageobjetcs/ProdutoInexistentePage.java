package pageobjetcs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import static org.junit.Assert.assertEquals;

public class ProdutoInexistentePage extends Utils {

    protected WebDriver driver;

    public ProdutoInexistentePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "h1[data-testid='text-list-title']")
    private WebElement txtProdutoInexistente;

    @FindBy(how = How.ID, using = "input-search")
    private WebElement campoBuscar;

    @FindBy(how = How.CSS, using = "button[data-testid='button-message-box']")
    private WebElement btnFechar;

    public void fechaJanelaCookies () {
        esperarElemento(btnFechar);
        btnFechar.click();
    }

    public void digitarProduto (String nomeproduto) {
        esperarElemento(campoBuscar);
        campoBuscar.sendKeys(nomeproduto);
        campoBuscar.sendKeys(Keys.ENTER);
    }

    public void validaTelaProdutoInexistente (String produto){
        String txt = "Sua busca por " + "\"" + produto + "\"" + " não encontrou resultado algum :(";
        esperarElemento(txtProdutoInexistente);
        assertEquals(txt, txtProdutoInexistente.getText());
    }


}
