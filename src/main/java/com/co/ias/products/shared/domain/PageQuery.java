package com.co.ias.products.shared.domain;

public class PageQuery {
    private final Page page;
    private final PageSize pageSize;


    public PageQuery(Page page, PageSize pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Page getPage() {
        return page;
    }

    public PageSize getPageSize() {
        return pageSize;
    }
}
