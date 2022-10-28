package br.com.serviceportfolio.core.patterns.adapter;

public abstract class BaseAdapter<TTarget> implements IAdapter<TTarget> {

    protected TTarget to;

    protected BaseAdapter(TTarget to) {
        this.to = to;
    }
}
