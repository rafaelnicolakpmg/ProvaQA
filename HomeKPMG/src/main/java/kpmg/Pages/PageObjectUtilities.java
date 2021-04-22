package kpmg.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PageObjectUtilities {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static int iWaitIncrement = 1000;
    private static int iWaitRetries = 30;

    public PageObjectUtilities(WebDriver driver, int iTimeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, iTimeout);
        int iTimeoutInMilliseconds = 1000 * iTimeout;
        this.iWaitRetries = iTimeoutInMilliseconds / this.iWaitIncrement;
        this.driver.manage().timeouts().pageLoadTimeout(iTimeout, TimeUnit.SECONDS);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement findElementById(String id, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.id(id));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public WebElement findElementByName(String name, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.name(name));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public WebElement findElementByClassName(String className, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.className(className));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public WebElement findElementByTagName(String tagName, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.tagName(tagName));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public WebElement findElementByLinkText(String linkText, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.linkText(linkText));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public WebElement findElementByPartialLinkText(String partialLinkText, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.partialLinkText(partialLinkText));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public WebElement findElementByCssSelector(String cssSelector, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.cssSelector(cssSelector));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public WebElement findElementByXpath(String xpath, boolean... bPrintStackTrace) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xpath));
            return element;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return element;
        }
    }

    public ArrayList<WebElement> findElementsById(String id, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.id(id));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    public ArrayList<WebElement> findElementsByName(String name, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.name(name));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    public ArrayList<WebElement> findElementsByClassName(String className, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.className(className));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    public ArrayList<WebElement> findElementsByTagName(String tagName, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.tagName(tagName));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    public ArrayList<WebElement> findElementsByLinkText(String linkText, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.linkText(linkText));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    public ArrayList<WebElement> findElementsByPartialLinkText(String partialLinkText, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.partialLinkText(partialLinkText));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    public ArrayList<WebElement> findElementsByCssSelector(String cssSelector, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.cssSelector(cssSelector));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    public ArrayList<WebElement> findElementsByXpath(String xpath, boolean... bPrintStackTrace) {
        ArrayList<WebElement> elements = new ArrayList<>();
        try {
            elements = (ArrayList<WebElement>) driver.findElements(By.xpath(xpath));
            return elements;
        } catch (Exception e) {
            if (bPrintStackTrace.length > 0) {
                if (bPrintStackTrace[0]) {
                    e.printStackTrace();
                }
            }
            return elements;
        }
    }

    @SuppressWarnings("unchecked")
    public WebElement findElementByjQuery(String jQuery, int... milliseconds) {
        int sleep = 200; // number of milliseconds to wait before retrying
        int numberOfRetries = 10; // default number of retries
        if (milliseconds.length > 0) {
            numberOfRetries = milliseconds[0] / sleep;
            if (numberOfRetries <= 0) {
                numberOfRetries = 1;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ArrayList<WebElement> elements = new ArrayList<>();
        WebElement element = null;
        try {
            for (int i = 0; i < numberOfRetries; i++) {
                elements = (ArrayList<WebElement>) js.executeScript("return $(\"" + jQuery + "\").get()");
                if (elements.size() > 0) {
                    element = elements.get(0);
                    return element;
                } else {
                    Thread.sleep(sleep);
                }
            }
            return element;
        } catch (Exception e) {
            e.printStackTrace();
            return element;
        }
    }

    public void closeWindow(int tabIndex) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public boolean isCheckboxChecked(WebElement element) {
        try {
            if (element.getAttribute("aria-checked").equals("true")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String textInputGetValue(WebElement element) {
        try {
            return element.getAttribute("value");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean scrollToElement(WebElement element, boolean... bUseAction) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            if (bUseAction.length > 0) {
                if (bUseAction[0]) {
                    Actions act = new Actions(driver);
                    act.moveToElement(element).build().perform();
                } else {
                    js.executeScript("arguments[0].scrollIntoView();", element);
                }
            } else {
                js.executeScript("arguments[0].scrollIntoView();", element);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean scrollToTopOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean scrollToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean scrollByPixel(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("scroll(" + Integer.toString(x) + "," + Integer.toString(y) + ")");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isElementPresentDisplayed(WebDriver driver, By by, int timeOutInSeconds) {
        try {
            setImplicitWait(driver, timeOutInSeconds);
            boolean isElementPresent = !driver.findElements(by).isEmpty();
            boolean isElementDisplayed = driver.findElement(by).isDisplayed();
            return isElementPresent && isElementDisplayed;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setImplicitWait(WebDriver driver, int waitTime_InSeconds) {
        driver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);
    }
}
