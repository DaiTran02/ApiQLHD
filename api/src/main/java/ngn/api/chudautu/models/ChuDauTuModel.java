package ngn.api.chudautu.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="chudautu")
@Data
public class ChuDauTuModel {
	@Id
	@Column(name="idchudautu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tenchudautu")
	private String tenchudautu;
	
	@Column(name = "machudautu")
	private String machudautu;
	
	@Column(name = "diachi")
	private String diachi;
	
	@Column(name = "dienthoai")
	private String dienthoai;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "taikhoan")
	private String taikhoan;
	
	@Column(name = "masothue")
	private String masothue;
	
	@Column(name = "daidien")
	private String daidien;
	
	@Column(name = "chucvu")
	private String chucvu;
	
	
}
