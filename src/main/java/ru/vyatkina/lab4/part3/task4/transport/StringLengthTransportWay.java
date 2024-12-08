package ru.vyatkina.lab4.part3.task4.transport;

public class StringLengthTransportWay implements TransportWay<String> {
    @Override
    public Integer transport(String element) {
        return element.length();
    }
}
