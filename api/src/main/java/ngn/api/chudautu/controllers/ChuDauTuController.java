package ngn.api.chudautu.controllers;

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

import ngn.api.chudautu.models.ChuDauTuModel;
import ngn.api.chudautu.response.ChuDauTuResponse;
import ngn.api.chudautu.response.ListChuDauTuResponse;
import ngn.api.chudautu.services.ChuDauTuService;

@RestController
@ResponseBody
public class ChuDauTuController {
	@Autowired
	ChuDauTuService chuDauTuService;
	
//	@GetMapping("/chudautu/list")
//	public ListChuDauTuResponse getListChuDauTu() {
//		try {
//			List<ChuDauTuModel> list = chuDauTuService.getAllChuDauTu();
//			ListChuDauTuResponse chuDauTuResponse = new ListChuDauTuResponse();
//			chuDauTuResponse.setStatus(200);
//			chuDauTuResponse.setMessage("Ok");
//			chuDauTuResponse.setData(list);
//			return chuDauTuResponse;
//		} catch (Exception e) {
//			ListChuDauTuResponse chuDauTuResponse = new ListChuDauTuResponse();
//			chuDauTuResponse.setStatus(999);
//			chuDauTuResponse.setMessage("Ko ok");
//			chuDauTuResponse.setData(null);
//			return chuDauTuResponse;
//		}
//		
//	}
	
	@GetMapping("/chudautu/list")
	public ListChuDauTuResponse getPaniga(@RequestParam(defaultValue = "false")boolean check, @RequestParam(defaultValue = "0") int offset,@RequestParam(defaultValue = "1000") int limit,@Param("tenchudautu") String tenchudautu,@Param("machudautu")String machudautu) {
		try {
			List<ChuDauTuModel> list = chuDauTuService.getChuDauTuPanigation(check,tenchudautu,machudautu,offset, limit);
			ListChuDauTuResponse chuDauTuResponse = new ListChuDauTuResponse();
			chuDauTuResponse.setStatus(200);
			chuDauTuResponse.setSoluong(chuDauTuService.getAllChuDauTu().size());
			chuDauTuResponse.setMessage("Ok");
			chuDauTuResponse.setData(list);
			return chuDauTuResponse;
		} catch (Exception e) {
			ListChuDauTuResponse chuDauTuResponse = new ListChuDauTuResponse();
			chuDauTuResponse.setStatus(999);
			chuDauTuResponse.setMessage("Ko ok");
			chuDauTuResponse.setData(null);
			return chuDauTuResponse;
		}
	}
	
	@GetMapping("/chudautu/a/{id}")
	public ChuDauTuResponse getAChuDauTu(@PathVariable("id")Integer id) {
		ChuDauTuResponse chuDauTuResponse = new ChuDauTuResponse();
		try {
			ChuDauTuModel chuDauTuModel = chuDauTuService.getAChuDauTu(id);
			chuDauTuResponse.setStatus(200);
			chuDauTuResponse.setMessage("OK");
			chuDauTuResponse.setData(chuDauTuModel);
			return chuDauTuResponse;
		} catch (Exception e) {
			chuDauTuResponse.setStatus(900);
			chuDauTuResponse.setMessage("Ko ok");
			chuDauTuResponse.setData(null);
			return chuDauTuResponse;
		}
	}
	
	@PostMapping("/chudautu/add")
	public ChuDauTuResponse addChuDauTu(@RequestBody ChuDauTuModel chuDauTuModel) {
		ChuDauTuResponse chuDauTuResponse = new ChuDauTuResponse();
		try {
			ChuDauTuModel chuDauTuModel2 = chuDauTuService.addChuDauTu(chuDauTuModel);
			
			chuDauTuResponse.setStatus(200);
			chuDauTuResponse.setMessage("Ok con de");
			chuDauTuResponse.setData(chuDauTuModel2);
			return chuDauTuResponse;
		} catch (Exception e) {
			chuDauTuResponse.setStatus(300);
			chuDauTuResponse.setMessage("Ko ok ");
			chuDauTuResponse.setData(null);
			return chuDauTuResponse;
		}
	}
	
	
	@PutMapping("/chudautu/update/{id}")
	public ChuDauTuResponse updateChuDauTu(@PathVariable("id")Integer idChuDauTu,@RequestBody ChuDauTuModel chuDauTuModel) {
		ChuDauTuResponse chuDauTuResponse = new ChuDauTuResponse();
		try {
			chuDauTuModel.setId(idChuDauTu);
			ChuDauTuModel chuDauTuModel2 = chuDauTuService.updateChuDauTu(chuDauTuModel);
			
			chuDauTuResponse.setStatus(200);
			chuDauTuResponse.setMessage("Ok");
			chuDauTuResponse.setData(chuDauTuModel2);
			return chuDauTuResponse;
		} catch (Exception e) {
			chuDauTuResponse.setStatus(999);
			chuDauTuResponse.setMessage("Ko ok");
			chuDauTuResponse.setData(null);
			return chuDauTuResponse;
		}
	}
	
	@DeleteMapping("/chudautu/delete/{id}")
	public ResponseEntity<ChuDauTuResponse>delete(@PathVariable("id") Integer idChuDauTu){
		ChuDauTuResponse chuDauTuResponse = new ChuDauTuResponse();
		try {
			chuDauTuService.delete(idChuDauTu);
			chuDauTuResponse.setStatus(200);
			chuDauTuResponse.setMessage("OK");
			chuDauTuResponse.setData(null);
			return new ResponseEntity<>(chuDauTuResponse,HttpStatus.OK);
		} catch (Exception e) {
			chuDauTuResponse.setStatus(900);
			chuDauTuResponse.setMessage("ko ok lam");
			chuDauTuResponse.setData(null);
			return new ResponseEntity<>(chuDauTuResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}


















