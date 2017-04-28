package poc.service;

import javaslang.collection.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import poc.BaseTest;
import poc.model.Feature;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@Sql({ "drop-schema.sql","create-schema.sql","FeatureServiceTest.sql" })

@Transactional
public class FeatureServiceTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(FeatureServiceTest.class);

    @Autowired
    private FeatureService featureService;

    @Test
    public void testFindFeaturesWithContainer() {
        List<Feature> features = featureService.findAll();
        features.forEach($ -> assertThat($.getContainer().getName(), is(not(nullValue()))));
        assertThat(features.size(), is(5));
    }

    @Test
    public void testFindFeaturesContainingAtTheBeginning() {
        String value = "azu";
        assertElementsWith(value, 1L, 3L, 4L);
    }


    @Test
    public void testFindFeaturesContainingInTheMiddle() {
        String value = "cla";
        assertElementsWith(value, 1L, 5L);
    }

    @Test
    public void testNotFoundFeatures() {
        String value = "notfound";
        assertElementsWith(value);

    }

    private <T> void assertElementsWith(String value, T... elements) {
        List<Feature> features = featureService.findFeaturesContaining(value);
        assertThat(features.size(), is(elements.length));
        assertThat(features.map(Feature::getId), containsInAnyOrder(elements));
        features.map(Feature::getValue).forEach($ -> assertThat($, containsString(value)));
    }


}
