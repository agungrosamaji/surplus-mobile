package mobile

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class login {
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

	@Keyword
	def static void setEmail(String email) {
		Mobile.tap(findTestObject('Object Repository/Android/Login/EditText - Email'), 0)
		Mobile.setText(findTestObject('Object Repository/Android/Login/EditText - Email'), email, 0)
		Mobile.hideKeyboard()
	}

	@Keyword
	def static void setPassword(String password) {
		Mobile.tap(findTestObject('Object Repository/Android/Login/EditText - Password'), 0)
		Mobile.setText(findTestObject('Object Repository/Android/Login/EditText - Password'), password, 0)
		Mobile.hideKeyboard()
	}


	@Keyword
	def static void tapLoginButton() {
		Mobile.tap(findTestObject('Object Repository/Android/Login/Button - LOGIN'), 0)
	}

		@Keyword
	def static void verifyLoginSuccess() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Dashboad/TextView - Android NewLine Learning'), 1, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Dashboad/TextView - Hello,'), 1, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyElementText(findTestObject('Object Repository/Android/Dashboad/TextView - Email'), GlobalVariable.G_email, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyElementText(findTestObject('Object Repository/Android/Dashboad/TextView - Account Name'), GlobalVariable.G_name, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyElementText(findTestObject('Object Repository/Android/Dashboad/TextView - Account Email'), GlobalVariable.G_email, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyElementText(findTestObject('Object Repository/Android/Dashboad/TextView - Account Password'), GlobalVariable.G_password, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def static void verifyFieldEmail() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Login/TextView - Enter Valid Email'), 1)
	}

	@Keyword
	def static void verifyFieldPassword() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Login/TextView - Enter Valid Password'), 1)
	}
}
