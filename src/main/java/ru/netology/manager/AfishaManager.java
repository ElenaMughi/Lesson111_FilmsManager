package ru.netology.manager;

import ru.netology.domain.FilmsInfo;
import ru.netology.repository.AfishaRepository;
//import java.util.Arrays;

public class AfishaManager {

    private int howMany = 10;
    private AfishaRepository repo = new AfishaRepository();

    public AfishaManager(int howMany) {
        this.howMany = howMany;
    }

    public AfishaManager() {
    }

    public AfishaManager(AfishaRepository repo) {
        this.repo = repo;
    }

    public void addFilm(FilmsInfo addingFilm) {
        repo.save(addingFilm);
    }

    public FilmsInfo[] getLastFilms() {
        FilmsInfo[] items = repo.findAll();
        int lenght = Math.min(howMany, items.length);
        FilmsInfo[] result = new FilmsInfo[lenght];

        for (int i = 0; i < lenght; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }

        return result;
    }
    public FilmsInfo[] getAll() {
        FilmsInfo[] items = repo.findAll();
        FilmsInfo[] result = new FilmsInfo[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public FilmsInfo getById(int id) {
        return repo.findById(id);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public void removeAll() {
        repo.removeAll();
    }
}
