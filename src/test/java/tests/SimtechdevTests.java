package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchResultPage;
import pages.components.MainMenu;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тесты для сайта SimtechDev")
public class SimtechdevTests extends TestBase {

    MainMenu menu = new MainMenu();
    SearchResultPage search = new SearchResultPage();

    @BeforeAll
    public static void setUp() {
        open("https://simtechdev.ru/");
    }

    @ValueSource(strings = {
            "Решения", "Услуги", "CS-Cart", "Инфраструктура", "О компании", "Блог", "Helpdesk"
    })
    @ParameterizedTest(name = "Отображение ссылок главного меню в хедере")
    @Tag("SMOKE")
    public void mainMenuLinksTest (String menuLinks) {
        menu.checkMenuLinks(menuLinks);
    }

    @CsvFileSource(resources = "/test_data/data.csv")
    @ParameterizedTest(name = "Переход на страницу подкатегории {1} категории {0}")
    @Tag("BLOCKER")
    public void openSubcategoryPageTest (String category, String subcategory, String title) {
        menu.selectSubcategory(category, subcategory)
                .checkOpenCategoryPage(title);
    }

    static Stream<Arguments> searchOnBlogPageTest () {
        return Stream.of(
                Arguments.of(
                        "Блог", "товары"),
                Arguments.of(
                        "Блог", "маркетплейс")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Поиск {1} на странице Блог")
    @Tag("SMOKE")
    public void searchOnBlogPageTest (String category, String searchQuery) {
        menu.selectCategory(category)
                .checkOpenCategoryPage(category);
        search.checkSearchResult(searchQuery);
    }


}
