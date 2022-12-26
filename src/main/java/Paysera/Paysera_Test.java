package Paysera;

import Utils.BSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class Paysera_Test extends BSD {
    public Paysera_Test(){

    }
    public static void main(String[] args) {

        driver.get("https://www.paysera.ee/v2/en-EE/fees/currency-conversion-calculator#/");
        JavascriptExecutor js=(JavascriptExecutor) driver;

        WebElement ddm1 = driver.findElement(By.className("js-localization-popover"));
        ddm1.click();

        wait(3);

        WebElement ddm2 = driver.findElement(By.cssSelector("button[data-toggle='dropdown']"));
        ddm2.click();

        wait(3);

        WebElement country = driver.findElement(By.linkText("Poland"));
        country.click();

        wait(3);

        WebElement bankAmount = driver.findElement(By.xpath("//th[contains(text(),'mBank amount')]//following::span[10]"));
        js.executeScript("arguments[0].scrollIntoView()", bankAmount);
        System.out.println("bankAmount = " + bankAmount.getText());

        wait(3);

        WebElement payseraAmount = driver.findElement(By.xpath("//th[@data-ng-if='provider === currencyExchangeVM.PROVIDERS.COMMERCIAL']//following::span[7]"));
        js.executeScript("arguments[0].scrollIntoView()", payseraAmount);
        System.out.println("payseraAmount = " + payseraAmount.getText());

        double bankAmount2 = Double.parseDouble(bankAmount.getText());
        double payseraAmount2 = Double.parseDouble(payseraAmount.getText());
        double loss=0;

        if (bankAmount2 < payseraAmount2){
            loss = (bankAmount2 - payseraAmount2);
        }
        System.out.println("loss = " + loss);

        wait(3);
        waitAndClose();
    }
}
