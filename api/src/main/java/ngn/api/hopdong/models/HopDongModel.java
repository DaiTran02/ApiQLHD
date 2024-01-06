package ngn.api.hopdong.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="hopdong")
@Data
public class HopDongModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idchudautu;
	private Integer idnhaphanphoi;
	private boolean checkxuatphieu;
	private String sohopdong;
	private String goithau;
	private String nhaphanphoi;
	private long ngaykyhopdong;
	private long ngaynghiemthu;
	private int thoigianthuchien;
	private String donvisudung;
}
