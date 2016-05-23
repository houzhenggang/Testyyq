package txh.com.yyq.my;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class EditNickName extends UiAutomatorTestCase {
	UiDevice device;
	public EditNickName(UiDevice uidevice){
		device = uidevice;
	}

	public static void main(String[] args) {
		String jarName = "EditNickName";
		String testClass = "txh.com.yyq.my.EditNickName";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		editNickName();
	}

	/**
	 * 修改昵称 1、直接点击提交按钮 2、 set Nickname 3、提交 4、判断newNickname是否与setNickname一致
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void editNickName() throws UiObjectNotFoundException {
		device.click(500, 600);
		UiObject clickNickname = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_nickname"));
		clickNickname.click();
		UiObject setnickname = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/kit_et_change_nickname"));
		UiObject submit = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/kit_btn_change_nickname_commit"));
		submit.click();
		setnickname.setText(Utf7ImeHelper.e("买了这么多都不中奖33"));
		String setNickname = setnickname.getText();
		submit.click();
		UiObject userName = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_tv_nick_name"));
		String newNickname = userName.getText();
		if (newNickname.equals(setNickname)) {
			System.out.println("newNickname equals setnickname !!");
			System.out.println("nickName is :" + newNickname);
		}

	}

}
