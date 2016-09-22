package com.ps;

import java.util.*;

/**
 * Created by Артём on 20.09.16
 */
class CountMapIml<T> implements CountMap<T> {


    private final Map<T, Integer> elementData;

    CountMapIml() {
        elementData = new HashMap<>();
    }

    /**
     * Добавляет элемент в этот контейнер.
     */
    public void add(T o) {
        if (o != null) {
            if (elementData.containsKey(o)) {
                int count = elementData.get(o);
                elementData.put(o, ++count);
            } else {
                elementData.put(o, 1);
            }
        }
    }

    /**
     * Возвращает количество добавлений данного элемента
     */
    public int getCount(T o) {

        return (o == null) ? 0 : elementData.get(o);
    }

    /**
     * Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
     */
    public int remove(T o) {
        int count = 0;

        if (o != null && elementData.containsKey(o)) {
            count = elementData.get(o);

            if (count == 1) {
                elementData.remove(o);
            } else {
                elementData.put(o, count - 1);
            }
        }
        return count;
    }

    /**
     * Возвращает количество разных элементов
     */
    public int size() {
        return elementData.size();
    }

    /**
     * Добавляет все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
     */
    public void addAll(CountMap<T> source) {
        if (source != null) {
            for (Map.Entry<T, Integer> entry : source.toMap().entrySet()) {
                int valueSrc = entry.getValue();

                if (elementData.containsKey(entry.getKey())) {
                    int valueTrg = elementData.get(entry.getKey());
                    elementData.put(entry.getKey(), valueTrg + valueSrc);
                } else {
                    elementData.put(entry.getKey(), valueSrc);
                }
            }
        }
    }

    /**
     * Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
     */
    public Map<T, Integer> toMap() {
        return elementData;
    }

    /**
     * Тот же самый контракт как и toMap(), только всю информацию записать в destination
     */
    public void toMap(Map<T, Integer> destination) {
        if (destination != null) {

            for (Map.Entry<T, Integer> entry : elementData.entrySet()) {
                int valueSrc = entry.getValue();

                if (destination.containsKey(entry.getKey())) {
                    int valueTrg = destination.get(entry.getKey());
                    destination.put(entry.getKey(), valueTrg + valueSrc);
                } else {
                    destination.put(entry.getKey(), valueSrc);
                }
            }
        }
    }
}
