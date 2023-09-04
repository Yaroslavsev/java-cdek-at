package live_coding_31_08_2023;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.live_coding_31_08_2023.filtering.CatalogPageObject;
import org.example.live_coding_31_08_2023.filtering.ProductPageObject;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class LamodaFiltersSteps {
    private CatalogPageObject catalogPageObject;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton\\Desktop\\Java AT IBS Training center\\chromedriver-win64\\chromedriver.exe");
    }

    @Given("{string} user on the lamoda site {string} page")
    public void anonimousUserOnTheLamodaSitePage(String user, String url) {
        if (!user.equals("anonimous")) {
            //TODO auth
        }
        catalogPageObject = new CatalogPageObject(url);
    }

    @When("set one {string} and {string} filter")
    public void setOneAndFilter(String filterKey, String filterValue) {
        catalogPageObject.checkFilter(filterKey, filterValue);
    }

    @Then("all products in search accordance {string} and {string}")
    public void allProductsInSearchAccordanceAnd(String descriptionKey, String filterValue) {
        for (int i = 0; i <= 3 && i < catalogPageObject.getNumberOfProductsInResult(); i++) {
            ProductPageObject productPageObject = catalogPageObject.clickOnProduct(i);
            if (!Objects.equals(descriptionKey, "Бренд")) {
                assertTrue(productPageObject.getProductPropertyValue(descriptionKey)
                        .toLowerCase()
                        .contains(filterValue.toLowerCase()));

                try {
                    productPageObject.backward();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                assertTrue(productPageObject.getProductBrandName().contains(filterValue));

                try {
                    productPageObject.backward();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catalogPageObject.close();
    }
}
