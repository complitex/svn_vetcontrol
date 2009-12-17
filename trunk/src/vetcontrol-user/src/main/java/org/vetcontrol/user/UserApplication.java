package org.vetcontrol.user;

import org.apache.wicket.Page;
import org.vetcontrol.web.login.BaseLoginApplication;

/**
 * User: Anatoly A. Ivanov java@inheaven.ru
 * Date: 16.12.2009 21:30:40
 */
public class UserApplication extends BaseLoginApplication{
    @Override
    public Class<? extends Page> getHomePage() {
        return UserHomePage.class; 
    }
}
