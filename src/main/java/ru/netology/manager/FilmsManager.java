package ru.netology.manager;

import ru.netology.domain.FilmsInfo;
//import java.util.Arrays;

public class FilmsManager {

    private FilmsInfo[] filmsSet = new FilmsInfo[0];
    private int howMany = 10;

    public FilmsManager(int howMany) {
        this.howMany = howMany;
    }

    public FilmsManager() {
    }

    public void addFilm(FilmsInfo addingFilm) {
        int lenght = filmsSet.length + 1;
        FilmsInfo[] tmp = new FilmsInfo[lenght];
        System.arraycopy(filmsSet, 0, tmp, 0, filmsSet.length);
        int last = tmp.length - 1;
        tmp[last] = addingFilm;
        this.filmsSet = tmp;
    }

    public FilmsInfo[] getLastFilms() {

        int lenght = Math.min(howMany, filmsSet.length);

        FilmsInfo[] result = new FilmsInfo[lenght];

        for (int i = 0; i < lenght; i++) {
            int index = filmsSet.length - i - 1;
            result[i] = filmsSet[index];
        }

        return result;
    }

//    public FilmsInfo[] getLastFilms(int numberOfFilm) {
//            int lenght = Math.min(numberOfFilm, filmsSet.length);
//            FilmsInfo[] result = new FilmsInfo[lenght];
//            for (int i = 0; i < lenght; i++) {
//                int index = filmsSet.length - i - 1;
//                result[i] = filmsSet[index];
//            }
//            return result;
//        }

}
