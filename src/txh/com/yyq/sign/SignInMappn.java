package txh.com.yyq.sign;

import java.io.File;
import java.io.IOException;

import txh.com.test.FileUtil;
import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 机锋账号登录：
 * 
 * @author xiaohua
 * 
 */
public class SignInMappn extends UiAutomatorTestCase {
	
	// UiDevice device;
	//
	// public SignInMappn(UiDevice uidevice) {
	// device = uidevice;
	// }

	public void signIn(String name , String passwd) throws UiObjectNotFoundException {
		UiObject username = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/et_user_name"));
		UiObject password = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/et_user_psd"));
		UiObject signIn = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/tv_sign_in"));
		username.click();
		username.setText(Utf7ImeHelper.e(name));
		password.click();
		password.setText(Utf7ImeHelper.e(passwd));
		signIn.clickAndWaitForNewWindow();
		// device.takeScreenshot(new File("sdcard/Download/clickSignIn.png"));
		System.out.println("imopan507 sign in sucessful!!");
		sleep(2000);
	}
	
	public void signIn() throws UiObjectNotFoundException {
		String data = null;
		try {
			data = FileUtil.readTextFile(new File("pass.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] up = data.split(":");
		System.out.println("name:"+up[0]);
		System.out.println("pass:"+up[1]);
		signIn(up[0], up[1]);
	}

}
