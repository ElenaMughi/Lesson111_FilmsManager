package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.FilmsInfo;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private FilmsInfo first = new FilmsInfo(1, "Бладшот", null, "Action", "01/01/2020");
    private FilmsInfo second = new FilmsInfo(2, "Вперед", null, "Cartoon", "01/01/2020");
    private FilmsInfo third = new FilmsInfo(3, "Отель Белград", null, "Comedy", "01/01/2020");
    private FilmsInfo forth = new FilmsInfo(4, "Джентельмены", null, "Action", "01/01/2020");
    private FilmsInfo fifth = new FilmsInfo(5, "Человек-невидимка", null, "Horrors", "01/01/2020");
    private FilmsInfo sixth = new FilmsInfo(6, "Тролли. Мировой тур", null, "Cartoon", "01/01/2020");
    private FilmsInfo seventh = new FilmsInfo(7, "Номер один", null, "Comedy", "01/01/2020");
    private FilmsInfo empty = new FilmsInfo();
    private AfishaRepository repository = Mockito.mock(AfishaRepository.class);
    private AfishaManager manager = new AfishaManager(repository);

    //    @BeforeAll

    public void addFilmForStart() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
    }

    @Test
    public void shouldGetLastFilmsForMockito() {
//        настройка заглушки
        FilmsInfo[] returned = {first, second, third, forth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        manager.removeAll();
        addFilmForStart();

        FilmsInfo[] actual = manager.getLastFilms();
        FilmsInfo[] expected = {seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldGetByIdForMoskito() {
        FilmsInfo returned = fifth;
        doReturn(returned).when(repository).findById(5);

        manager.removeAll();
        addFilmForStart();

        FilmsInfo actual = manager.getById(5);
        FilmsInfo expected = fifth;

        assertEquals(expected, actual);
        verify(repository).findById(5);
    }

}