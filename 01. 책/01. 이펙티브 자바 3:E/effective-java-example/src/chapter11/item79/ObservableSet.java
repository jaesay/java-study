package chapter11.item79;

import chapter8.item50.ForwardingSet;

import java.util.*;

public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
//        synchronized (observers) {
//            for (SetObserver<E> observer : observers) {
//                observer.added(this, element);
//            }
//        }
        List<SetObserver<E>> snapshot = null;
        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }
        for (SetObserver<E> observer :snapshot) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E e) {
        boolean added = super.add(e);
        if (added) {
            notifyElementAdded(e);
        }

        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E e : c) {
            result |= add(e);
        }

        return result;
    }
}
