package smart.projet.GestionGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smart.projet.GestionGarage.entity.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {

}
