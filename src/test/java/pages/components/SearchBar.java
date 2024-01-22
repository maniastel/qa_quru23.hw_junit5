package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchBar {

    private final SelenideElement searchBar = $("input.elementor-search-form__input"),
                            searchButton = $("button.elementor-search-form__submit");

    public SearchBar setSearchQuery (String searchQuery) {
        searchBar.click();
        searchBar.setValue(searchQuery);
        searchButton.click();
        return this;
    }


}
