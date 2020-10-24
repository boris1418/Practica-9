package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ClientData implements DBdriver {
    HashMap<String, String> inn;
    public ClientData() {
        this.inn = new HashMap<String, String>();
    }
    public void loadData(String file) {
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()) {
                String[] s = sc.nextLine().split("::");
                inn.put(s[0], s[1]);
            }
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public boolean checkClient(String fio, String inn) throws BadINNException, BadFIOException {
        if (this.inn.get(inn) == null) {
            throw new BadINNException("ИНН не действителен");
        }
        if (!this.inn.get(inn).equals(fio)) {
            throw new BadFIOException("Неверный ФИО");
        }
        return true;
    }

    @Override
    public boolean checkINN(String inn) throws BadINNException {
        if (this.inn.get(inn) == null) {
            throw new BadINNException("ИНН не действителен");
        }
        return true;
    }

    @Override
    public boolean checkFIO(String fio) throws BadFIOException {

        for (Map.Entry<String, String> entry : inn.entrySet()) {
            if (entry.getValue().equals(fio)) {
                return true;
            }
        }
        throw new BadFIOException("Неверный ФИО");
    }

}
