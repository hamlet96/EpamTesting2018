package com.spbstu.hw5.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.spbstu.hw5.entities.Data;

@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalsAndColorsPageJDI extends WebPage {
    @FindBy(css = ".radio")
    @Getter
    private RadioButtons allRadioButtons;

    @JFindBy(css = "#elements-checklist | .checkbox label")
    @Getter
    private CheckList elementsCheckList;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    @Getter
    private Dropdown colorsDropdown;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"))
    @Getter
    private ComboBox metalsComboBox;

    @JComboBox(root = @FindBy(css = ".salad"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button"))
    @Getter
    private ComboBox saladDropList;

    @FindBy(css = ".panel-body-list.results li")
    @Getter
    private TextList result;

    @FindBy(css = "#submit-button")
    @Getter
    private Button submit;

    private final int metalIndex = 3;
    private final int vegetablesIndex = 4;

    public void fillMetalsAndColorsForm(Data data) {
        allRadioButtons.select(Integer.toString(data.getSummary()[0]));
        allRadioButtons.select(Integer.toString(data.getSummary()[1]));

        for (String s : data.getElements()) {
            elementsCheckList.select(s);
        }
        colorsDropdown.select(data.getColor());
        metalsComboBox.select(data.getMetals());

        //clear checkboxes
        for (String s : saladDropList.getValue().split(", ")) {
            saladDropList.select(s);
        }
        //clear checkboxes
        for (String s : data.getVegetables()) {
            saladDropList.select(s);
        }

        submit.click();

        //clear checkboxes
        for (String s : data.getElements()) {
            elementsCheckList.select(s);
        }
    }

    public void checkMetalsAndColorsForm(Data data) {
        Assert.assertEquals(data.getSummary()[0] + data.getSummary()[1],
                Integer.parseInt(result.getText(0).split(" ")[1]));

        for (String s : data.getElements()) {
            Assert.assertTrue(result.getText(1).contains(s),
                    String.format("Elements don't contain %s", s));
        }

        Assert.assertTrue(result.getText(2).contains(data.getColor()),
                String.format("Color doesn't contain %s", data.getColor()));

        Assert.assertTrue(result.getText(metalIndex).contains(data.getMetals()),
                String.format("Metal don't contain %s", data.getMetals()));

        for (String s : data.getVegetables()) {
            Assert.assertTrue(result.getText(vegetablesIndex).contains(s),
                    String.format("Vegetables don't contain %s", s));
        }
    }
}
