package ngn.api.hopdong.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ngn.api.hopdong.models.PhieuBaoHanhModel;
import ngn.api.hopdong.reponse.ListPhieuBaoHanhReponse;
import ngn.api.hopdong.reponse.PhieuBaoHanhReponse;
import ngn.api.hopdong.services.PhieuBaoHanhService;

@RestController
@ResponseBody
public class PhieuBaoHanhController {
	
	@Autowired
	PhieuBaoHanhService phieuBaoHanhService;
	
	@GetMapping("/phieubaohanh/hopdong/{id}")
	public PhieuBaoHanhReponse getMotPhieuBaoHanhByIdHopDong(@PathVariable("id")Integer idhopdong) {
		PhieuBaoHanhReponse phieuBaoHanhReponse = new PhieuBaoHanhReponse();
		try {
			phieuBaoHanhReponse.setStatus(200);
			phieuBaoHanhReponse.setMessage("OK");
			phieuBaoHanhReponse.setData(phieuBaoHanhService.getDataPhieuBaoHanhByIdHopDong(idhopdong));
			return phieuBaoHanhReponse;
		} catch (Exception e) {
			phieuBaoHanhReponse.setStatus(500);
			phieuBaoHanhReponse.setMessage("KO OK");
			phieuBaoHanhReponse.setData((PhieuBaoHanhModel) Collections.emptyList());
			return phieuBaoHanhReponse;
		}
	}
	
	@GetMapping("/phieubaohanh/{id}")
	public PhieuBaoHanhReponse getMotPhieuBaoHanh(@PathVariable("id")Integer id) {
		PhieuBaoHanhReponse phieuBaoHanhReponse = new PhieuBaoHanhReponse();
		try {
			phieuBaoHanhReponse.setStatus(200);
			phieuBaoHanhReponse.setMessage("OK");
			phieuBaoHanhReponse.setData(phieuBaoHanhService.getDataPhieuBaoHanhById(id));
			return phieuBaoHanhReponse;
		} catch (Exception e) {
			phieuBaoHanhReponse.setStatus(500);
			phieuBaoHanhReponse.setMessage("KO OK");
			phieuBaoHanhReponse.setData((PhieuBaoHanhModel) Collections.emptyList());
			return phieuBaoHanhReponse;
		}
	}
	
	@PostMapping("/phieubaohanh/add")
	public PhieuBaoHanhReponse themMotPhieuBaoHanh(@RequestBody PhieuBaoHanhModel phieuBaoHanhModel) {
		PhieuBaoHanhReponse phieuBaoHanhReponse = new PhieuBaoHanhReponse();
		try {
			phieuBaoHanhService.themPhieuBaoHanh(phieuBaoHanhModel);
			phieuBaoHanhReponse.setStatus(200);
			phieuBaoHanhReponse.setMessage("OK");
			phieuBaoHanhReponse.setData(phieuBaoHanhService.getDataPhieuBaoHanhById(phieuBaoHanhModel.getId()));
			return phieuBaoHanhReponse;
		} catch (Exception e) {
			phieuBaoHanhReponse.setStatus(500);
			phieuBaoHanhReponse.setMessage("KO OK");
			phieuBaoHanhReponse.setData(null);
			return phieuBaoHanhReponse;
		}
	}
	
	@GetMapping("/phieubaohanh/list")
	public ListPhieuBaoHanhReponse getListPhieuBaoHanh() {
		ListPhieuBaoHanhReponse listPhieuBaoHanhReponse = new ListPhieuBaoHanhReponse();
		try {
			listPhieuBaoHanhReponse.setStatus(200);
			listPhieuBaoHanhReponse.setMessage("OK");
			listPhieuBaoHanhReponse.setData(phieuBaoHanhService.getListPhieuBaoHanh());
			return listPhieuBaoHanhReponse;
		} catch (Exception e) {
			listPhieuBaoHanhReponse.setStatus(200);
			listPhieuBaoHanhReponse.setMessage("OK");
			listPhieuBaoHanhReponse.setData(Collections.emptyList());
			return listPhieuBaoHanhReponse;
		}
	}
	
	@PutMapping("/phieubaohanh/update/{id}")
	public PhieuBaoHanhReponse updatePhieu(@PathVariable("id")Integer id,@RequestBody PhieuBaoHanhModel phieuBaoHanhModel) {
		PhieuBaoHanhReponse phieuBaoHanhReponse = new PhieuBaoHanhReponse();
		try {
			phieuBaoHanhModel.setId(id);
			phieuBaoHanhService.updatePhieu(phieuBaoHanhModel);
			phieuBaoHanhReponse.setStatus(200);
			phieuBaoHanhReponse.setMessage("OK");
			phieuBaoHanhReponse.setData(new PhieuBaoHanhModel());
			return phieuBaoHanhReponse;
		} catch (Exception e) {
			phieuBaoHanhReponse.setStatus(500);
			phieuBaoHanhReponse.setMessage("KO OK");
			phieuBaoHanhReponse.setData(null);
			return phieuBaoHanhReponse;
		}
	}
	
	@DeleteMapping("/phieubaohanh/delete/{id}")
	public PhieuBaoHanhReponse deletePhieu(@PathVariable("id") Integer id) {
		PhieuBaoHanhReponse phieuBaoHanhReponse = new PhieuBaoHanhReponse();
		try {
			phieuBaoHanhService.xoaPhieu(id);
			phieuBaoHanhReponse.setStatus(200);
			phieuBaoHanhReponse.setMessage("OK");
			phieuBaoHanhReponse.setData(new PhieuBaoHanhModel());
			return phieuBaoHanhReponse;
		} catch (Exception e) {
			phieuBaoHanhReponse.setStatus(500);
			phieuBaoHanhReponse.setMessage("KO OK");
			phieuBaoHanhReponse.setData(null);
			return phieuBaoHanhReponse;
		}
	}

}
