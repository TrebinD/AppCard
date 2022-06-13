
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppCardTest {

    @Test
    public void validData() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Москва");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Васильев Дмитрий");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        $x("//div [@data-test-id=\"notification\"]").should(visible, Duration.ofSeconds(15));
    }

    @Test
    public void validNameDef() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Москва");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Орлов-Львовский Дмитрий");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        $x("//div [@data-test-id=\"notification\"]").should(visible, Duration.ofSeconds(15));
    }


    @Test
    public void nonValidCity() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Asd");
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Васильев Дмитрий");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $("[data-test-id='city'].input_invalid .input__sub").getText();
        String expected = "Доставка в выбранный город недоступна";

        assertEquals(actual, expected);
    }

    @Test
    public void nonValidDateDownDown() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Васильев Дмитрий");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $x("//span [@data-test-id=\"date\"] ").getText();
        String expected = "Заказ на выбранную дату невозможен";

        assertEquals(actual, expected);
    }

    @Test
    public void nonValidDateDayToDay() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Васильев Дмитрий");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $x("//span [@data-test-id=\"date\"] ").getText();
        String expected = "Заказ на выбранную дату невозможен";

        assertEquals(actual, expected);
    }

    @Test
    public void nonValidDateUpToDay() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 2);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Васильев Дмитрий");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $x("//span [@data-test-id=\"date\"] ").getText();
        String expected = "Заказ на выбранную дату невозможен";

        assertEquals(actual, expected);
    }

    @Test
    public void nonValidNameLanguage() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 5);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Vasiliii");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $("[data-test-id = \"name\"].input_invalid .input__sub").getText();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";

        assertEquals(actual, expected);
    }


    @Test
    public void nonValidNameNumbers() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Василий Теркин123");
        $x("//input [@name = \"phone\"]").val("+79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $("[data-test-id = \"name\"].input_invalid .input__sub").getText();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";

        assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberNonPlus() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Василий Теркин");
        $x("//input [@name = \"phone\"]").val("79112356598");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $("[data-test-id = \"phone\"].input_invalid .input__sub").getText();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";

        assertEquals(actual, expected);
    }

    @Test
    public void phoneNumberLetter() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Василий Теркин");
        $x("//input [@name = \"phone\"]").val("+7911033ААББ");
        $(".checkbox__box").click();
        $x("//span [text() = \"Забронировать\"]").click();
        String actual = $("[data-test-id = \"phone\"].input_invalid .input__sub").getText();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";

        assertEquals(actual, expected);
    }

    @Test
    public void nonClickCheckbox() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        String date = formater.format(c.getTime());

        open("http://localhost:9999/");
        $x("// input [@placeholder = \"Город\"]").setValue("Санкт-Петербург");
        $(".menu-item__control").click();
        $x("//input [@placeholder=\"Дата встречи\"]").doubleClick();
        $x("//input [@placeholder=\"Дата встречи\"]").sendKeys(Keys.BACK_SPACE);
        $x("//input [@placeholder=\"Дата встречи\"]").val(date);
        $x("// input [@name = \"name\"]").val("Василий Теркин");
        $x("//input [@name = \"phone\"]").val("+79110332255");
        $x("//span [text() = \"Забронировать\"]").click();
        assertTrue($("[data-test-id='agreement'].input_invalid").isDisplayed());
    }

}
