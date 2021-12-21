package ru.netology.domain;

public class FilmsInfo {
    private int filmsId;
    private String filmsName;
    private String filmsPict;
    private String filmsGenre;
    private String filmsReleaseDate;

    public FilmsInfo() {
    }

    public FilmsInfo(int filmsId, String filmsName, String filmsPict, String filmsGenre, String filmsReleaseDate) {
        this.filmsId = filmsId;
        this.filmsName = filmsName;
        this.filmsPict = filmsPict;
        this.filmsGenre = filmsGenre;
        this.filmsReleaseDate = filmsReleaseDate;
    }

    public int getFilmsId() {
        return filmsId;
    }

    public String getFilmsGenre() {
        return filmsGenre;
    }

    public String getFilmsReleaseDate() {
        return filmsReleaseDate;
    }

    public String getFilmsPict() {
        return filmsPict;
    }

    public String getFilmsName() {
        return filmsName;
    }

}
