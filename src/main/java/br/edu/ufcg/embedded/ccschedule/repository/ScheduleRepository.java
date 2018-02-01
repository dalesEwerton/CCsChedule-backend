package br.edu.ufcg.embedded.ccschedule.repository;

import br.edu.ufcg.embedded.ccschedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    
}
