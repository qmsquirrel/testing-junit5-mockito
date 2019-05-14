package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        Set<Visit> visits = new HashSet<>();

        service.findAll();

        verify(repository).findAll();
    }

    @Test
    void findById() {

        service.findById(1l);

        verify(repository).findById(anyLong());


    }

    @Test
    void save() {
        Visit visit = new Visit();

        service.save(visit);

        verify(repository).save(any(Visit.class));

    }

    @Test
    void delete() {

        Visit visit = new Visit();

        service.delete(visit);

        verify(repository).delete(any(Visit.class));

    }

    @Test
    void deleteById() {

        service.deleteById(1l);

        verify(repository).deleteById(anyLong());
    }
}