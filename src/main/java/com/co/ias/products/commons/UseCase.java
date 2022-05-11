package com.co.ias.products.commons;

public interface UseCase<Input, Output> {
    Output excute(Input input);
}
