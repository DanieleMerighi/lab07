package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private List<T> elements;
    private Predicate<T> filter;

    public IterableWithPolicyImpl(T[] elems) {
        //utilizzo il secondo costruttore e creo un predicato che ritorna di default true
        this(elems,
        new Predicate<T>() {
            @Override
            boolean test(T elem) {
                return true;
            }
        }; 
        );
    }

    public IterableWithPolicyImpl(T[] elems, Predicate<T> filter) {
        this.elements = List.of(elems);
        this.filter = filter;
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

