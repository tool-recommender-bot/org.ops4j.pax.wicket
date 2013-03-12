/**
 * Copyright OPS4J
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.wicket.spi.blueprint;

import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.ops4j.pax.wicket.spi.blueprint.injection.blueprint.BlueprintClassResolverDefinitionParser;
import org.ops4j.pax.wicket.spi.support.BundleClassResolverHelperDecorator;

public class BlueprintClassResolverDefinitionParserTest {
    @Test
    public void testRequestRuntimeClass_shouldReturnApplicationDecorator() throws Exception {
        BlueprintClassResolverDefinitionParser parserToTest = new BlueprintClassResolverDefinitionParser();

        Class<?> runtimeClass = parserToTest.getRuntimeClass();

        assertThat(runtimeClass, typeCompatibleWith(BundleClassResolverHelperDecorator.class));
    }

    @Test
    public void testParse() throws Exception {
        BlueprintParserTestUtil parserTestUtil =
            new BlueprintParserTestUtil("wicket:classResolver", new BlueprintClassResolverDefinitionParser());

        parserTestUtil.verifyId("classResolver");
        parserTestUtil.verifyPropertyValue("applicationName");
    }
}
