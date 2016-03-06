package com.infosource.system.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by wangrongtao on 15/10/17.
 */
//@Service
public class UserPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
//
//    public void saveUser() {
//        UserEvent userEvent = new UserEvent(this);
//        applicationEventPublisher.publishEvent(userEvent);
//    }
}
