package ngn.api.hopdong.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "thongtinphieubaohanh")
@Data
public class PhieuBaoHanhModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idhopdong;
	private String tenlienhe;
	private String sodienthoai;
	private String email;
	private String diachibaohanh;
}
