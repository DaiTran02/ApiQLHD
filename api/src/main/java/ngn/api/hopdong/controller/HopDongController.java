package ngn.api.hopdong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.experimental.PackagePrivate;
import ngn.api.hopdong.models.HopDongModel;
import ngn.api.hopdong.reponse.HopDongReponse;
import ngn.api.hopdong.reponse.ListHopDongReponse;
import ngn.api.hopdong.services.HopDongService;

@RestController
@ResponseBody
public class HopDongController {
	@Autowired
	HopDongService hopDongService;
	
	@GetMapping("/hopdong/list")
	public ListHopDongReponse getListHopDong(@RequestParam(defaultValue = "false")boolean checkList,@Param("sohopdong") String sohopdong,@Param("goithau") String goithau,@Param("nhaphanphoi") String nhaphanphoi,@RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "1000")int limit) {
		ListHopDongReponse listHopDongReponse = new ListHopDongReponse();
		try {
			List<HopDongModel> list = hopDongService.getPageHopDong(checkList,sohopdong,goithau,nhaphanphoi,offset,limit);
			listHopDongReponse.setStatus(200);
			listHopDongReponse.setMessage("OK");
			listHopDongReponse.setSoluong(hopDongService.getAllHopDong().size());
			listHopDongReponse.setData(list);
			return listHopDongReponse;
		} catch (Exception e) {
			listHopDongReponse.setStatus(500);
			listHopDongReponse.setMessage("KO OK");
			listHopDongReponse.setData(null);
			return listHopDongReponse;
		}
	}
	
	@GetMapping("/hopdong/list/{id}")
	public ListHopDongReponse getListHopDongByIdChuDauTu(@RequestParam(defaultValue = "false")boolean check, @PathVariable("id")int idChuDauTu,@Param("sohopdong")String sohopdong,@Param("goithau")String goithau,@Param("nhaphanphoi")String nhaphanphoi,@RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "1000")int limit) {
		ListHopDongReponse listHopDongReponse = new ListHopDongReponse();
		try {
			List<HopDongModel> list = hopDongService.getListHopDongByChuDauTu(check,idChuDauTu,sohopdong,goithau,nhaphanphoi, offset, limit);
			listHopDongReponse.setStatus(200);
			listHopDongReponse.setSoluong(hopDongService.countHopDongByChuDauTu(idChuDauTu).size());
			listHopDongReponse.setMessage("OK");
			listHopDongReponse.setData(list);
			return listHopDongReponse;
		} catch (Exception e) {
			listHopDongReponse.setStatus(500);
			listHopDongReponse.setMessage("KO OK");
			listHopDongReponse.setSoluong(0);
			listHopDongReponse.setData(null);
			return listHopDongReponse;
		}
	}
	
	@GetMapping("/hopdong/xuatphieu")
	public ListHopDongReponse getListHopDongOnPhieu(@RequestParam(defaultValue = "false")boolean check) {
		ListHopDongReponse listHopDongReponse = new ListHopDongReponse();
		try {
			List<HopDongModel> list = hopDongService.getListHopDongOnPhieu(check);
			listHopDongReponse.setStatus(200);
			listHopDongReponse.setSoluong(list.size());
			listHopDongReponse.setMessage("OK");
			listHopDongReponse.setData(list);
			return listHopDongReponse;
		} catch (Exception e) {
			listHopDongReponse.setStatus(500);
			listHopDongReponse.setMessage("KO OK");
			listHopDongReponse.setData(null);
			return listHopDongReponse;
		}
	}
	
	@PutMapping("/hopdong/xuatphieu/{id}")
	public HopDongReponse updateStatusPhieu(@PathVariable("id")Integer idHopDong,@RequestParam(defaultValue = "false")boolean check) {
		HopDongReponse hopDongReponse = new HopDongReponse();
		try {
			HopDongModel hopDongModel = hopDongService.getAHopDong(idHopDong);
			hopDongModel.setCheckxuatphieu(check);
			HopDongModel updateModel = hopDongService.updateHopDong(hopDongModel);
			hopDongReponse.setStatus(200);
			hopDongReponse.setMessage("OK");
			hopDongReponse.setData(updateModel);
			return hopDongReponse;
		} catch (Exception e) {
			hopDongReponse.setStatus(500);
			hopDongReponse.setMessage("OK");
			hopDongReponse.setData(null);
			return hopDongReponse;
		}
		
	}
	
	
	@GetMapping("/hopdong/a/{id}")
	public HopDongReponse getAHopDong(@PathVariable("id") Integer idHopDong) {
		HopDongReponse hopDongReponse = new HopDongReponse();
		try {
			HopDongModel hopDongModel = hopDongService.getAHopDong(idHopDong);
			hopDongReponse.setStatus(200);
			hopDongReponse.setMessage("OK");
			hopDongReponse.setData(hopDongModel);
			return hopDongReponse;
		} catch (Exception e) {
			hopDongReponse.setStatus(500);
			hopDongReponse.setMessage("KO OK");
			hopDongReponse.setData(null);
			return hopDongReponse;
		}
	}
	
	@PostMapping("/hopdong/add")
	public HopDongReponse addHopDong(@RequestBody  HopDongModel hopDongModel) {
		HopDongReponse hopDongReponse = new HopDongReponse();
		try {
			HopDongModel hopDongModel2 = hopDongService.addHopDongMoi(hopDongModel);
			hopDongReponse.setStatus(200);
			hopDongReponse.setMessage("OK");
			hopDongReponse.setData(hopDongModel2);
			return hopDongReponse;
			
		} catch (Exception e) {
			hopDongReponse.setStatus(500);
			hopDongReponse.setMessage("KO OK");
			hopDongReponse.setData(null);
			return hopDongReponse;
		}
	}
	
	@PutMapping("/hopdong/update/{id}")
	public HopDongReponse updateHopDong(@PathVariable("id") Integer idHopDong,@RequestBody HopDongModel hopDongModel) {
		HopDongReponse hopDongReponse = new HopDongReponse();
		try {
			hopDongModel.setId(idHopDong);
			HopDongModel updateModel = hopDongService.updateHopDong(hopDongModel);
			hopDongReponse.setStatus(200);
			hopDongReponse.setMessage("OK");
			hopDongReponse.setData(updateModel);
			return hopDongReponse;
		} catch (Exception e) {
			hopDongReponse.setStatus(500);
			hopDongReponse.setMessage("OK");
			hopDongReponse.setData(null);
			return hopDongReponse;
		}
	}
	
	@DeleteMapping("/hopdong/delete/{id}")
	public ResponseEntity<HopDongReponse> deleteHopDong(@PathVariable("id") Integer idHopDong){
		HopDongReponse hopDongReponse = new HopDongReponse();
		try {
			hopDongService.deleteHopDong(idHopDong);
			hopDongReponse.setStatus(200);
			hopDongReponse.setMessage("Ok");
			hopDongReponse.setData(null);
			
			return new ResponseEntity<HopDongReponse>(hopDongReponse,HttpStatus.OK);
		} catch (Exception e) {
			hopDongReponse.setStatus(500);
			hopDongReponse.setMessage("KO Ok");
			hopDongReponse.setData(null);
			
			return new ResponseEntity<HopDongReponse>(hopDongReponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
