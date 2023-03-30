import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.openBrowser('')
WebUI.navigateToUrl('http://54.87.132.198:8086/')

WebUI.click(findTestObject('Object Repository/page4/Page_/Link_Customer'))
WebUI.click(findTestObject('Object Repository/page4/Page_/Link_table'))

// Load the Test Data
def searchTextTestData = TestDataFactory.findTestData('Data Files/SearchTextTestData')

for (int i = 1; i <= searchTextTestData.getRowNumbers(); i++) {
    // Get search text and expected texts from the Test Data
    String searchText = searchTextTestData.getValue('searchText', i)
    String div1ExpectedText = searchTextTestData.getValue('div1ExpectedText', i)
    String div2ExpectedText = searchTextTestData.getValue('div2ExpectedText', i)
    String div3ExpectedText = searchTextTestData.getValue('div3ExpectedText', i)
	String div4ExpectedText = searchTextTestData.getValue('div4ExpectedText', i)

    WebUI.setText(findTestObject('Object Repository/page4/Page_/input_My Order_search'), searchText)

    // Verify the text content of the three divs if they appear
    if (!div1ExpectedText.isEmpty()) {
        WebUI.verifyElementText(findTestObject('Object Repository/page4/Page_/div_Sticky Baked Chicken Wings'), div1ExpectedText, FailureHandling.OPTIONAL)
    }
    if (!div2ExpectedText.isEmpty()) {
        WebUI.verifyElementText(findTestObject('Object Repository/page4/Page_/div_Caesar Salad Spears'), div2ExpectedText, FailureHandling.OPTIONAL)
    }
    if (!div3ExpectedText.isEmpty()) {
        WebUI.verifyElementText(findTestObject('Object Repository/page4/Page_/div_Pickled Shrimp with Creamy Spinach Dip'), div3ExpectedText, FailureHandling.OPTIONAL)
    }
	if (!div4ExpectedText.isEmpty()) {
        WebUI.verifyElementText(findTestObject('Object Repository/page4/Page_/div_Pigs in a Blanket with Black Pepper Pastry'), div4ExpectedText, FailureHandling.OPTIONAL)
    }

    // Refresh the page for the next iteration
    if (i < searchTextTestData.getRowNumbers()) {
        WebUI.click(findTestObject('Object Repository/page4/Page_/button_Refresh Page'))
    }
}

WebUI.closeBrowser()



