package ngn.api.hopdong.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngn.api.hopdong.models.HopDongModel;
import ngn.api.hopdong.reponsitory.HopDongReponsetory;

@Service
@Transactional
public class HopDongService {

	@Autowired
	HopDongReponsetory hopDongReponsetory;

	public List<HopDongModel> getAllHopDong(){
		return hopDongReponsetory.findAll();
	}

	public List<HopDongModel> getPageHopDong(boolean checkGrid,String sohopdong,String goithau,String nhaphanphoi,int offset,int limit){
		Pageable page = PageRequest.of(offset,limit);
		if(checkGrid==true) {
			return hopDongReponsetory.findAll();
		}
		return hopDongReponsetory.getlistpagebyname(sohopdong,goithau,nhaphanphoi,page);

	}

	public List<HopDongModel> getListHopDongByChuDauTu(boolean check,int idchudautu,String sohopdong,String goithau,String nhaphanphoi,int offset,int limit){
		Pageable page = PageRequest.of(offset,limit);
		List<HopDongModel> listHopDong = new ArrayList<HopDongModel>();
		
		if(check==true) {
			return hopDongReponsetory.getListHopDongByChuDauTu(idchudautu, page);
		}
		
		if(!(sohopdong==null)) {
			if(!sohopdong.isEmpty() || !goithau.isEmpty() || !nhaphanphoi.isEmpty()) {
				for(HopDongModel hopDongModel : hopDongReponsetory.getListHopDongByChuDauTu(idchudautu, page)) {
					if(hopDongModel.getSohopdong().contains(sohopdong)||hopDongModel.getGoithau().contains(goithau)||hopDongModel.getNhaphanphoi().contains(nhaphanphoi)) {
						listHopDong.add(hopDongModel);
					}
				}
				return listHopDong;
				
			}else {
				return hopDongReponsetory.getListHopDongByChuDauTu(idchudautu, page);
			}
		}else {
			return hopDongReponsetory.getListHopDongByChuDauTu(idchudautu, page);
		}
	}
	
	public List<HopDongModel> countHopDongByChuDauTu(Integer idchudautu){
		return hopDongReponsetory.getAllHopDongByChuDauTU(idchudautu);
	}
	
	public List<HopDongModel> getListHopDongOnPhieu(Boolean checkPhieu){
		return hopDongReponsetory.getListHopDongOnPhieu(checkPhieu);
	}

	public HopDongModel getAHopDong(Integer id) {
		return hopDongReponsetory.findById(id).get();
	}

	public HopDongModel addHopDongMoi(HopDongModel hopDongModel) {
		return hopDongReponsetory.save(hopDongModel);
	}

	public HopDongModel updateHopDong(HopDongModel hopDongModel) {
		HopDongModel hopDongModel2 = hopDongReponsetory.findById(hopDongModel.getId()).get();
		hopDongModel2=hopDongModel;
		return hopDongReponsetory.save(hopDongModel2);
	}

	public void deleteHopDong(Integer id) {
		hopDongReponsetory.deleteById(id);
	}
	
	//scheduling task
//	@Scheduled(fixedDelay = 1000)
//	public void schedunlingTest() {
//		System.out.println("Test ne:: "+System.currentTimeMillis()/1000);
//	}

}
