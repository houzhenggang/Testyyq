package txh.com.yyq.my;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;
import txh.com.yyq.sign.SignInMappn;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class ChangePassword extends UiAutomatorTestCase{

	public static void main(String[] args) {
		String jarName = "ChangePassword";
		String testClass = "txh.com.yyq.my.ChangePassword";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testCase() throws UiObjectNotFoundException {
		editPassword();

	}
	/**
	 * 4、修改密码:
	 * 
	 * 修改密码成功后，再次登录
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void editPassword() throws UiObjectNotFoundException {
		UiObject clickEditPassword = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_password"));
		clickEditPassword.click();
		UiObject oldPasswrod = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/uc_changepsw_et_old_psw"));
		oldPasswrod.setText(Utf7ImeHelper.e("123456"));
		UiObject newPassword = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/uc_changepsw_et_new_psw"));
		newPassword.setText(Utf7ImeHelper.e("654321"));
		UiObject confirmPassword = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/uc_changepsw_et_confirm_psw"));
		confirmPassword.setText(Utf7ImeHelper.e("654321"));
		UiObject makeSureChange = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/uc_changepsw_btn_make_sure"));
		makeSureChange.click();
		System.out.println("change password success!!");
		
		SignInMappn sign = new SignInMappn();
		sign.signIn("imopan507", "654321" );

	}


}
