package mobile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.internal.PathUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class Common {
	/**
	 * Start Application
	 */
	@Keyword
	def static void startApp() {
		def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())
		Mobile.startApplication(appPath, false)
	}

	/**
	 * Start Application Existing
	 */
	@Keyword
	def static void startAppExist() {
		Mobile.startExistingApplication(null)
	}

	/**
	 * Check Toast
	 */
	@Keyword
	def static void verifyToastElement(String textName) {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		def toast = ""
		try {
			toast = driver.findElementByXPath("//android.widget.Toast[@text='"+textName+"']")
		} catch (Exception e) {
			e.printStackTrace()
		}
		println("Toast element: " + toast)
		if (toast == null) {
			KeywordUtil.markFailed('ERROR: Toast object not found!')
		} else {
			KeywordUtil.markPassed('PASSED: Toast object found! - '+textName)
		}
	}
	
	@Keyword
	def static void setGVariable(String name, String email, String password) {
		GlobalVariable.G_name=name
		GlobalVariable.G_email=email
		GlobalVariable.G_password=password
	}

	@Keyword
	def static void setGVariable() {
		GlobalVariable.G_name='qq'
		GlobalVariable.G_email='qq0@qq.com'
		GlobalVariable.G_password='qqqq'
	}
}
