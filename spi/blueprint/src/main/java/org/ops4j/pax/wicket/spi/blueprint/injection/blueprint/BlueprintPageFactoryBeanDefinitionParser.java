
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
 *
 * @author nmw
 * @version $Id: $Id
 */
package org.ops4j.pax.wicket.spi.blueprint.injection.blueprint;

import org.apache.aries.blueprint.ParserContext;
import org.apache.aries.blueprint.mutable.MutableBeanMetadata;
import org.ops4j.pax.wicket.api.PaxWicketBeanInjectionSource;
import org.ops4j.pax.wicket.spi.support.InjectionParserUtil;
import org.ops4j.pax.wicket.spi.support.PageFactoryDecorator;
import org.w3c.dom.Element;
public class BlueprintPageFactoryBeanDefinitionParser extends AbstractBlueprintBeanDefinitionParser {

    /** {@inheritDoc} */
    @Override
    public Class<?> getRuntimeClass() {
        return PageFactoryDecorator.class;
    }

    /** {@inheritDoc} */
    @Override
    protected void extractRemainingMetaData(Element element, ParserContext context, MutableBeanMetadata beanMetadata)
        throws Exception {
        addPropertyValueFromElement("pageId", element, context, beanMetadata);
        addPropertyValueFromElement("applicationName", element, context, beanMetadata);
        addPropertyValueFromElement("pageName", element, context, beanMetadata);
        addPropertyValueFromElement("pageClass", element, context, beanMetadata);
        addPropertyReferenceForMap("overwrites", context, beanMetadata,
            InjectionParserUtil.retrieveOverwriteElements(element));
        beanMetadata.addProperty("injectionSource",
            createStringValue(context, PaxWicketBeanInjectionSource.INJECTION_SOURCE_BLUEPRINT));
    }

}
