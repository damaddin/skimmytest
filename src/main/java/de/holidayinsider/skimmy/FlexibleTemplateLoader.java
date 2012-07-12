package de.holidayinsider.skimmy;

import freemarker.cache.URLTemplateLoader;

import java.net.URL;

/**
 * User: martinstolz
 * Date: 11.07.12
 */
public class FlexibleTemplateLoader extends URLTemplateLoader {

    @Override
    protected URL getURL(String name) {
        URL url = getClass().getResource(name);
        if (url == null) {
            return getClass().getClassLoader().getResource(name);
        }
        return null;
    }
}
