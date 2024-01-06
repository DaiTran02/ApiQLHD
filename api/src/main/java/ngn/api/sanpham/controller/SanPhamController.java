package ngn.api.sanpham.controller;

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

import ngn.api.hopdong.reponse.ListHopDongReponse;
import ngn.api.sanpham.models.SanPhamModel;
import ngn.api.sanpham.reponse.ListSanPhamReponse;
import ngn.api.sanpham.reponse.SanPhamReponse;
import ngn.api.sanpham.services.SanPhamService;

@RestController
@ResponseBody
public class SanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/sanpham/list")
	public ListSanPhamReponse getAllSanPham(@Param("tensanpham") String tensanpham,@Param("loaisanpham") String loaisanpham,@Param("kymahieu") String kymahieu,@RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "1000")int limit) {
		ListSanPhamReponse listSanPhamReponse = new ListSanPhamReponse();
		try {
			List<SanPhamModel> list = sanPhamService.getALL(tensanpham,loaisanpham,kymahieu,offset,limit);
			listSanPhamReponse.setStatus(200);
			listSanPhamReponse.setSoluong(sanPhamService.getAllSanPham().size());
			listSanPhamReponse.setMessage("OK");
			listSanPhamReponse.setData(list);
			
			return listSanPhamReponse;
		} catch (Exception e) {
			listSanPhamReponse.setStatus(400);
			listSanPhamReponse.setMessage("KO OK");
			listSanPhamReponse.setData(null);
			
			return listSanPhamReponse;
		}
	}
	
	@GetMapping("/sanpham/list/chudautu/{id}")
	public ListSanPhamReponse getSanPhamByChuDauTu(@PathVariable("id")Integer id,@RequestParam(defaultValue = "-1") Integer idhopdong,@Param("tensanpham") String tensanpham,@Param("loaisanpham") String loaisanpham,@Param("kymahieu") String kymahieu,@RequestParam(defaultValue = "0")Integer offset,@RequestParam(defaultValue = "1000")Integer limit) {
		ListSanPhamReponse listSanPhamReponse = new ListSanPhamReponse();
		try {
			List<SanPhamModel> list = sanPhamService.getSanPhamByChuDauTu(id,idhopdong,tensanpham,loaisanpham,kymahieu,offset,limit);
			listSanPhamReponse.setStatus(200);
			listSanPhamReponse.setSoluong(sanPhamService.countSanPhamByIdChuDauTu(id));
			listSanPhamReponse.setMessage("OK");
			listSanPhamReponse.setData(list);
			
			return listSanPhamReponse;
		} catch (Exception e) {
			listSanPhamReponse.setStatus(400);
			listSanPhamReponse.setSoluong(0);
			listSanPhamReponse.setMessage("KO OK");
			listSanPhamReponse.setData(null);
			
			return listSanPhamReponse;
		}
	}
	
	@GetMapping("/listsanphambyid/hopdong/{id}")
	public ListSanPhamReponse getSanPhamByidHopDong(@PathVariable("id")Integer idHopDong,@Param("tensanpham") String tensanpham,@Param("loaisanpham") String loaisanpham,@Param("kymahieu") String kymahieu,@RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "1000")int limit) {
		ListSanPhamReponse listSanPhamReponse = new ListSanPhamReponse();
		try {
			List<SanPhamModel> list = sanPhamService.getSanPhamByidHopDong(idHopDong,tensanpham,loaisanpham,kymahieu,offset,limit);
			listSanPhamReponse.setStatus(200);
			listSanPhamReponse.setSoluong(sanPhamService.getCountSanPhamByIdHopDong(idHopDong).size());
			listSanPhamReponse.setMessage("OK");
			listSanPhamReponse.setData(list);
		} catch (Exception e) {
			listSanPhamReponse.setStatus(500);
			listSanPhamReponse.setSoluong(0);
			listSanPhamReponse.setMessage("Not ok");
			listSanPhamReponse.setData(null);
		}
		
		return listSanPhamReponse;
	}
	
	@GetMapping("/listsanpham/conbaohanh")
	public ListSanPhamReponse getSanPhamConBaoHanh(@RequestParam(defaultValue = "")String tensanpham,@RequestParam(defaultValue = "")String loaisanpham,@RequestParam(defaultValue = "")String kymahieu,@RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "1000")int limit) {
		ListSanPhamReponse listSanPhamReponse = new ListSanPhamReponse();
		try {
			List<SanPhamModel> list = sanPhamService.getSanPhamConBaoHanh(tensanpham,loaisanpham,kymahieu,offset,limit);
			listSanPhamReponse.setStatus(200);
			listSanPhamReponse.setSoluong(sanPhamService.getAllSanPhamConBaoHanh().size());
			listSanPhamReponse.setMessage("OK");
			listSanPhamReponse.setData(list);
		} catch (Exception e) {
			listSanPhamReponse.setStatus(500);
			listSanPhamReponse.setMessage("Not ok");
			listSanPhamReponse.setData(null);
		}
		
		return listSanPhamReponse;
	}
	
	@GetMapping("/listsanpham/hetbaohanh")
	public ListSanPhamReponse getSanPhamHetBaoHanh(@RequestParam(defaultValue = "")String tensanpham,@RequestParam(defaultValue = "")String loaisanpham,@RequestParam(defaultValue = "")String kymahieu,@RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "1000")int limit) {
		ListSanPhamReponse listSanPhamReponse = new ListSanPhamReponse();
		try {
			List<SanPhamModel> list = sanPhamService.getSanPhamHetBaoHanh(tensanpham,loaisanpham,kymahieu,offset,limit);
			listSanPhamReponse.setStatus(200);
			listSanPhamReponse.setSoluong(sanPhamService.getAllSanPhamHetBaoHanh().size());
			listSanPhamReponse.setMessage("OK");
			listSanPhamReponse.setData(list);
		} catch (Exception e) {
			listSanPhamReponse.setStatus(500);
			listSanPhamReponse.setMessage("Not ok");
			listSanPhamReponse.setData(null);
		}
		
		return listSanPhamReponse;
	}
 	
	@GetMapping("/sanpham/a/{id}")
	public SanPhamReponse getASanPham(@PathVariable("id")Integer id) {
		SanPhamReponse sanPhamReponse = new SanPhamReponse();
		try {
			SanPhamModel sanPhamModel = sanPhamService.getASanPham(id);
			
			sanPhamReponse.setStatus(200);
			sanPhamReponse.setMessage("OK");
			sanPhamReponse.setData(sanPhamModel);
			return sanPhamReponse;
		} catch (Exception e) {
			return new SanPhamReponse();
		}
	}
	
	@PostMapping("/sanpham/add")
	public SanPhamReponse addSanPham(@RequestBody SanPhamModel sanPhamModel) {
		SanPhamReponse sanPhamReponse = new SanPhamReponse();
		try {
			SanPhamModel sanPhamModel2 = sanPhamService.addSanPham(sanPhamModel);
			sanPhamReponse.setStatus(200);
			sanPhamReponse.setMessage("OK");
			sanPhamReponse.setData(sanPhamModel2);
		} catch (Exception e) {
			sanPhamReponse.setStatus(500);
			sanPhamReponse.setMessage("Ko OK");
			sanPhamReponse.setData(new SanPhamModel());
		}
		return sanPhamReponse;
	}
	
	@PutMapping("/sanpham/update/{id}")
	public SanPhamReponse updateSanPham(@PathVariable("id")Integer id ,@RequestBody SanPhamModel sanPhamModel) {
		SanPhamReponse sanPhamReponse = new SanPhamReponse();
		try {
			sanPhamModel.setId(id);
			SanPhamModel sanPhamModel2 = sanPhamService.updateSanPham(sanPhamModel);
			sanPhamReponse.setStatus(200);
			sanPhamReponse.setMessage("OK");
			sanPhamReponse.setData(sanPhamModel2);
			return sanPhamReponse;
		} catch (Exception e) {
			return new SanPhamReponse();
		}
	}
	
	@DeleteMapping("/sanpham/delete/{id}")
	public ResponseEntity<SanPhamReponse> deleteSanPham(@PathVariable("id")Integer id){
		try {
			sanPhamService.deleteSanPham(id);
			SanPhamReponse sanPhamReponse = new SanPhamReponse();
			sanPhamReponse.setStatus(200);
			sanPhamReponse.setMessage("OK");
			sanPhamReponse.setData(null);
			return new ResponseEntity<SanPhamReponse>(sanPhamReponse,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SanPhamReponse>(new SanPhamReponse(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
