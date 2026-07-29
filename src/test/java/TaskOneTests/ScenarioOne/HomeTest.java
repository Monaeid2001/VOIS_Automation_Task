package TaskOneTests.ScenarioOne;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import taskOnePages.scenarioOne.SearchResultsPage;
import utils.JsonReader;

public class HomeTest extends BaseTest {
    SearchResultsPage searchResultsPage;

    @Test
    public void searchForItem(){
        searchResultsPage =
                homePage
                .searchForItem(testData.getJsonData("searchedItem"));

        Assert.assertEquals(searchResultsPage.getSearchResultsText(), "Results", "Search results text does not match expected value.");
    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("amazon-data");
    }


}

