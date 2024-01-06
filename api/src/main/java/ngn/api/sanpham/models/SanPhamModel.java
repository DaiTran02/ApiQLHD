package ngn.api.sanpham.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="sanpham")
@Data
public class SanPhamModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idhopdong;
	private String tensanpham;
	private String loaisanpham;
	private int soluong;
	private String kymahieu;
	private String soidlicsence;
	private String donvitinh;
	private String nhasanxuat;
	private String soseri;
	private Long ngaybatdaubaohanh;
	private int thoigianbaohanh;
	private String ghichu;

}
