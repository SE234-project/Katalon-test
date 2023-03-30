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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

WebUI.openBrowser('')
WebUI.navigateToUrl('http://54.87.132.198:8086/')

WebUI.click(findTestObject('Object Repository/page3/Page_/Link_Customer'))
WebUI.click(findTestObject('Object Repository/page3/Page_/Link_table1'))
WebUI.click(findTestObject('Object Repository/page3/Page_/Link_Menu'))

// Load the Test Data
def dishesTestData = TestDataFactory.findTestData('Data Files/DishTestData')

for (int i = 1; i <= dishesTestData.getRowNumbers(); i++) {
	// Get dish from the Test Data
	String dish = dishesTestData.getValue('dish', i)

	// Click the link that corresponds to the dish
	WebUI.click(findTestObject('page3/Page_/Link_' + dish))

	// Verify the title text
	if (WebUI.verifyElementText(findTestObject('Object Repository/page3/Page_/title_' + dish), dish, FailureHandling.OPTIONAL)) {
		println("Element with correct text found: ${dish}")
		break
	} else {
		println("Element with incorrect text found. Continuing to the next dish.")
	}
}


