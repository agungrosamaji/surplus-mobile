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
import mobile.register as Reg
import mobile.Common as Com

Com.startApp()
Mobile.comment("Step : Tap link to page register")
Mobile.tap(findTestObject('Object Repository/Android/Login/TextView - Register'), 0)


Mobile.comment("Case : Field Name empty")
Reg.setName('')
Reg.tapButtonRegister()
Reg.verifyFieldName()


Mobile.comment("Case : Field Email empty")
Reg.setName(GlobalVariable.G_name)
Reg.setEmail('')
Reg.tapButtonRegister()
Reg.verifyFieldEmail()

Mobile.comment("Case : Field Password empty")
Reg.setName(GlobalVariable.G_name)
Reg.setEmail(GlobalVariable.G_email)
Reg.setPassword('')
Reg.tapButtonRegister()
Reg.verifyFieldPassword()

Mobile.comment("Case : Field Confirm Password empty")
Reg.setName(GlobalVariable.G_name)
Reg.setEmail(GlobalVariable.G_email)
Reg.setPassword(GlobalVariable.G_password)
Reg.setConfirmPassword('')
Reg.tapButtonRegister()
Reg.verifyFieldConfirmPassword()

Mobile.comment("Case : Email Already Exists")
Reg.setName(GlobalVariable.G_name)
Reg.setEmail(GlobalVariable.G_email)
Reg.setPassword(GlobalVariable.G_password)
Reg.setConfirmPassword(GlobalVariable.G_password)
Reg.tapButtonRegister()
Reg.checkToastEmailExist()