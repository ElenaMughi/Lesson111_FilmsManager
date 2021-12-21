package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmsInfo;

import static org.junit.jupiter.api.Assertions.*;

class FilmsManagerTest {

    private FilmsInfo first = new FilmsInfo(1, "Бладшот", null, "Action", "01/01/2020");
    private FilmsInfo second = new FilmsInfo(2, "Вперед", null, "Cartoon", "01/01/2020");
    private FilmsInfo third = new FilmsInfo(3, "Отель Белград", null, "Comedy", "01/01/2020");
    private FilmsInfo forth = new FilmsInfo(4, "Джентельмены", null, "Action", "01/01/2020");
    private FilmsInfo fifth = new FilmsInfo(5, "Человек-невидимка", null, "Horrors", "01/01/2020");
    private FilmsInfo sixth = new FilmsInfo(6, "Тролли. Мировой тур", null, "Cartoon", "01/01/2020");
    private FilmsInfo seventh = new FilmsInfo(7, "Номер один", null, "Comedy", "01/01/2020");
    private FilmsInfo empty = new FilmsInfo();

    public void shouldAddFilm(FilmsManager Repo) {
        Repo.addFilm(first);
        Repo.addFilm(second);
        Repo.addFilm(third);
        Repo.addFilm(forth);
        Repo.addFilm(fifth);
        Repo.addFilm(sixth);
        Repo.addFilm(seventh);
//        FilmsInfo[] expected = {first, second, third, forth, fifth, sixth, seventh};
//        assertArrayEquals(expected, Repo.getFilmsSet());
    }

    @Test
    public void shouldGetFilmsLessTenFilmsInRepo() {
        FilmsManager Repo = new FilmsManager();
        shouldAddFilm(Repo);
        FilmsInfo[] actual = Repo.getLastFilms();
        FilmsInfo[] expected = {seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmsMoreTenFilmsInRepo() {
        FilmsManager Repo = new FilmsManager();
        shouldAddFilm(Repo);
        shouldAddFilm(Repo);
        FilmsInfo[] actual = Repo.getLastFilms();
        FilmsInfo[] expected = {seventh, sixth, fifth, forth, third, second, first, seventh, sixth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmsInRepoLessLimitFilms() {
        FilmsManager Repo = new FilmsManager();
        shouldAddFilm(Repo);
        FilmsInfo[] actual = Repo.getLastFilms(8);
        FilmsInfo[] expected = {seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFilmsFilmsInRepoMoreLimitFilms() {
        FilmsManager Repo = new FilmsManager();
        shouldAddFilm(Repo);
        shouldAddFilm(Repo);
        FilmsInfo[] actual = Repo.getLastFilms(8);
        FilmsInfo[] expected = {seventh, sixth, fifth, forth, third, second, first, seventh};
        assertArrayEquals(expected, actual);
    }

    public void shouldGetFilmsFilmsInRepoMoreLimitFilmsWithNull() {
        FilmsManager Repo = new FilmsManager();
        shouldAddFilm(Repo);
        FilmsInfo[] actual = Repo.getLastFilms(8);
        FilmsInfo[] expected = {seventh, sixth, fifth, forth, third, second, first, seventh};
        assertArrayEquals(expected, actual);
    }
}