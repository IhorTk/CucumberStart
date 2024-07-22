package CucumberHomeWork.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWork {
    public TableWork() {
    }
    //работа с таблицами

    //олучение List<WebElement> строк
    public List<WebElement> getListRows(WebElement table) {
        return table.findElements(By.xpath("*//tr"));
    }

    //Получение индекса столбца по названию
    public int getIndexCollTable(WebElement table, String valueHeader) {
        List<WebElement> header = table.findElements(By.xpath("*//th"));
        for (int i = 0; i < header.size(); i++) {
            if (header.get(i).getText().equals(valueHeader)) {
                return i;
            }
        }
        return -1;
    }

    //Получение List<String>по  названиию колонки
    public List<WebElement> getListColAufValue(WebElement table, String colName) {
        List<WebElement> listCol = new ArrayList<>();
        int indexCol = getIndexCollTable(table, colName);
        List<WebElement> rows = getListRows(table);
        for (int i = 1; i <rows.size() ; i++) {
            List<WebElement> colls = rows.get(i).findElements(By.xpath(".//td"));
            listCol.add(colls.get(indexCol));
        }
        return listCol;
    }

    //Получение суммы всех продуктов
    public double getTotalSum(WebElement table, String colName) {
        double sum = 0.00;
        List<WebElement> numbers = getListColAufValue(table, colName);
        for (WebElement number : numbers) {
            sum = sum + Double.parseDouble(number.getText());
        }
        return sum;
    }


    //Получение Мар<String,String> по по названию колонок
    public Map<String, String> getMapTableProduct(WebElement table, String key, String value) {

        Map<String, String> mapProduct = new HashMap<>();

        int indexKey = getIndexCollTable(table, key);
        int indexValue = getIndexCollTable(table, value);

        List<WebElement> rowsTable = getListRows(table);

        for (int i = 1; i < rowsTable.size(); i++) {
            List<WebElement> cols = rowsTable.get(i).findElements(By.xpath(".//td"));
            mapProduct.put(cols.get(indexKey).getText(), cols.get(indexValue).getText());
        }

        return mapProduct;
    }

}
