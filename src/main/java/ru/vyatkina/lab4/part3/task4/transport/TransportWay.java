package ru.vyatkina.lab4.part3.task4.transport;


public interface TransportWay<T> {
    Integer transport(T element);
}
