package foo.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import foo.model.Foo;
import foo.service.FooLocalService;
import foo.service.FooLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.junit.runner.RunWith;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Date;

@RunWith(Arquillian.class)
public class FooLocalServiceTest {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void addTestData() {
		Foo foo = FooLocalServiceUtil.createFoo(0);

		foo.setField1("createFooEntryField1");
		foo.setField2(true);
		foo.setField3(1);

		Date createDate = new Date();

		foo.setField4(createDate);

		foo.setField5("createFooEntryField5");
		foo.isNew();

		Foo fooEntry = FooLocalServiceUtil.addFoo(foo);

		if (!fooEntry.getField2()) {
			_log.error("Test Failed");
		}

		FooLocalServiceUtil.deleteFoo(fooEntry);
	}

	private static final Log _log = LogFactoryUtil.getLog(FooLocalServiceTest.class);

	@Inject//acts like @Reference but for tests
	private FooLocalService _fooLocalService;

}