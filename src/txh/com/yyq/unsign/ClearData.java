package txh.com.yyq.unsign;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.txh.yyq.uiautomatorhelper.UiAutomatorHelper;

public class ClearData extends UiAutomatorTestCase {
//	UiDevice device;
//	public  ClearData(UiDevice uidevice){
//		device = uidevice;
//	}
	public static void main(String[] args) {
		String jarName = "ClearData";
		String testClass = "txh.com.yyq.ClearData";
		String testName = "testCase";
		String androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

	public void testCase() throws UiObjectNotFoundException {
		openSetting();
	}

	public void openSetting() throws UiObjectNotFoundException {
		UiDevice device = getUiDevice();
		device.openQuickSettings();

	}

}
