package ngn.api.sanpham.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngn.api.sanpham.models.SanPhamModel;
import ngn.api.sanpham.reponsetory.SanPhamResponsetory;

@Service
@Transactional
public class SanPhamService {
	@Autowired
	SanPhamResponsetory sanPhamResponsetory;
	
	public List<SanPhamModel> getAllSanPham(){
		return sanPhamResponsetory.findAll();
	}
	
	public List<SanPhamModel> getALL(String tensanpham,String loaiSanPham,String kyMaHieu,int offset,int limit){
		Pageable pageable = PageRequest.of(offset,limit);
		if(tensanpham.isEmpty()) {
			return sanPhamResponsetory.getPageNoName("", pageable);
		}else {
			return sanPhamResponsetory.getPageByName(tensanpham,loaiSanPham,kyMaHieu, pageable);
		}
	}
	
	public List<SanPhamModel> getSanPhamByChuDauTu(Integer idchudautu,Integer idHopDong,String tensanpham,String loaiSanPham,String kyMaHieu,Integer offset,Integer limit){
		Pageable pageable = PageRequest.of(offset, limit);
		if(idHopDong==-1) {
			List<SanPhamModel> listSP = new ArrayList<SanPhamModel>();
			if(!tensanpham.isEmpty() || !loaiSanPham.isEmpty() || !kyMaHieu.isEmpty()) {
				for(SanPhamModel sanPhamModel : sanPhamResponsetory.getPageByChuDauTu(idchudautu, pageable)) {
					if(sanPhamModel.getTensanpham().contains(tensanpham)||sanPhamModel.getLoaisanpham().contains(loaiSanPham)||sanPhamModel.getKymahieu().contains(kyMaHieu)) {
						listSP.add(sanPhamModel);
					}
				}
				return listSP;
			}else {
				return sanPhamResponsetory.getPageByChuDauTu(idchudautu, pageable);
			}
		}else {
			return getSanPhamByidHopDong(idHopDong, tensanpham, loaiSanPham, kyMaHieu, offset, limit);
		}
	}
	
	public Integer countSanPhamByIdChuDauTu(Integer idchudautu) {
		return sanPhamResponsetory.getCountSanPhamByChuDauTu(idchudautu).size();
	}
	
	public List<SanPhamModel> getSanPhamByidHopDong(Integer idHopDong,String tensanpham,String loaiSanPham,String kyMaHieu,Integer offset,Integer limit){
		Pageable pageable = PageRequest.of(offset, limit);
		List<SanPhamModel> listSP = new ArrayList<SanPhamModel>();
		if(!tensanpham.isEmpty() || !loaiSanPham.isEmpty() || !kyMaHieu.isEmpty()) {
			for(SanPhamModel sanPhamModel : sanPhamResponsetory.getListSanPhamByIdHopDong(idHopDong,pageable)) {
				if(sanPhamModel.getTensanpham().contains(tensanpham)||sanPhamModel.getLoaisanpham().contains(loaiSanPham)||sanPhamModel.getKymahieu().contains(kyMaHieu)) {
					listSP.add(sanPhamModel);
				}
			}
			return listSP;
		}else {
			return sanPhamResponsetory.getListSanPhamByIdHopDong(idHopDong,pageable);
		}
	}
	
	public List<SanPhamModel> getCountSanPhamByIdHopDong(Integer idHopDong){
		return sanPhamResponsetory.getCountSanPhamByIdHopDong(idHopDong);
	}
	
	public List<SanPhamModel> getSanPhamConBaoHanh(String tensanpham,String loaiSanPham,String kyMaHieu,int offset,int limit){
		Pageable pageable = PageRequest.of(offset,limit);
		List<SanPhamModel> listSanPhamConBaoHanh = new ArrayList<SanPhamModel>();
		if(tensanpham.isEmpty()) {
			for(SanPhamModel sanPhamModel : sanPhamResponsetory.getPageNoName("", pageable)) {
				if(tinhNgayHetHan(convertLongToLocalDate(sanPhamModel.getNgaybatdaubaohanh()), sanPhamModel.getThoigianbaohanh())==1) {
					listSanPhamConBaoHanh.add(sanPhamModel);
				}
			}
		}else {
			for(SanPhamModel sanPhamModel : sanPhamResponsetory.getPageByName(tensanpham,loaiSanPham,kyMaHieu, pageable)) {
				if(tinhNgayHetHan(convertLongToLocalDate(sanPhamModel.getNgaybatdaubaohanh()), sanPhamModel.getThoigianbaohanh())==1) {
					listSanPhamConBaoHanh.add(sanPhamModel);
				}
			}
		}
		
		return listSanPhamConBaoHanh;
	}
	
	public List<SanPhamModel> getAllSanPhamConBaoHanh(){
		List<SanPhamModel> listSanPham = new ArrayList<SanPhamModel>();
		for(SanPhamModel sanPhamModel : sanPhamResponsetory.findAll()) {
			if(tinhNgayHetHan(convertLongToLocalDate(sanPhamModel.getNgaybatdaubaohanh()), sanPhamModel.getThoigianbaohanh())==1) {
				listSanPham.add(sanPhamModel);
			}
		}
		return listSanPham;
	}
	
	public List<SanPhamModel>getAllSanPhamHetBaoHanh(){
		List<SanPhamModel> listSanPham = new ArrayList<SanPhamModel>();
		for(SanPhamModel sanPhamModel: sanPhamResponsetory.findAll()) {
			if(tinhNgayHetHan(convertLongToLocalDate(sanPhamModel.getNgaybatdaubaohanh()), sanPhamModel.getThoigianbaohanh())==-1) {
				listSanPham.add(sanPhamModel);
			}
		}
		return listSanPham;
	}
	
	public List<SanPhamModel> getSanPhamHetBaoHanh(String tensanpham,String loaiSanPham,String kyMaHieu,int offset,int limit){
		Pageable pageable = PageRequest.of(offset,limit);
		List<SanPhamModel> listSanPhamHetBaoHanh = new ArrayList<SanPhamModel>();
		for(SanPhamModel sanPhamModel: sanPhamResponsetory.getPageByName(tensanpham, loaiSanPham, kyMaHieu, pageable)) {
			if(tinhNgayHetHan(convertLongToLocalDate(sanPhamModel.getNgaybatdaubaohanh()), sanPhamModel.getThoigianbaohanh())==-1) {
				listSanPhamHetBaoHanh.add(sanPhamModel);
			}
		}
		
		return listSanPhamHetBaoHanh;
	}
	
	public SanPhamModel getASanPham(Integer id) {
		return sanPhamResponsetory.findById(id).get();
	}
	
	public SanPhamModel addSanPham(SanPhamModel sanPhamModel) {
		return sanPhamResponsetory.save(sanPhamModel);
	}
	
	public SanPhamModel updateSanPham(SanPhamModel sanPhamModel) {
		SanPhamModel sanPhamModel2 = sanPhamResponsetory.findById(sanPhamModel.getId()).get();
		sanPhamModel2=sanPhamModel;
		return sanPhamResponsetory.save(sanPhamModel2);
	}
	
	public void deleteSanPham(Integer id) {
		sanPhamResponsetory.deleteById(id);
	}

	private Integer tinhNgayHetHan(LocalDate date,Integer thoiGianBaoHanh) {
		LocalDate ngayBatDauBaoHanh = date;
		
		LocalDate ngayKetThucBaoHanh = date.plusMonths(thoiGianBaoHanh);
		
		LocalDate ngayHienTai = LocalDate.now();
		
		if(ngayKetThucBaoHanh.isBefore(ngayHienTai)) {
			return -1;
		}else if(ngayKetThucBaoHanh.isAfter(ngayHienTai)) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	private LocalDate convertLongToLocalDate(long longdate) {
		Instant instant = Instant.ofEpochMilli(longdate);
		
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}
	
}
