package pageobjetcs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdicionarCarrinhoPage extends Utils {
    protected WebDriver driver;

    public AdicionarCarrinhoPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#__next > div > main > section:nth-child(5) > div.sc-eDvSVe.koHJnT > div > ul > li:nth-child(1)")
    private WebElement produto;

    @FindBy(how = How.CSS, using = "button[data-testid='bagButton']")
    private WebElement btnAdicionar;

    @FindBy(how = How.CSS, using = "button[class='BasketContinue-button']")
    private WebElement btnContinuar;

    @FindBy(how = How.CSS, using = "button[data-testid='summary-continue-btn']")
    private WebElement btnIrSacola;

    @FindBy(how = How.CSS, using = "a[class='BasketContinue-buyMore']")
    private WebElement btnMaisProdutos;

    //


    public void clicarProduto () {
        esperarElemento(produto);
        produto.click();
    }

    public void adicionarProduto () {
        esperarElemento(btnAdicionar);
        btnAdicionar.click();
        esperarElemento(btnIrSacola);
        if (btnIrSacola.isDisplayed()) {
            btnIrSacola.click();
       }
    }

    public void verificarProdutoCarrinho() throws InterruptedException {
        esperarElemento(btnContinuar);
        rolarPagina(700);
        Assert.assertTrue(btnContinuar.isDisplayed());
        btnMaisProdutos.click();
    }
}
