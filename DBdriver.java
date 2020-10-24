package com.company;

public interface DBdriver {
    boolean checkClient(String fio, String inn) throws BadINNException, BadFIOException;
    boolean checkINN(String inn) throws BadINNException;
    boolean checkFIO(String fio) throws BadFIOException;
}
