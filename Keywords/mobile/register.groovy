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

public class register {

	@Keyword
	def static void setName(String name) {
		Mobile.tap(findTestObject('Object Repository/Android/Register/EditText - Name'), 0)
		Mobile.setText(findTestObject('Object Repository/Android/Register/EditText - Name'), name, 0)
		Mobile.hideKeyboard()
	}

	@Keyword
	def static void setEmail(String email) {
		Mobile.tap(findTestObject('Object Repository/Android/Register/EditText - Email'), 0)
		Mobile.setText(findTestObject('Object Repository/Android/Register/EditText - Email'), email, 0)
		Mobile.hideKeyboard()
	}

	@Keyword
	def static void setPassword(String password) {
		Mobile.tap(findTestObject('Object Repository/Android/Register/EditText - Password'), 0)
		Mobile.setText(findTestObject('Object Repository/Android/Register/EditText - Password'), password, 0)
		Mobile.hideKeyboard()
	}

	@Keyword
	def static void setConfirmPassword(String confirm) {
		Mobile.tap(findTestObject('Object Repository/Android/Register/EditText - Confirm Password'), 0)
		Mobile.setText(findTestObject('Object Repository/Android/Register/EditText - Confirm Password'), confirm, 0)
		Mobile.hideKeyboard()
	}

	@Keyword
	def static void tapButtonRegister() {
		Mobile.tap(findTestObject('Object Repository/Android/Register/Button - REGISTER'), 0)
	}

	@Keyword
	def static void checkToastEmailExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Email Already Exists'), 1)
	}

	@Keyword
	def static void checkToastRegisterSuccess() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Registration Successful'), 1)
	}

	@Keyword
	def static void checkToastStatus() {
		def i = 0
		boolean toast = Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Email Already Exists'), 1, FailureHandling.OPTIONAL)
		while (toast) {
			i += 1
			GlobalVariable.G_email='qq'+i+'@qq.com'
			Mobile.tap(findTestObject('Object Repository/Android/Register/EditText - Email'), 0)
			Mobile.setText(findTestObject('Object Repository/Android/Register/EditText - Email'), 'qq'+i+'@qq.com', 0)
			Mobile.hideKeyboard()
			Mobile.tap(findTestObject('Object Repository/Android/Register/Button - REGISTER'), 0)
			toast = Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Email Already Exists'), 1, FailureHandling.OPTIONAL)
		}
	}

	@Keyword
	def static void verifyFieldName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Enter Full Name'), 1)
	}

	@Keyword
	def static void verifyFieldEmail() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Enter Valid Email'), 1)
	}

	@Keyword
	def static void verifyFieldPassword() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Enter Password'), 1)
	}

	@Keyword
	def static void verifyFieldConfirmPassword() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Register/TextView - Password Does Not Matches'), 1)
	}
}
