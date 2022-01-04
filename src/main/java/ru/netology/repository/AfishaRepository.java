package ru.netology.repository;

import ru.netology.domain.FilmsInfo;

public class AfishaRepository {

    private FilmsInfo[] filmsSet = new FilmsInfo[0];

    public void save(FilmsInfo item) {
        int length = filmsSet.length + 1;
        FilmsInfo[] tmp = new FilmsInfo[length];
        System.arraycopy(filmsSet, 0, tmp, 0, filmsSet.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        filmsSet = tmp;
    }

    public FilmsInfo[] findAll() {
        return filmsSet;
    }

    public FilmsInfo findById(int id) {
        FilmsInfo film = null;
        for (FilmsInfo item : filmsSet) {
            if (item.getFilmsId() == id) {
                film = item;
            }
        }
        return film;
    }

    public void removeById(int id) {
        int length = filmsSet.length - 1;
        FilmsInfo[] tmp = new FilmsInfo[length];
        int index = 0;
        for (FilmsInfo item : filmsSet) {
            if (item.getFilmsId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        filmsSet = tmp;
    }

    public void removeAll () {
        FilmsInfo[] tmp = new FilmsInfo[0];
        filmsSet = tmp;
    }
}
