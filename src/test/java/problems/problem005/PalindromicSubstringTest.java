package problems.problem005;

import base.BootstrapTemplate;
import base.BootstrapTemplateTest;
import base.problem.problem005.PalindromicSubstringTemplate;
import org.testng.annotations.BeforeClass;

public class PalindromicSubstringTest extends BootstrapTemplateTest<String, String> {

    @BeforeClass
    @Override
    public void setup() {
        this.template = new PalindromicSubstringTemplate();
    }

}
