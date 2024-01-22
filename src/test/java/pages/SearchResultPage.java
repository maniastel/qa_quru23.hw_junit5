package pages;

import com.codeborne.selenide.CollectionCondition;
import pages.components.SearchBar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    SearchBar search = new SearchBar();

    public SearchResultPage checkSearchResult (String searchQuery) {
        search.setSearchQuery(searchQuery);
        $("h1").shouldHave(text(searchQuery));
        $$("article").shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }


}
