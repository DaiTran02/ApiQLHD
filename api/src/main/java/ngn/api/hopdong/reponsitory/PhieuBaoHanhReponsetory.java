package ngn.api.hopdong.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ngn.api.hopdong.models.PhieuBaoHanhModel;

public interface PhieuBaoHanhReponsetory extends JpaRepository<PhieuBaoHanhModel, Integer>{
	
	@Query(value = "SELECT e FROM PhieuBaoHanhModel e WHERE e.idhopdong LIKE :idhopdong")
	List<PhieuBaoHanhModel> getDataPhieuKoIdHopDong(Integer idhopdong);
	
	@Query(value = "SELECT e FROM PhieuBaoHanhModel e WHERE e.idhopdong LIKE :idhopdong")
	PhieuBaoHanhModel getDataPhieuBaoHanh(Integer idhopdong);
}
