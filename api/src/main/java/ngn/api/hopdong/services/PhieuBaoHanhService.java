package ngn.api.hopdong.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngn.api.hopdong.models.PhieuBaoHanhModel;
import ngn.api.hopdong.reponsitory.PhieuBaoHanhReponsetory;

@Service
@Transactional
public class PhieuBaoHanhService {
	
	@Autowired
	PhieuBaoHanhReponsetory phieuBaoHanhReponsetory;
	
	public PhieuBaoHanhModel getDataPhieuBaoHanhByIdHopDong(Integer idhopdong) {
		return phieuBaoHanhReponsetory.getDataPhieuBaoHanh(idhopdong);
	}
	
	public PhieuBaoHanhModel getDataPhieuBaoHanhById(Integer idPhieu) {
		return phieuBaoHanhReponsetory.findById(idPhieu).get();
	}
	
	public void themPhieuBaoHanh(PhieuBaoHanhModel phieuBaoHanhModel) {
		phieuBaoHanhReponsetory.save(phieuBaoHanhModel);
	}
	
	public List<PhieuBaoHanhModel> getListPhieuBaoHanh(){
		return phieuBaoHanhReponsetory.getDataPhieuKoIdHopDong(-1);
	}
	
	public void updatePhieu(PhieuBaoHanhModel phieuBaoHanhModel) {
		PhieuBaoHanhModel phieuBaoHanhModel2 = getDataPhieuBaoHanhById(phieuBaoHanhModel.getId());
		phieuBaoHanhModel2.setTenlienhe(phieuBaoHanhModel.getTenlienhe());
		phieuBaoHanhModel2.setSodienthoai(phieuBaoHanhModel.getSodienthoai());
		phieuBaoHanhModel2.setEmail(phieuBaoHanhModel.getEmail());
		phieuBaoHanhModel2.setDiachibaohanh(phieuBaoHanhModel.getDiachibaohanh());
		phieuBaoHanhModel2.setIdhopdong(phieuBaoHanhModel.getIdhopdong());
		
		phieuBaoHanhReponsetory.save(phieuBaoHanhModel2);
	}
	
	public void xoaPhieu(Integer id) {
		phieuBaoHanhReponsetory.deleteById(id);
	}

}
