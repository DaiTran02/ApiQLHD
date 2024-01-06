package ngn.api.nhathau.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ngn.api.nhathau.models.NhaThauModel;
import ngn.api.nhathau.responsitory.NhaThauReponsitory;

@Service
public class NhaThauService {

	@Autowired
	NhaThauReponsitory nhaThauReponsitory;
	
	public List<NhaThauModel> getAllNhaThau(){
		return nhaThauReponsitory.findAll();
	}
	
	public void createNhathau(NhaThauModel nhaThauModel) {
		nhaThauReponsitory.save(nhaThauModel);
	}
	
	public NhaThauModel getANhaThau(Integer id) {
		return nhaThauReponsitory.findById(id).get();
	}
	
	public NhaThauModel updateNhaThu(NhaThauModel nhaThauModel) {
		NhaThauModel nhaThauModel2 = nhaThauReponsitory.findById(nhaThauModel.getId()).get();
		nhaThauModel2=nhaThauModel;
		return nhaThauReponsitory.save(nhaThauModel2);
	}
	
	public void deleteNhaThau(Integer id) {
		nhaThauReponsitory.deleteById(id);
	}
}
