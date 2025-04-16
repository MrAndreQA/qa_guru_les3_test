package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SimpleJUnitTest {

    /*@Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }*/

    /*dependencies {
        testImplementation (
                "com.codeborne:selenide:7.8.0",
                "org.junit.jupiter:junit-jupiter:5.11.4")
    }*/
int result;
private int getResult(){
    return 3;
}

@BeforeAll
static void beforeAll() {
    System.out.println("\n### beforeAll()\n");
}

    @BeforeEach
    void beforeEach() {
        System.out.println("###    beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###    afterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\n###  afterAll()\n");
    }

    @Test
    void firstTest() {
        System.out.println("###    firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###    secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("###    thirdTest()");
        Assertions.assertTrue(result > 2);
    }

}