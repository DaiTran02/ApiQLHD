package ngn.api.chudautu.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ngn.api.chudautu.models.ChuDauTuModel;

public interface ChuDauTuRepository extends  JpaRepository<ChuDauTuModel, Integer>{
	
	@Query(value="SELECT e FROM ChuDauTuModel e")
	List<ChuDauTuModel> tenchudautu(String tenchudautu, Pageable pageable);
	
	@Query(value = "SELECT e FROM ChuDauTuModel e WHERE e.tenchudautu LIKE %:tenchudautu% OR e.machudautu LIKE %:machudautu%")
	List<ChuDauTuModel> gettenchudautu(String tenchudautu,String machudautu, Pageable pageable);
}
