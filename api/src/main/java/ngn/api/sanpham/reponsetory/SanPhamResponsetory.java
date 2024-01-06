package ngn.api.sanpham.reponsetory;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ngn.api.sanpham.models.SanPhamModel;

public interface SanPhamResponsetory extends JpaRepository<SanPhamModel, Integer>{
	@Query(value="SELECT e FROM SanPhamModel e")
	List<SanPhamModel> getPageNoName(String tensanpham,Pageable pageable);
	
	@Query(value="SELECT e FROM SanPhamModel e WHERE e.tensanpham LIKE %:tensanpham% OR e.loaisanpham LIKE %:loaisanpham% OR e.kymahieu LIKE %:kymahieu%")
	List<SanPhamModel> getPageByName(String tensanpham,String loaisanpham,String kymahieu,Pageable pageable);
	
	@Query(value = "SELECT e FROM SanPhamModel e join HopDongModel hd on e.idhopdong=hd.id WHERE hd.idchudautu = :idchudautu")
	List<SanPhamModel> getPageByChuDauTu(Integer idchudautu,Pageable pageable);
	
	@Query(value = "SELECT e FROM SanPhamModel e join HopDongModel hd on e.idhopdong=hd.id WHERE hd.idchudautu = :idchudautu")
	List<SanPhamModel> getCountSanPhamByChuDauTu(Integer idchudautu);
	
	@Query(value ="SELECT e FROM SanPhamModel e WHERE e.idhopdong = :idhopdong")
	List<SanPhamModel> getListSanPhamByIdHopDong (Integer idhopdong,Pageable pageable);
	
	@Query(value = "SELECT e FROM SanPhamModel e WHERE e.idhopdong = :idhopdong")
	List<SanPhamModel> getCountSanPhamByIdHopDong(Integer idhopdong);

}
