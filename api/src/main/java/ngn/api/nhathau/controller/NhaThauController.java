package ngn.api.nhathau.controller;

import java.util.ArrayList;
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

import ngn.api.nhathau.models.NhaThauModel;
import ngn.api.nhathau.reponse.ListNhaThauReponse;
import ngn.api.nhathau.reponse.NhaThauReponse;
import ngn.api.nhathau.responsitory.NhaThauReponsitory;
import ngn.api.nhathau.service.NhaThauService;

@RestController
@ResponseBody
public class NhaThauController {
	
	@Autowired
	NhaThauService nhaThauService;

	@GetMapping("/nhathau/list")
	public ListNhaThauReponse getallNhaThau() {
		ListNhaThauReponse listNhaThauReponse = new ListNhaThauReponse();
		try {
			listNhaThauReponse.setStatus(200);
			listNhaThauReponse.setMessager("Ok");
			listNhaThauReponse.setData(nhaThauService.getAllNhaThau());
		} catch (Exception e) {
			listNhaThauReponse.setStatus(500);
			listNhaThauReponse.setMessager("Ko ok");
			listNhaThauReponse.setData(new ArrayList<NhaThauModel>());
		}
		
		return listNhaThauReponse;
	}
	
	@GetMapping("/nhathau/{id}")
	public NhaThauReponse getANhaThau(@PathVariable("id")Integer id) {
		NhaThauReponse nhaThauReponse = new NhaThauReponse();
		try {
			nhaThauReponse.setStatus(200);
			nhaThauReponse.setMessager("Ok");
			nhaThauReponse.setData(nhaThauService.getANhaThau(id));
		} catch (Exception e) {
			nhaThauReponse.setStatus(500);
			nhaThauReponse.setMessager("Ko Ok");
			nhaThauReponse.setData(new NhaThauModel());
		}
		
		return nhaThauReponse;
	}
	
	@PostMapping("/nhathau/new")
	public NhaThauReponse createNhaThau(@RequestBody NhaThauModel nhaThauModel) {
		NhaThauReponse nhaThauReponse = new NhaThauReponse();
		try {
			nhaThauService.createNhathau(nhaThauModel);
			nhaThauReponse.setStatus(200);
			nhaThauReponse.setMessager("Ok");
			nhaThauReponse.setData(new NhaThauModel());
		} catch (Exception e) {
			nhaThauReponse.setStatus(500);
			nhaThauReponse.setMessager("Ko Ok");
			nhaThauReponse.setData(new NhaThauModel());
		}
		return nhaThauReponse;
	}
	
	@PutMapping("/nhathau/update/{id}")
	public NhaThauReponse updateNhathau(@PathVariable("id") Integer id,@RequestBody NhaThauModel nhaThauModel) {
		NhaThauReponse nhaThauReponse = new NhaThauReponse();
		try {
			nhaThauModel.setId(id);
			nhaThauReponse.setStatus(200);
			nhaThauReponse.setMessager("Ok");
			nhaThauReponse.setData(nhaThauService.updateNhaThu(nhaThauModel));
		} catch (Exception e) {
			nhaThauReponse.setStatus(200);
			nhaThauReponse.setMessager("Ok");
			nhaThauReponse.setData(new NhaThauModel());
		}
		
		return nhaThauReponse;
	}
	
	@DeleteMapping("/nhathau/delete/{id}")
	public ListNhaThauReponse deleteNhaThau(@PathVariable("id")Integer id) {
		ListNhaThauReponse listNhaThauReponse = new ListNhaThauReponse();
		try {
			nhaThauService.deleteNhaThau(id);
			listNhaThauReponse.setStatus(200);
			listNhaThauReponse.setMessager("Ok");
			listNhaThauReponse.setData(nhaThauService.getAllNhaThau());
		} catch (Exception e) {
			listNhaThauReponse.setStatus(500);
			listNhaThauReponse.setMessager("Ko Ok");
			listNhaThauReponse.setData(Collections.emptyList());
		}
		
		return listNhaThauReponse;
	}
	
	
}
