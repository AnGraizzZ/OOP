package com.javalesson.generics;

import java.util.List;

public interface BoxList<E,T> extends List<E> { //У интерфейса может быть несколько generic типов
    T calcSum(E elementE,T elementT);

}
