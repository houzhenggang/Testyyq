package txh.com.yyq.productdetails;

import txh.com.yyq.unsign.UiAutomatorHelper;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ClickFirstPage extends UiAutomatorTestCase {

	public static void main(String[] args) {
		String jarName = "ClickFirstPage";
		String testClass = "txh.com.yyq.productdetails.ClickFirstPage";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}

	public void testCase() throws UiObjectNotFoundException {
		getProDetail();
	}

	/**
	 * 
	 * @throws UiObjectNotFoundException
	 */
	public void getProDetail() throws UiObjectNotFoundException {
		UiObject proIcon = new UiObject(
				new UiSelector()
						.resourceId("com.mappn.gfan:id/gm3_home_yyq_widget_1"));
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
