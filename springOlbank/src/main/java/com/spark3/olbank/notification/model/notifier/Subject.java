package com.spark3.olbank.notification.model.notifier;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<INotifier> notifiers;

    public Subject() {
        notifiers = new ArrayList<>();
    }

    public void registerNotifier(INotifier notifier) {
        notifiers.add(notifier);
    }

    public void sendNotifications() {
        notifiers.forEach(INotifier::sendNotification);
    }

    public void unregisterNotifier(INotifier notifier) {
        notifiers.remove(notifier);
    }

}
