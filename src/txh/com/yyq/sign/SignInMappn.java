package txh.com.yyq.sign;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SignInMappn extends UiAutomatorTestCase {
	UiDevice device;

	public SignInMappn(UiDevice uidevice) {
		device = uidevice;
	}

	public void signIn() throws UiObjectNotFoundException {
		UiObject username = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/et_user_name"));
		UiObject password = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/et_user_psd"));
		UiObject signIn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/tv_sign_in"));
		username.click();
		username.setText("imopan");
		password.click();
		password.setText("654321");
		signIn.clickAndWaitForNewWindow();
//		device.takeScreenshot(new File("sdcard/Download/clickSignIn.png"));
		System.out.println("sign in sucessful!!");
	}

}
