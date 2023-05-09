package pageobjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoverCarrinhoPage extends Utils {

    protected WebDriver driver;

    public RemoverCarrinhoPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "a[data-testid='bag-button-container']")
    private WebElement btnSacola;

    @FindBy(how = How.CSS, using = "span[class='BasketItem-delete-label']")
    private WebElement btnExcluir;

    @FindBy(how = How.XPATH, using = "//div[@class='EmptyBasket-title']")
    private WebElement txtSacolaVazia;



    public void clicarSacola(){
        esperarElemento(btnSacola);
        btnSacola.click();
    }

    public void excluirItem(){
        esperarElemento(btnExcluir);
        btnExcluir.click();
    }
    public void validarExclusao(){
        esperarElemento(txtSacolaVazia);
        assertEquals("Sua sacola está vazia", txtSacolaVazia.getText());
    }

}
