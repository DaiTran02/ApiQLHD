package ngn.api.chudautu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngn.api.chudautu.models.ChuDauTuModel;
import ngn.api.chudautu.repository.ChuDauTuRepository;

@Service
@Transactional
public class ChuDauTuService {
	@Autowired
	ChuDauTuRepository chuDauTuRepository;
	
	public List<ChuDauTuModel> getAllChuDauTu(){
		return chuDauTuRepository.findAll();
	}
	
	public List<ChuDauTuModel> getChuDauTuPanigation(boolean checkCmb,String tenchudautu,String machudautu,int offset, int limit){
		Pageable page = PageRequest.of(offset,limit);
		if(checkCmb == true) {
			return getAllChuDauTu();
		}
		return chuDauTuRepository.gettenchudautu(tenchudautu, machudautu,page );
			
	}
	
	public ChuDauTuModel getAChuDauTu(Integer id) {
		return chuDauTuRepository.findById(id).get();
	}
	
	public ChuDauTuModel addChuDauTu(ChuDauTuModel chuDauTuModel) {
		return chuDauTuRepository.save(chuDauTuModel);
	}
	
	public void delete(Integer idChuDauTu) {
		chuDauTuRepository.deleteById(idChuDauTu);
	}
	
	public ChuDauTuModel updateChuDauTu(ChuDauTuModel chuDauTuModel) {
		ChuDauTuModel chuDauTuModel2 = chuDauTuRepository.findById(chuDauTuModel.getId()).get();
		chuDauTuModel2=chuDauTuModel;
		chuDauTuRepository.save(chuDauTuModel2);
		return chuDauTuModel2;
	}
	

}
