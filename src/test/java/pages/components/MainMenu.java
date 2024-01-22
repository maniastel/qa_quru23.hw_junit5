package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainMenu {

    public MainMenu checkMenuLinks (String menuLinks) {

        $$("ul#menu-header-glavnoe-menyu-2023").shouldHave(texts(menuLinks));
        return this;

    }

    public MainMenu selectSubcategory (String category, String subcategory) {
        $(withTagAndText("a", category)).hover();
        $(withTagAndText("span", subcategory)).shouldBe(Condition.visible);
        $(withTagAndText("span", subcategory)).click();
        return this;
    }

    public MainMenu checkOpenCategoryPage(String title)  {
        $("h1").shouldHave(text(title));
        return this;
    }

    public MainMenu selectCategory (String category) {
        $(withTagAndText("a", category)).click();
        return this;
    }

}
