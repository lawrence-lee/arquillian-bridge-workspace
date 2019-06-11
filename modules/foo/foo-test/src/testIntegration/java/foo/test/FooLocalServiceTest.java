package foo.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

@RunWith(Arquillian.class)
public class FooLocalServiceTest {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@Before
	public void setUp() throws Exception {
		// insert setup code
	}

	@DeleteAfterTestRun
		//insert cleanup code

}
