package txh.com.yyq.productdetails;


import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class ClickYYQPage extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "ClickYYQPage";
		String testClass = "txh.com.yyq.productdetails.ClickYYQPage";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	
	public void testCase() throws UiObjectNotFoundException {
		getProDetail();
	}
	/**
	 * 商品详情页：应用商店首页-一元抢-商品详情-返回应用商店首页
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getProDetail()throws UiObjectNotFoundException{
		UiObject fourthNav = new UiObject(
				new UiSelector().resourceId("com.mappn.gfan:id/fourthNav"));
		fourthNav.clickAndWaitForNewWindow();
		UiObject proIcon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/yyq_home_item_iv_icon"));
		proIcon.clickAndWaitForNewWindow();
		sleep(1500);
		ProductDetails prodetail = new ProductDetails(getUiDevice());
		prodetail.testCase();

		UiObject backBtn = new UiObject(
				new UiSelector().className("android.widget.ImageButton"));
		backBtn.click();
		backBtn.click();
	}

}
