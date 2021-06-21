package utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.ParseException;
import reader.PropertiesReader;
import stepDefinitions.BaseClass;

public class Utils extends BaseClass {

	public WebDriver driver;

	public Utils(WebDriver driver) {
		this.driver = driver;
		propertiesReader = new PropertiesReader();
		wait = new WebDriverWait(this.driver, propertiesReader.getExplicitWait());
		waitForDisplay = new WebDriverWait(this.driver, 4);
	}

	/*
	 * WebDriver will wait explicitly for an element to be present at the given
	 * amount of time in seconds.
	 */
	public void waitForTheElementToBeVisible(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			driver.switchTo().activeElement();
		} catch (Exception e) {
			System.out.println("Error at explicit wait: " + e);
		}
	}

	/*
	 * WebDriver will wait explicitly for an element to be clickable at the given
	 * amount of time in seconds.
	 */
	public void waitForTheElementToBeClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			String outerHTML = element.getAttribute("outerHTML");
			if (outerHTML.contains("href")) {
				Thread.sleep(2000);
			}
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			driver.switchTo().activeElement();
		} catch (Exception e) {
			System.out.println("Error at explicit wait: " + e);
		}
	}

	/* This method returns true if the element is not clickable. */
	public boolean isElementClickable(WebElement element) {
		try {
			waitForDisplay.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	/*
	 * WebDriver will wait explicitly for an element to be absent at the given
	 * amount of time in seconds.
	 */
	public void waitForTheElementTobeAbsent(WebElement element) {
		try {
			wait = new WebDriverWait(this.driver, 3);
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
		}
	}

	/*
	 * This method is to enter the text into text fields. And it can be reused
	 * everywhere to optimize the code.
	 */
	public void enterTheText(WebElement element, String text) {
		try {
			waitForTheElementToBeVisible(element);
			element.clear();
			element.sendKeys(text);
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			waitForTheElementToBeClickable(element);
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("Error at sending text: " + e);
		}
	}

	/*
	 * This method is to click an element. And it can be reused everywhere to
	 * optimize the code.
	 */
	public void clickAnElement(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

		try {
			waitForTheElementToBeClickable(element);
			javascriptExecutor.executeScript("arguments[0].click();", element);
			if (element.isEnabled()) {
				element.click();
			}
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			try {
				if (element.isDisplayed()) {
					waitForTheElementToBeClickable(element);
					element.click();
				}
			} catch (org.openqa.selenium.NoSuchElementException e2) {
				driver.switchTo().activeElement();
			} catch (org.openqa.selenium.ElementClickInterceptedException e3) {
				waitForTheElementToBeClickable(element);
				javascriptExecutor.executeScript("arguments[0].click();", element);
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			driver.switchTo().activeElement();
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			/*
			 * Sometimes without any exception click action is completing but really it's
			 * not clicking the element. So in try block, we put a condition to click an
			 * element if it's still displayed because of that condition, when modal dialog
			 * window is opened the element is still displayed in on the DOM but not
			 * clickable so we are switching the focus to active element
			 */
			driver.switchTo().activeElement();
		} catch (org.openqa.selenium.ElementNotInteractableException e) {
			/*
			 * Sometimes without any exception click action is completing but really it's
			 * not clicking the element. So in try block, we put a condition to click an
			 * element if it's still displayed because of that condition, when modal dialog
			 * window is opened the element is still displayed in on the DOM but not
			 * clickable so we are switching the focus to active element
			 */
			driver.switchTo().activeElement();
		} catch (Exception e) {
			System.out.println("Error at clicking an element: " + e);
		}
	}

	/* This method captures and returns the text of a web element. */
	public String getText(WebElement element) {
		try {
			waitForTheElementToBeVisible(element);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			String message = element.getText();
			return message;
		} catch (Exception e) {
			System.out.println("Error at capturing text: " + e);
		}
		return null;
	}

	/* This method compares two texts and returns a boolean value */
	public boolean compareTexts(String expectedMessage, String actualMessage) {
		try {
			Assert.assertEquals(expectedMessage.toLowerCase(), actualMessage.toLowerCase());
			return true;
		} catch (java.lang.NullPointerException e) {
			Assert.fail("Expected value is: " + expectedMessage + " The actual value is: " + actualMessage);
		} catch (Exception e) {
			System.out.println("Assertion failed: " + e);
		}
		return false;
	}

	/* This method compares text1 contains text2 or not */
	public boolean containsTexts(String firstText, String secondText) {
		try {
			String modifiedFirstText = firstText.toLowerCase().replace(".", "").replace(",", "");
			String modifiedSecondText = secondText.toLowerCase().replace(".", "").replace(",", "");

			if (modifiedFirstText.contains(modifiedSecondText)) {
				// Returns true else assertion will fail
			} else if (modifiedSecondText.contains(modifiedFirstText)) {
				// Returns true else assertion will fail
			} else {
				Assert.fail("Both text doesn't contain any of them. Text1: " + modifiedFirstText + " Text2: "
						+ modifiedSecondText);
			}
			return true;
		} catch (Exception e) {
			System.out.println("Assertion failed: " + e);
		}
		return false;
	}

	/* This method is to select a value from drop-down */
	public void selectDropDownValueByText(WebElement element, String text) {
		try {
			waitForTheElementToBeVisible(element);
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println("Exception at selecting value from drop-down: " + e);
		}
	}

	/* This method is to select a value from drop-down */
	public void selectDropDownValueByIndex(WebElement element, int index) {
		try {
			waitForTheElementToBeVisible(element);
			Select select = new Select(element);
			select.selectByIndex(index);
		} catch (Exception e) {
			System.out.println("Exception at selecting value from drop-down: " + e);
		}
	}

	/* This method returns EST today's date in MM/dd/yyyy format. */
	public String estTodaysDate() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			TimeZone zone = TimeZone.getTimeZone("America/New_York");
			sdf.setTimeZone(zone);
			return sdf.format(new Date());
		} catch (Exception e) {
			System.out.println("Exception occured at capturing today's date: " + e);
		}
		return null;
	}

	/* This method returns EST today's date in M/dd/yy format. */
	public String estTodaysDateForEmailHistoryPage() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy");
			TimeZone zone = TimeZone.getTimeZone("America/New_York");
			sdf.setTimeZone(zone);
			return sdf.format(new Date());
		} catch (Exception e) {
			System.out.println("Exception occured at capturing today's date: " + e);
		}
		return null;
	}

	/* This method returns PST today's date in MM/dd/yyyy format. */
	public String pstTodaysDate() {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			sdf.setTimeZone(TimeZone.getTimeZone("PST"));
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("Exception occured at capturing today's date: " + e);
		}
		return null;
	}

	/* This method is to verify the page or screen title */
	public boolean verifyThePageTitle(String pageTitle, WebElement element) {
		try {
			waitForTheElementToBeVisible(element);
			Assert.assertEquals(pageTitle.toLowerCase(), getText(element).toLowerCase());
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured at validating page title" + e);
		}
		return false;
	}

	/* This method is to validate list is having single value or multiple values. */
	public boolean isListHavingMultipleValues(List<WebElement> ascendingOrderList) {
		try {
			String firstValueOfList = ascendingOrderList.get(0).getText();
			for (WebElement webElement : ascendingOrderList) {
				if (!webElement.getText().equalsIgnoreCase(firstValueOfList)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured at verifing list for multiple values: " + e);
		}
		return false;
	}

	/* This method is to validate the ascending sorting order. */
	public boolean validateAscendingSortingOrder(List<WebElement> ascendingOrderList) {
		boolean isSorted = false;
		try {
			List<String> ascendingOrderedList = createStringList(ascendingOrderList);
			List<String> collectionSortedList = ascendingOrderedList;
			Collections.sort(collectionSortedList);
			isSorted = collectionSortedList.equals(ascendingOrderedList);

			/*
			 * System.out.println("Collection ascending sorted listed: " +
			 * collectionSortedList); System.out.println("CPSUI ascending sorted listed: " +
			 * ascendingOrderedList);
			 */
			return isSorted;
		} catch (Exception e) {
			System.out.println("Exception occured at validating ascending order: " + e);
		}
		return isSorted;
	}

	/* This method is to validate the descending sorting order. */
	public boolean validateDescendingSortingOrder(List<WebElement> descendingOrderList) {
		boolean isSorted = false;
		try {
			List<String> descendingOrderedList = createStringList(descendingOrderList);
			List<String> collectionSortedList = descendingOrderedList;
			Collections.sort(collectionSortedList, Collections.reverseOrder());
			isSorted = collectionSortedList.equals(descendingOrderedList);

			/*
			 * System.out.println("Collection descending sorted listed: " +
			 * collectionSortedList); System.out.println("CPSUI descending sorted listed: "
			 * + descendingOrderedList);
			 */
			return isSorted;
		} catch (Exception e) {
			System.out.println("Exception occured at validating descending order: " + e);
		}
		return isSorted;
	}

	/* This method is to create a string list from webelement list */
	public List<String> createStringList(List<WebElement> webElementList) {
		try {
			List<String> stringList = new ArrayList<String>();
			for (WebElement element : webElementList) {
				stringList.add(element.getText());
			}
			return stringList;
		} catch (Exception e) {
			System.out.println("Exception occured at creating string list: " + e);
		}
		return null;
	}

	/* This method is to wait till attribute value changes. */
	public boolean waitTillAttributeValueChanges(final WebElement element, final String oldAttributeValue,
			final String attribute) {
		try {
//			System.out.println("Old attribute value is "+ oldAtributeValue);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					String newAttributeValue = element.getAttribute(attribute);
//					System.out.println("New attribute value is "+ newAttributeValue);
					if (!newAttributeValue.equals(oldAttributeValue))
						return true;
					else
						return false;
				}
			});
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
//			System.out.println("Old attribute value in catch block "+ oldAtributeValue);
			wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					String newAttributeValue = element.getAttribute(attribute);
//					System.out.println("New attribute value in catch block "+ newAttributeValue);
					if (!newAttributeValue.equals(oldAttributeValue))
						return true;
					else
						return false;
				}
			});
		} catch (Exception e) {
			System.out.println("Exception occured at attribute change value: " + e);
		}
		return false;
	}

	/*
	 * This method is to check the dates for below conditions. 1. From date > end
	 * date 2. End date > from date 3. Is from date future date? 4. Is end date
	 * future date?
	 */
	public String compareDates(String from, String end, String todaysdate) {
		try {
			Date fromDate = new SimpleDateFormat("MM/dd/yyyy").parse(from);
			Date endDate = new SimpleDateFormat("MM/dd/yyyy").parse(end);
			Date todaysDate = new SimpleDateFormat("MM/dd/yyyy").parse(todaysdate);

			if (fromDate.compareTo(todaysDate) > 0) {
				return "from date is future date";
			} else if (endDate.compareTo(todaysDate) > 0) {
				return "end date is future date";
			} else if (fromDate.compareTo(endDate) > 0) {
				return "from date > end date";
			} else if (fromDate.compareTo(endDate) < 0) {
				long duration = endDate.getTime() - fromDate.getTime();
				long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
				if (diffInDays > 365) {
					return "more than 1 year";
				} else if (diffInDays > 90) {
					return "more than 3 months";
				}
				return "end date > from date";
			} else if (fromDate.compareTo(endDate) == 0) {
				return "dates are equal";
			}
		} catch (ParseException e) {
			System.out.println("Error occured at parsing the date: " + e);
		} catch (Exception e) {
			System.out.println("Error occured at comparing the dates: " + e);
		}
		return null;
	}

	/* This method is to wait till sorting finished. */
	public void waitTillSortingFinished(WebElement element) {
		waitTillAttributeValueChanges(element, element.getAttribute("id"), "id");
	}

	/* This method to generate random name */
	public String generateRandomName() {
		try {
			String alphaNumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			Random random = new Random();
			StringBuilder randomString = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int randIndex = random.nextInt(alphaNumerics.length());
				randomString.append(alphaNumerics.charAt(randIndex));
			}
			return randomString.toString();
		} catch (Exception e) {
			System.out.println("Error ocured at generating random name: " + e);
		}
		return null;
	}

	/* This method to generate random email */
	public String generateRandomEmail() {
		try {
			String alphaNumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			Random random = new Random();
			StringBuilder randomString = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int randIndex = random.nextInt(alphaNumerics.length());
				randomString.append(alphaNumerics.charAt(randIndex));
			}
			return randomString.toString() + "@yahoo.com";
		} catch (Exception e) {
			System.out.println("Error ocured at generating random email: " + e);
		}
		return null;
	}

	/*
	 * This method is to create and return webelement to click on member last name
	 */
	public void createWebElementForMemberLastName(String seqNumber, String firstName, String lastName, String dob) {

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div//span[text()='" + seqNumber + "']//following::td//span[text()='"
					+ firstName + "']//following::td//span[text()='" + dob + "']//ancestor::td//a[text()='" + lastName
					+ "']")).click();
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			try {
				if (driver.findElement(By.xpath("//div//span[text()='" + seqNumber + "']//following::td//span[text()='"
						+ firstName + "']//following::td//span[text()='" + dob + "']//ancestor::td//a[text()='"
						+ lastName + "']")).isDisplayed()) {

					driver.findElement(By.xpath("//div//span[text()='" + seqNumber + "']//following::td//span[text()='"
							+ firstName + "']//following::td//span[text()='" + dob + "']//ancestor::td//a[text()='"
							+ lastName + "']")).click();
				}
			} catch (org.openqa.selenium.NoSuchElementException e2) {
				System.out.println(
						"Either member details were provided wrongly in data sheet. Or search results are not displayed for the given parameters.");
			}
		} catch (InterruptedException e) {
			System.out.println("Error occurred at clicking on member last name in member search: " + e);
		}

	}

	/* This method is to get text from two elements and concatenate */
	public String concatenateText(WebElement element1, WebElement element2) {
		try {
			return getText(element1).trim() + " " + getText(element2).trim();
		} catch (Exception e) {
			System.out.println("Error occurred at concatenating strings: " + e);
		}
		return null;
	}

	/* This method is get the attribute value */
	public String getAttributeValue(WebElement element, String attributeName) {
		try {
			String attributeValue = element.getAttribute(attributeName);
			return attributeValue;
		} catch (Exception e) {
			System.out.println("Error occurred at getting attribute value: " + e);
		}
		return null;
	}

	/* This method is scroll down the page */
	public void scrollDown(int height) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0," + height + ")");
		} catch (Exception e) {
			System.out.println("Error occurred at scrolling down page: " + e);
		}
	}

	/* This method is scroll up the page */
	public void scrollUp(int height) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0," + -height + ")");
		} catch (Exception e) {
			System.out.println("Error occurred at scrolling up page: " + e);
		}
	}

	/* This method returns true if element displays else return false */
	public boolean isElementDisplaying(WebElement element) {
		try {
			waitForDisplay.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				return true;
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		} catch (Exception e) {
			System.out.println("Error occurred at element check: " + e);
		}
		return false;
	}

	/*
	 * This method to whether element is displaying or not. If not it will fail the
	 * script.
	 */
	public void isElementDisplayingOrNot(WebElement element) {
		try {
			waitForDisplay.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				// If element displays then do nothing
			} else {
				Assert.fail("Element is notdisplaying so failed the script");
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Error occurred at element check: " + e);
		} catch (Exception e) {
			System.out.println("Error occurred at element check: " + e);
		}
	}

}