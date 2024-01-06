package ngn.api.hopdong.reponsitory;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ngn.api.hopdong.models.HopDongModel;

public interface HopDongReponsetory extends JpaRepository<HopDongModel, Integer>{
	
	@Query(value ="SELECT e FROM HopDongModel e")
	List<HopDongModel> getlistpage(String sohopdong,Pageable pageable);
	
	@Query(value = "SELECT e FROM HopDongModel e WHERE e.sohopdong LIKE %:sohopdong% OR e.goithau LIKE %:goithau% OR e.nhaphanphoi LIKE %:nhaphanphoi%")
	List<HopDongModel>getlistpagebyname(String sohopdong,String goithau,String nhaphanphoi,Pageable pageable);
	
	@Query(value = "SELECT e FROM HopDongModel e WHERE e.idchudautu = :idchudautu")
	List<HopDongModel>getListHopDongByChuDauTu(int idchudautu,Pageable pageable);
	
	@Query(value = "SELECT e FROM HopDongModel e WHERE e.idchudautu = :idchudautu")
	List<HopDongModel>getAllHopDongByChuDauTU(int idchudautu);
	
	@Query(value = "SELECT e FROM HopDongModel e WHERE e.checkxuatphieu LIKE :checkxuatphieu")
	List<HopDongModel> getListHopDongOnPhieu(boolean checkxuatphieu);

}
