package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterablePlainImpl<T> implements IterableWithPolicy<T> {
    private List<T> elements;

    public IterablePlainImpl(T[] elems) {
        this.elements = List.of(elems);
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        
        
    }

    @Override
    public Iterator<T> iterator() {
        return new PolicyIterator();
    }

    private class PolicyIterator implements Iterator<T> {

        private int currIndex = 0;

        @Override
        public boolean hasNext() {
            if (currIndex < elements.size()) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return elements.get(currIndex++);
        }
        
    }

}

