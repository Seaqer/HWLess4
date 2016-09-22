package com.ps;

import java.util.*;

/**
 * Created by Артём on 21.09.16
 */
class CollectionUtils {

    /**
     * Добавляет все элементы коллекции source в коллекцию destination
     */
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    /**
     * Создает новый массив
     */
    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * Возвращает индекс вхождения элемента o в массив source
     */
    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    /**
     * Обрезает коллекцию до размера size
     */
    public static <T> List<T> limit(List<? extends T> source, int size) {
        if(source==null || source.size()>=size) {
            return (List<T>) source;
        }
        return (List<T>)source.subList(0,size);
    }

    /**
     * Добавлет элемент в коллекцию
     */
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    /**
     * Удаляет все вхождения элементов в коллекции removeFrom из коллекции c2
     */
    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        if (removeFrom == null || c2 == null) {
            return;
        }
        for (T element : c2) {
            removeFrom.remove(element);
        }


    }

    /**
     * Возвращает все вхождения элементов в коллекции с1 из коллекции c2
     */
    public static <T> boolean containsAll(List<? extends T> c1, List<? super T> c2) {
        if (c1 == null || c2 == null) {
            return false;
        }
        for (int i = 0; i < c2.size(); i++) {
            if (!c1.contains(c2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     */
    public static <T> boolean containsAny(List<? extends T> c1, List<? super T> c2) {
        if (c1 == null || c2 == null) {
            return false;
        }

        for (int i = 0; i < c2.size(); i++) {
            if (c1.contains(c2.get(i)))  {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     */
    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        if (list == null || min == null || max == null) {
            return null;
        }

        List<T> result = new ArrayList<>();

        for (T element:list) {
            if (element.compareTo(min) > 0 && element.compareTo(max) < 0) {
                result.add(element);
            }

        }
        return result;
    }

    /**
     * Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     * Сравнение элементов через Comparable
     */
    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        if (list == null || min == null || max == null) {
            return null;
        }

        List<T> result = new ArrayList<>();

        for (T element : list) {
            if (comparator.compare(element, min) > 0 && comparator.compare(element, max) < 0) {
                result.add(element);
            }
        }
        return result;
    }
}






