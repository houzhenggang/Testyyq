package txh.com.yyq.my;

import java.util.ArrayList;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;
import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * 地址管理： 1、获取地址管理列表已有的地址数量 2、编辑已有的地址 3、删除地址 4、[添加地址] 5、[添加]地址
 * 
 * @author xiaohua
 * 
 */
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
		deleteADD();
		addAddress();
		addAdress2();
		backLogout();

	}

	/**
	 * 5、地址管理：列表有地址；列表地址不为空
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
	 * 修改地址：列表地址不为空
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
			edReceivcer.clickBottomRight();
			edReceivcer.clearTextField();
			edReceivcer.setText(Utf7ImeHelper.e("唐末"));
			System.out.println("edreceiver is :" + edReceivcer.getText());
			UiObject edphoneNum = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/ed_phoneNum"));
			edphoneNum.clickBottomRight();
			edphoneNum.clearTextField();
			edphoneNum.setText(Utf7ImeHelper.e("18519065003"));
			System.out.println("edphoneNum is :" + edphoneNum.getText());

			changeAddre();

			UiObject edAddress = new UiObject(
					new UiSelector().resourceId("com.mappn.gfan:id/ed_address"));
			edAddress.clickBottomRight();
			edAddress.clearTextField();
			edAddress.setText(Utf7ImeHelper.e("南大街韦伯时代中心C座1814"));
			System.out.println("edAddress is :" + edAddress.getText());

			UiObject chooseADD = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/chooseAddress"));
			Boolean choose = chooseADD.isCheckable();
			System.out.println("choose is :" + choose);
			chooseADD.click();
			System.out.println("choose is :" + choose);

			UiObject save = new UiObject(
					new UiSelector().resourceId("com.mappn.gfan:id/save_tv"));
			save.click();

		}
	}

	/**
	 * 修改地址: 获取省份城市地区；并选择省份城市地区
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void changeAddre() throws UiObjectNotFoundException {
		UiObject provice = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/ed_spProvince"));
		provice.click();
		UiCollection collProvince = new UiCollection(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		ArrayList<String> provinceLists = new ArrayList<String>();
		if (collProvince.exists()) {
			int provinceCount = collProvince.getChildCount(new UiSelector()
					.resourceId("android:id/text1"));
			for (int i = 0; i < provinceCount; i++) {
				UiObject Province = new UiObject(new UiSelector().resourceId(
						"android:id/text1").instance(i));
				if (Province.exists()) {
					provinceLists.add(Province.getText());
				}
			}
		}
		System.out.println("province lists is :" + provinceLists);
		UiScrollable provincelist = new UiScrollable(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		UiObject scrollProvince = provincelist.getChildByText(
				new UiSelector().resourceId("android:id/text1"), "宁夏", true);
		scrollProvince.click();

		UiObject city = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/ed_spCity"));
		city.click();
		UiCollection collCity = new UiCollection(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		ArrayList<String> cityLists = new ArrayList<String>();

		if (collCity.exists()) {
			int cityCount = collProvince.getChildCount(new UiSelector()
					.resourceId("android:id/text1"));
			for (int i = 0; i < cityCount; i++) {
				UiObject City = new UiObject(new UiSelector().resourceId(
						"android:id/text1").instance(i));
				if (City.exists()) {
					cityLists.add(City.getText());
				}
			}
		}
		System.out.println("City lists is :" + cityLists);
		UiScrollable citylist = new UiScrollable(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		UiObject scrollCity = citylist.getChildByText(
				new UiSelector().resourceId("android:id/text1"), "中卫", true);
		scrollCity.click();

		UiObject district = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/ed_spDistrict"));
		district.click();
		UiCollection collDistrict = new UiCollection(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		ArrayList<String> districLists = new ArrayList<String>();

		if (collDistrict.exists()) {
			int districtCount = collDistrict.getChildCount(new UiSelector()
					.resourceId("android:id/text1"));
			for (int i = 0; i < districtCount; i++) {
				UiObject District = new UiObject(new UiSelector().resourceId(
						"android:id/text1").instance(i));
				if (District.exists()) {
					districLists.add(District.getText());
				}
			}
		}
		System.out.println("distric lists is :" + districLists);
		UiScrollable districtlist = new UiScrollable(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		UiObject scrollDistrict = districtlist.getChildByText(
				new UiSelector().resourceId("android:id/text1"), "海原", true);
		scrollDistrict.click();

	}

	/**
	 * 增加地址: 获取省份城市地区；并选择省份城市地区
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void addAddre() throws UiObjectNotFoundException {
		UiObject addReceiver = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/receiver"));
		addReceiver.click();
		addReceiver.setText(Utf7ImeHelper.e("莫默"));
		UiObject addPhoneNum = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/phoneNum"));
		addPhoneNum.click();
		addPhoneNum.setText(Utf7ImeHelper.e("15107781009"));
		UiObject provice = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/spProvince"));
		provice.click();
		UiCollection collProvince = new UiCollection(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		ArrayList<String> provinceLists = new ArrayList<String>();
		if (collProvince.exists()) {
			int provinceCount = collProvince.getChildCount(new UiSelector()
					.resourceId("android:id/text1"));
			for (int i = 0; i < provinceCount; i++) {
				UiObject Province = new UiObject(new UiSelector().resourceId(
						"android:id/text1").instance(i));
				if (Province.exists()) {
					provinceLists.add(Province.getText());
				}
			}
		}
		System.out.println("province lists is :" + provinceLists);
		UiScrollable provincelist = new UiScrollable(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		UiObject scrollProvince = provincelist.getChildByText(
				new UiSelector().resourceId("android:id/text1"), "宁夏", true);
		scrollProvince.click();
		sleep(2500);
		UiObject city = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/spCity"));
		city.click();
		UiCollection collCity = new UiCollection(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		ArrayList<String> cityLists = new ArrayList<String>();

		if (collCity.exists()) {
			int cityCount = collProvince.getChildCount(new UiSelector()
					.resourceId("android:id/text1"));
			for (int i = 0; i < cityCount; i++) {
				UiObject City = new UiObject(new UiSelector().resourceId(
						"android:id/text1").instance(i));
				if (City.exists()) {
					cityLists.add(City.getText());
				}
			}
		}
		System.out.println("City lists is :" + cityLists);
		UiScrollable citylist = new UiScrollable(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		UiObject scrollCity = citylist.getChildByText(
				new UiSelector().resourceId("android:id/text1"), "中卫", true);
		scrollCity.click();

		UiObject district = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/spDistrict"));
		district.click();
		sleep(1500);
		UiCollection collDistrict = new UiCollection(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		ArrayList<String> districLists = new ArrayList<String>();

		if (collDistrict.exists()) {
			int districtCount = collDistrict.getChildCount(new UiSelector()
					.resourceId("android:id/text1"));
			for (int i = 0; i < districtCount; i++) {
				UiObject District = new UiObject(new UiSelector().resourceId(
						"android:id/text1").instance(i));
				if (District.exists()) {
					districLists.add(District.getText());
				}
			}
		}
		System.out.println("distric lists is :" + districLists);
		UiScrollable districtlist = new UiScrollable(
				new UiSelector()
						.resourceId("android:id/select_dialog_listview"));
		UiObject scrollDistrict = districtlist.getChildByText(
				new UiSelector().resourceId("android:id/text1"), "海原", true);
		scrollDistrict.click();
		UiObject addDetailsADD = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/address"));
		addDetailsADD.click();
		addDetailsADD.setText(Utf7ImeHelper.e("七星区育才小学8学区8栋889号"));
		UiObject save = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/save_tv"));
		save.click();

	}

	/**
	 * 删除地址
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void deleteADD() throws UiObjectNotFoundException {
		sleep(2000);
		UiObject allAddress = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/address_full_rv_recyclerview"));
		// assertEquals(true, allAddress.exists());
		if (allAddress.exists()) {
			UiObject clickADD = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/receiver_address"));
			clickADD.click();
			UiObject delete = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/delete_address"));
			delete.click();
			UiObject negtive = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/btn_negative"));
			negtive.click();
			delete.click();
			UiObject positive = new UiObject(
					new UiSelector()
							.resourceId("com.mappn.gfan:id/btn_positive"));
			positive.click();

		}

	}

	/**
	 * 添加地址：
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void addAddress() throws UiObjectNotFoundException {
		UiObject addAddress = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/btn_add_address"));
		// assertEquals(true, addAddress.exists());
		if (addAddress.exists()) {
			addAddress.click();
			addAddre();
		}

	}

	/**
	 * 点击[添加]，添加地址
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void addAdress2() throws UiObjectNotFoundException {
		UiObject addButton = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/add_address_tv"));
		// assertEquals(true, addButton.exists());
		addButton.click();
		addAddre();

	}

	/**
	 * 返回： 注销：
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void backLogout() throws UiObjectNotFoundException {
		UiObject backButton = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backButton.click();
		UiObject logout = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/user_layout_exit"));
		logout.click();
		UiObject positive = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/btn_positive"));
		positive.click();
		backButton.click();

	}

}
