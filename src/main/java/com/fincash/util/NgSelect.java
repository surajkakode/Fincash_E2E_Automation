package com.fincash.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class NgSelect implements ISelect {
    private final WebElement element;
    private final boolean isMulti;

    public NgSelect(WebElement element) {
        String tagName = element.getTagName();
        if (null != tagName && "mat-select".equals(tagName.toLowerCase())) {
            this.element = element;
            this.element.click();
            String value = element.getAttribute("multiple");
            this.isMulti = value != null && !"false".equals(value);
        } else {
            throw new UnexpectedTagNameException("mat-select", tagName);
        }
    }

    public boolean isMultiple() {
        return this.isMulti;
    }

    public List<WebElement> getOptions() {
        return this.element.findElements(By.tagName("mat-option"));
    }

    public List<WebElement> getAllSelectedOptions() {
        List<WebElement> toReturn = new ArrayList();
        Iterator var2 = this.getOptions().iterator();

        while(var2.hasNext()) {
            WebElement option = (WebElement)var2.next();
            if (option.isSelected()) {
                toReturn.add(option);
            }
        }

        return toReturn;
    }

    public WebElement getFirstSelectedOption() {
        Iterator var1 = this.getOptions().iterator();

        WebElement option;
        do {
            if (!var1.hasNext()) {
                throw new NoSuchElementException("No options are selected");
            }

            option = (WebElement)var1.next();
        } while(!option.isSelected());

        return option;
    }

    public void selectByVisibleText(String text) {
        List<WebElement> options = this.element.findElements(By.xpath(".//mat-option[normalize-space(.) = " + Quotes.escape(text) + "]"));
        boolean matched = false;

        for(Iterator var4 = options.iterator(); var4.hasNext(); matched = true) {
            WebElement option = (WebElement)var4.next();
            this.setSelected(option, true);
            if (!this.isMultiple()) {
                return;
            }
        }

        if (options.isEmpty() && text.contains(" ")) {
            String subStringWithoutSpace = this.getLongestSubstringWithoutSpace(text);
            List candidates;
            if ("".equals(subStringWithoutSpace)) {
                candidates = this.element.findElements(By.tagName("mat-option"));
            } else {
                candidates = this.element.findElements(By.xpath(".//mat-option[contains(., " + Quotes.escape(subStringWithoutSpace) + ")]"));
            }

            Iterator var6 = candidates.iterator();

            while(var6.hasNext()) {
                WebElement option = (WebElement)var6.next();
                if (text.equals(option.getText())) {
                    this.setSelected(option, true);
                    if (!this.isMultiple()) {
                        return;
                    }

                    matched = true;
                }
            }
        }

        if (!matched) {
            throw new NoSuchElementException("Cannot locate element with text: " + text);
        }
    }

    private String getLongestSubstringWithoutSpace(String s) {
        String result = "";
        StringTokenizer st = new StringTokenizer(s, " ");

        while(st.hasMoreTokens()) {
            String t = st.nextToken();
            if (t.length() > result.length()) {
                result = t;
            }
        }

        return result;
    }

    public void selectByIndex(int index) {
        String match = String.valueOf(index);
        Iterator var3 = this.getOptions().iterator();

        WebElement option;
        do {
            if (!var3.hasNext()) {
                throw new NoSuchElementException("Cannot locate option with index: " + index);
            }

            option = (WebElement)var3.next();
        } while(!match.equals(option.getAttribute("index")));

        this.setSelected(option, true);
    }

    public void selectByValue(String value) {
        List<WebElement> options = this.element.findElements(By.xpath(".//mat-option[@value = " + Quotes.escape(value) + "]"));
        boolean matched = false;

        for(Iterator var4 = options.iterator(); var4.hasNext(); matched = true) {
            WebElement option = (WebElement)var4.next();
            this.setSelected(option, true);
            if (!this.isMultiple()) {
                return;
            }
        }

        if (!matched) {
            throw new NoSuchElementException("Cannot locate option with value: " + value);
        }
    }

    public void deselectAll() {
        if (!this.isMultiple()) {
            throw new UnsupportedOperationException("You may only deselect all options of a multi-select");
        } else {
            Iterator var1 = this.getOptions().iterator();

            while(var1.hasNext()) {
                WebElement option = (WebElement)var1.next();
                this.setSelected(option, false);
            }

        }
    }

    public void deselectByValue(String value) {
        if (!this.isMultiple()) {
            throw new UnsupportedOperationException("You may only deselect options of a multi-select");
        } else {
            List<WebElement> options = this.element.findElements(By.xpath(".//mat-option[@value = " + Quotes.escape(value) + "]"));
            boolean matched = false;

            for(Iterator var4 = options.iterator(); var4.hasNext(); matched = true) {
                WebElement option = (WebElement)var4.next();
                this.setSelected(option, false);
            }

            if (!matched) {
                throw new NoSuchElementException("Cannot locate option with value: " + value);
            }
        }
    }

    public void deselectByIndex(int index) {
        if (!this.isMultiple()) {
            throw new UnsupportedOperationException("You may only deselect options of a multi-select");
        } else {
            String match = String.valueOf(index);
            Iterator var3 = this.getOptions().iterator();

            WebElement option;
            do {
                if (!var3.hasNext()) {
                    throw new NoSuchElementException("Cannot locate option with index: " + index);
                }

                option = (WebElement)var3.next();
            } while(!match.equals(option.getAttribute("index")));

            this.setSelected(option, false);
        }
    }

    public void deselectByVisibleText(String text) {
        if (!this.isMultiple()) {
            throw new UnsupportedOperationException("You may only deselect options of a multi-select");
        } else {
            List<WebElement> options = this.element.findElements(By.xpath(".//mat-option[normalize-space(.) = " + Quotes.escape(text) + "]"));
            boolean matched = false;

            for(Iterator var4 = options.iterator(); var4.hasNext(); matched = true) {
                WebElement option = (WebElement)var4.next();
                this.setSelected(option, false);
            }

            if (!matched) {
                throw new NoSuchElementException("Cannot locate element with text: " + text);
            }
        }
    }

    private void setSelected(WebElement option, boolean select) {
        boolean isSelected = option.isSelected();
        if (!isSelected && select || isSelected && !select) {
            option.click();
        }

    }
}
