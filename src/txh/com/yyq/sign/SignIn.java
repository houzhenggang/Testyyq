package txh.com.yyq.sign;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SignIn extends UiAutomatorTestCase {
	String userName;
	String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		UiObject username = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/et_user_name"));

		try {
			username.click();
			username.setText(Utf7ImeHelper.e("imopan507"));
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		UiObject password = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/et_user_psd"));
		try {
			password.click();
			password.setText(Utf7ImeHelper.e("123456"));
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.passWord = passWord;
	}

}
