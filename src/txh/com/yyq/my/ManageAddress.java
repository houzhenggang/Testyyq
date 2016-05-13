package txh.com.yyq.my;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ManageAddress extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "ManageAddress";
		String testClass = "txh.com.yyq.my.ManageAddress";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testCase() throws UiObjectNotFoundException {
		getAddress();
		changeADD();

	}

	/**
	 * 5、地址管理：列表有地址；列表地位为空
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getAddress() throws UiObjectNotFoundException {
		UiObject loggedIcon = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/logged_iv_icon"));
		loggedIcon.clickAndWaitForNewWindow();

		UiObject address = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_address"));
		address.click();
		UiCollection allAddress = new UiCollection(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/address_full_rv_recyclerview"));
		if (allAddress.exists()) {
			int countall = allAddress.getChildCount(new UiSelector()
					.className("android.widget.RelativeLayout"));
			System.out.println("地址管理頁面共有 :" + countall + "條地址");
			UiObject receviceuser = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/receiver_name"));
			assertEquals(true, receviceuser.exists());
			System.out.println("reciviceuser  is :" + receviceuser.getText());
			UiObject recevicephone = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/receive_phone"));
			assertEquals(true, recevicephone.exists());
			System.out.println("recevicephone  is :" + recevicephone.getText());
			UiObject receviceaddress = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/receiver_address"));
			assertEquals(true, receviceaddress.exists());
			System.out.println("receviceaddress  is :"
					+ receviceaddress.getText());

		}

	}

	/**
	 * 修改地址：
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void changeADD() throws UiObjectNotFoundException {
		UiObject allAddress = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/address_full_rv_recyclerview"));
		if (allAddress.exists()) {
			UiObject clickADD = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/receiver_address"));
			clickADD.click();
			UiObject edReceivcer = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/ed_receiver"));
			edReceivcer.clearTextField();
			edReceivcer.setText(Utf7ImeHelper.e("唐末"));
			System.out.println("edreceiver is :" + edReceivcer.getText());
			UiObject edphoneNum = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/ed_phoneNum"));
			edphoneNum.clearTextField();
			edphoneNum.setText(Utf7ImeHelper.e("18519065003"));
			System.out.println("edphoneNum is :" + edphoneNum.getText());
			UiObject edAdress = new UiObject(
					new UiSelector().resourceId("com.mappn.gfan:id/ed_address"));
			edAdress.clearTextField();
			edAdress.setText(Utf7ImeHelper.e("北京市海淀区中关村南大街韦伯时代中心C座1814"));
			System.out.println("edAdress is :" + edAdress.getText());

			UiObject chooseADD = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/chooseAddress"));
			Boolean choose = chooseADD.isCheckable();
			System.out.println("choose is :" + choose);

			UiObject save = new UiObject(
					new UiSelector().resourceId("com.mappn.gfan:id/save_tv"));
			save.click();

		}
	}

}
