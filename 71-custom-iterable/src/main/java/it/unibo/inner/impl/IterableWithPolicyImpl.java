package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private List<T> elements;

    public IterableWithPolicyImpl(T[] elems) {
        this.elements = List.of(elems);
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        
        
    }

    @Override
    public Iterator<T> iterator() {
    }
}

