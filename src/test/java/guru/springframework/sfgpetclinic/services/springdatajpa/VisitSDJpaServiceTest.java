package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        Set<Visit> visits = new HashSet<>();

        when(repository.findAll()).thenReturn(visits);

        Set<Visit> visitsFound = service.findAll();

        verify(repository).findAll();

        assertThat(visitsFound).isNotNull().isEqualTo(visits);
    }

    @Test
    void findById() {
        Visit visit = new Visit();

        when(repository.findById(anyLong())).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1l);

        verify(repository).findById(anyLong());

        assertThat(foundVisit).isInstanceOf(Visit.class).isNotNull();

    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(repository.save(any(Visit.class))).thenReturn(visit);

        Visit visit1 = service.save(visit);

        verify(repository).save(any(Visit.class));

        assertThat(visit1).isInstanceOf(Visit.class).isNotNull().isEqualTo(visit);

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