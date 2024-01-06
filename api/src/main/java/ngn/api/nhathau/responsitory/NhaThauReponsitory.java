package ngn.api.nhathau.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import ngn.api.nhathau.models.NhaThauModel;

public interface NhaThauReponsitory extends JpaRepository<NhaThauModel, Integer>{

}
