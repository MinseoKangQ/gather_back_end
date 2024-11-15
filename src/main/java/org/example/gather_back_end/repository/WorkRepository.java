package org.example.gather_back_end.repository;

import java.util.List;
import java.util.Optional;
import org.example.gather_back_end.domain.User;
import org.example.gather_back_end.domain.Work;
import org.example.gather_back_end.work.dto.GetWorkRes;
import org.example.gather_back_end.work.exception.WorkNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    default Work getById(Long id) {
        return findById(id).orElseThrow(WorkNotFoundException::new);
    }

    Optional<Work> findById(Long id);

    List<GetWorkRes> findAllByUser(User user);

    void deleteAllByUser(User user);
}
