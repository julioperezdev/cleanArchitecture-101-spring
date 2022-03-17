package example.adapter.shared;

import example.core.course.model.Course;
import example.infrastructure.repository.model.CourseEntity;

public class ModelMapper {

    public CourseEntity toEntity(Course course){
        return new CourseEntity(course.getId(), course.getName(), course.getPrice(), course.getCategory());
    }
    public Course toDto(CourseEntity courseEntity){
        return new Course(courseEntity.getId(), courseEntity.getName(), courseEntity.getPrice(),courseEntity.getCategory());
    }

    /**
     * fun toEntity(person: Person): PersonEntity =
     *         PersonEntity(person.dni, person.name, toEntity(person.book), toEntity(person.film))
     *
     *     fun toDto(personEntity: PersonEntity): Person =
     *         Person(personEntity.dni, personEntity.name, toDto(personEntity.book), toDto(personEntity.film))
     *
     *     private fun toEntity(book: Book): BookEntity =
     *         BookEntity(book.id, book.isbn, book.title, book.author, book.publisher, book.publishedDate, book.category)
     *
     *     private fun toEntity(film: Film): FilmEntity =
     *         FilmEntity(film.id, film.title, film.seriesStartYear, film.seriesStartYear, film.numberOfEpisodes, film.runningTimeInMinutes)
     *
     *     private fun toDto(bookEntity: BookEntity): Book =
     *         Book(bookEntity.isbn, bookEntity.title, bookEntity.author, bookEntity.publisher, bookEntity.publishedDate, bookEntity.category, bookEntity.id)
     *
     *     private fun toDto(filmEntity: FilmEntity): Film =
     *         Film(filmEntity.title, filmEntity.seriesStartYear, filmEntity.seriesEndYear, filmEntity.numberOfEpisodes, filmEntity.runningTimeInMinutes, filmEntity.id)
     * }
     */
}
