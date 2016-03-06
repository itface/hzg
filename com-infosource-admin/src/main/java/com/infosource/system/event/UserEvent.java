package com.infosource.system.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by wangrongtao on 15/10/17.
 */
public class UserEvent extends ApplicationEvent {
    public UserEvent(Object source) {
        super(source);
    }
    /*private User user;
    public UserEvent(Object source) {
        super(source);
    }

    public UserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }*/

}
