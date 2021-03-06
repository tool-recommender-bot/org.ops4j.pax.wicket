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
package org.ops4j.pax.wicket.samples.plain.simple.internal;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

/**
 * Very simple page providing entry points into various other examples.
 *
 * @author nmw
 * @version $Id: $Id
 */
public class Homepage extends WebPage {

    private static final long serialVersionUID = 1L;

    /**
     * <p>Constructor for Homepage.</p>
     */
    public Homepage() {
        add(new Label("oneComponent", "Welcome to the most simple pax-wicket application"));
        add(new Link<Void>("pageFactoryLink") {
            @Override
            public void onClick() {
                setResponsePage(SimpleTestPage.class);
            }
        });
    }
}
