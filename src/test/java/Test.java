import jdk.nashorn.internal.runtime.regexp.RegExp;
import junit.framework.TestCase;
import network.HTTPQuery;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static com.jcabi.matchers.RegexMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mikhailsoparin on 23/11/16.
 */

@RunWith(Theories.class)
public class Test extends TestCase{

    @DataPoint
    public static String baz = "0";

    @Theory
    public void test(String candidate) throws IOException{
        HTTPQuery query = new HTTPQuery();

        assertThat(query.sendingGetRequest(candidate), matchesPattern("\\[\\{(.)*\\}\\]"));
    }

}
